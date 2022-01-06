package com.jcheng.common.interceptor.impl;

import com.alibaba.fastjson.JSONObject;
import com.jcheng.common.interceptor.RepeatSubmitInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
public class SameUrlDataInterceptor extends RepeatSubmitInterceptor {
    public final String REPEAT_PARAMS = "repeatParams";

    public final String REPEAT_TIME = "repeatTime";

    // 令牌自定义标识
    @Value("${sa-token.token-name}")
    private String header;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 间隔时间，单位:秒 默认10秒
     * <p>
     * 两次相同参数的请求，如果间隔时间大于该参数，系统不会认定为重复提交的数据
     */
    private int intervalTime = 10;

    public void setIntervalTime(int intervalTime) {
        this.intervalTime = intervalTime;
    }

    @Override
    public boolean isRepeatSubmit(HttpServletRequest request) {
        // 请求地址（作为存放cache的key值）
        String url = request.getRequestURI();
        request.getRemoteUser();
        return false;
    }

    /**
     * 判断参数是否相同
     */
    private boolean compareParams(Map<String, Object> nowMap, Map<String, Object> preMap) {
        String nowParams = (String) nowMap.get(REPEAT_PARAMS);
        String preParams = (String) preMap.get(REPEAT_PARAMS);
        return nowParams.equals(preParams);
    }

    /**
     * 判断两次间隔时间
     */
    private boolean compareTime(Map<String, Object> nowMap, Map<String, Object> preMap) {
        long time1 = (Long) nowMap.get(REPEAT_TIME);
        long time2 = (Long) preMap.get(REPEAT_TIME);
        if ((time1 - time2) < (this.intervalTime * 1000)) {
            return true;
        }
        return false;
    }
}