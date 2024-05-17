package com.aries.springframework.core.io;

import cn.hutool.core.lang.Assert;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author zengchuan
 * @version 1.0
 * @date 2024/5/7 11:49
 * @description DefaultResourceLoader
 */
public class DefaultResourceLoader implements ResourceLoader {

    @Override
    public Resource getResource(String location) {
        Assert.notNull(location, "Location must not be null!");

        if (location.startsWith(CLASSPATH_URL_PERFIX)) {
            return new ClassPathResource(location.substring(CLASSPATH_URL_PERFIX.length()));
        } else {
            try {
                URL url = new URL(location);
                return new UrlResource(url);
            } catch (MalformedURLException e) {
                return new FileSystemResource(location);
            }
        }
    }
}
