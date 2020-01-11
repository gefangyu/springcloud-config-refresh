package com.gefangyu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 *
 * @author ge.fangyu
 * @version 1.0.0
 * @description RestTemplate相关配置处理,主要处理编码乱码.
 * @date 2020-01-11 21:18
 * @since JDK 1.8
 */
// @Configuration
public class RestTemplateConfiguration {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    public RestTemplate restTemplate() {
        RestTemplate restTemplate = restTemplateBuilder.setReadTimeout(10000).build();
        List<HttpMessageConverter<?>> list = restTemplate.getMessageConverters();
        FormHttpMessageConverter formHttpMessageConverter = new FormHttpMessageConverter();
        list.add(formHttpMessageConverter);
        // 处理表单,附件乱码问题
        for (HttpMessageConverter<?> converter : list) {
            if (converter instanceof StringHttpMessageConverter) {
                ((StringHttpMessageConverter)converter).setDefaultCharset(StandardCharsets.UTF_8);
            }
            if (converter instanceof FormHttpMessageConverter) {
                ((FormHttpMessageConverter)converter).setCharset(StandardCharsets.UTF_8);
                ((FormHttpMessageConverter)converter).setMultipartCharset(StandardCharsets.UTF_8);
            }
        }
        return restTemplate;
    }

}
