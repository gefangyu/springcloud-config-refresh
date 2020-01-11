package com;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

/**
 * @author ge.fangyu
 * @version 1.0.0
 * @description 测试加解密
 * @date 2020-01-11 20:57
 * @since JDK 1.8
 */
public class TestEncrypt {

    @Test
    public void testEncrypt(){
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.postForObject("http://localhost:8888/encrypt", "test张三",String.class);
        System.out.println("result1: " + result);
        result = restTemplate.postForObject("http://localhost:8888/decrypt", result, String.class); // 解密中文会乱码,是该接口响应编码问题.
        System.out.println("result2: " + result);
    }

    @Test
    public void testDecrypt(){
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.postForObject("http://localhost:8888/decrypt", "07ee25ce8d9fbb6d11669c44e388f80b2f2ee369d7848619bea47dbf191e951a",String.class);
        System.out.println("result: " + result);
    }

    @Test
    public void testGetValue(){
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.postForObject("http://127.0.0.1:8083/testc/test/getValue", "", String.class);
        System.out.println("result: " + result); // 中文正常
    }
}
