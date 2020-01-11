package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author ge.fangyu
 * @version 1.0.0
 * @description 应用服务B.
 * @date 2020-01-10 07:30
 * @since JDK 1.8
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ApplicationBServer {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationBServer.class, args);
    }
}
