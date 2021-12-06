package com.jcheng.common.utils;

import cn.hutool.jwt.JWTUtil;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class JWTTokenUtil {
    public String createToken(Integer uid){
        HashMap<String,Object> map=new HashMap<>();
        map.put("uid",uid);
        return JWTUtil.createToken(map, "1234".getBytes());
    }
}
