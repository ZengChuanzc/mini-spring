package com.aries.springframework.beans.factory.config;

import com.aries.springframework.beans.BeansException;
import com.aries.springframework.beans.factory.ConfigurableListableBeanFactory;

/**
 * @author zengchuan
 * @version 1.0
 * @date 2024/5/8 14:27
 * @description BeanFactoryPostProcessor
 *
 * 在 Bean对象实例化之前，提供修改BeanDefinition 属性
 */
public interface BeanFactoryPostProcessor {

    /**
     * 在所有的 BeanDefinition 加载完成后，实例化 Bean 对象之前，提供修改 BeanDefinition 属性的机制
     * @param beanFactory
     * @throws BeansException
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
