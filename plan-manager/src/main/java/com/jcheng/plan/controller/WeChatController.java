package com.jcheng.plan.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.fastjson.JSONObject;
import com.jcheng.common.constants.Constants;
import com.jcheng.common.domain.R;
import com.jcheng.common.utils.WeChatUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("wechat")
@RestController
public class WeChatController {
    @GetMapping("phone")
    public R<JSONObject> getPhone(String encryptedData, String iv) {
        JSONObject session = (JSONObject) StpUtil.getSession().get(Constants.WECHAT_SESSION);
        String session_key = (String) session.get("session_key");
        String phoneRes = WeChatUtils.wxDecrypt(encryptedData, iv, session_key);
        JSONObject jsonObject = JSONObject.parseObject(phoneRes);
        return R.ok(jsonObject);
    }
}
