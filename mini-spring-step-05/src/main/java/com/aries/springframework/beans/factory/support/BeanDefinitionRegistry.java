package com.aries.springframework.beans.factory.support;

import com.aries.springframework.beans.factory.config.BeanDefinition;

/**
 * @author zengchuan
 * @version 1.0
 * @date 2024/4/25 17:54
 * @description BeanDefinitionRegistry
 */
public interface BeanDefinitionRegistry {


    /**
     * 向注册表中注册 BeanDefinition
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    /**
     * 判断是否包含指定名称的BeanDefinition
     * @return
     */
    boolean containsBeanDefinition(String beanName);
}
