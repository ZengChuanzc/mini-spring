package com.aries.springframework.beans.factory.support;

import com.aries.springframework.beans.BeansException;
import com.aries.springframework.core.io.Resource;
import com.aries.springframework.core.io.ResourceLoader;

/**
 * @author zengchuan
 * @version 1.0
 * @date 2024/5/7 11:56
 * @description BeanDefinitionReader
 */
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();


    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;
}
