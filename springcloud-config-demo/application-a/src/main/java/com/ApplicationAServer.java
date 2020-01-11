package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @description 应用服务A.
 * @data 2020/1/10
 * @authro ge.fangyu
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ApplicationAServer {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationAServer.class, args);
    }
}
