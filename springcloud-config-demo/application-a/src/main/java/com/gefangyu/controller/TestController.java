package com.gefangyu.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @description
 * @data 2020/1/10
 * @authro ge.fangyu
 */
@RestController
@RefreshScope // 支持动态刷新
@RequestMapping("/test")
public class TestController {
    // 加载多个文件,存现相同的key,会被最后一个替换
    @Value("${username}")
    private String username;

    @Value("${password}")
    private String password;

    @Value("${kafka.username}")
    private String kafkaUsername;

    @Value("${kafka.password}")
    private String kafkaPassword;

    @RequestMapping("/getValue")
    public Map<String, String> getValue() {
        Map<String, String> map = new HashMap<>();
        map.put("username", username);
        map.put("password", password);
        map.put("kafkaUsername", kafkaUsername);
        map.put("kafkaPassword", kafkaPassword);
        return map;
    }
}
