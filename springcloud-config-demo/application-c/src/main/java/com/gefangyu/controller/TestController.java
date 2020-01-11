package com.gefangyu.controller;

import org.springframework.beans.factory.annotation.Value;
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
@RequestMapping("/test")
public class TestController {
    @Value("${username}")
    private String username;

    @Value("${password}")
    private String password;

    @RequestMapping("/getValue")
    public Map<String, String> getValue() {
        Map<String, String> map = new HashMap<>();
        map.put("username", username);
        map.put("password", password);
        return map;
    }
}
