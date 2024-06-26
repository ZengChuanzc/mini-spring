package com.aries.springframework.beans.factory.support;

import com.aries.springframework.core.io.DefaultResourceLoader;
import com.aries.springframework.core.io.ResourceLoader;

/**
 * @author zengchuan
 * @version 1.0
 * @date 2024/5/7 12:00
 * @description AbstractBeanDefinitionReader
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader{


    private final BeanDefinitionRegistry registry;

    private ResourceLoader resourceLoader;


    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this(registry, new DefaultResourceLoader());
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
