package com.jcheng.common.utils;

import cn.hutool.core.codec.Base64;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jcheng.common.config.WeChatKeys;
import com.jcheng.common.constants.RedisKey;
import com.jcheng.common.exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class WeChatUtils {
    public static WeChatKeys weChatKeys;
    public static RedisTemplate<String, Object> redisTemplate;
    @Autowired
    RedisTemplate<String, Object> redisTemplate2;

    @PostConstruct
    public void init() {
        weChatKeys = SpringBeanFactory.getBean(WeChatKeys.class);
        redisTemplate = this.redisTemplate2;
    }

    public static String wxDecrypt(String encryptedData, String vi, String sessionKey) {
        try {
            // 开始解密
            byte[] encData = cn.hutool.core.codec.Base64.decode(encryptedData);
            byte[] iv = cn.hutool.core.codec.Base64.decode(vi);
            byte[] key = Base64.decode(sessionKey);
            AlgorithmParameterSpec ivSpec = new IvParameterSpec(iv);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
            cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
            return new String(cipher.doFinal(encData), "UTF-8");
        } catch (Exception e) {
            throw new CustomException("手机号解析失败");
        }
    }

    public static JSONObject getSession(String code) {
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid={0}&secret={1}&js_code={2}&grant_type=authorization_code";
        url = url.replace("{0}", weChatKeys.getAppId()).replace("{1}", weChatKeys.getAppSecret().trim()).replace("{2}", code);
        String res = HttpUtil.get(url);
        JSONObject jsonObject = JSONObject.parseObject(res);
        if (jsonObject.get("openid") != null) {
            return jsonObject;
        }
        throw new CustomException("获取Session失败");
    }

    public static String getAccessToken() throws IOException {
        String access_token = (String) redisTemplate.opsForValue().get(RedisKey.ACCESS_TOKEN);
        if (access_token == null) {
            log.info("正在获取accessKey");
            Connection connect = Jsoup.connect("https://api.weixin.qq.com/cgi-bin/token");
            connect.data("grant_type", "client_credential").data("appid", weChatKeys.getAppId())
                    .data("secret", weChatKeys.getAppSecret());
            connect.header("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
            Connection.Response response = connect.method(Connection.Method.GET).ignoreContentType(true).execute();
            JSONObject jsonObject = JSON.parseObject(response.body());
            access_token = (String) jsonObject.get("access_token");
            Integer expires_in = (Integer) jsonObject.get("expires_in");
            redisTemplate.opsForValue().set(RedisKey.ACCESS_TOKEN, access_token, expires_in, TimeUnit.SECONDS);
        }
        return access_token;
    }
}
