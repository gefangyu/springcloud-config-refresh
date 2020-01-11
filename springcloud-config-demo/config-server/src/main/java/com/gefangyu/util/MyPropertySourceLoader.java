package com.gefangyu.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.env.PropertySourceLoader;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * 参考文档: https://blog.csdn.net/sinat_38843093/article/details/79960777
 * @author ge.fangyu
 * @version 1.0.0
 * @description 资源加载处理器,解决中文乱码问题(即配置中有中文,则需要处理乱码问题).
 * @date 2020-01-11 18:30
 * @since JDK 1.8
 */
public class MyPropertySourceLoader implements PropertySourceLoader {

    private static final Logger logger = LoggerFactory.getLogger(MyPropertySourceLoader.class);

    @Override
    public String[] getFileExtensions() {
        return new String[]{"properties", "xml"};
    }

    @Override
    public PropertySource<?> load(String name, Resource resource, String profile) throws IOException {
        if (profile == null) {
            Properties properties = getProperties(resource);
            if (!properties.isEmpty()) {
                return new PropertiesPropertySource(name, properties);
            }
        }
        logger.warn("profile is null!");
        return null;
    }

    private Properties getProperties(Resource resource) {
        Properties properties = new Properties();
        InputStream inputStream = null;
        try {
            inputStream = resource.getInputStream();
            properties.load(new InputStreamReader(inputStream, StandardCharsets.UTF_8.toString()));
            inputStream.close();
        } catch (IOException e) {
            logger.error("load inputstream failure!", e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    logger.error("close IO failure!", e);
                }
            }
        }
        return properties;
    }

}
