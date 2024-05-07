package com.aries.springframework.beans;

import com.aries.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @author zengchuan
 * @version 1.0
 * @date 2024/4/29 15:55
 * @description InstantiationStrategy
 */
public interface InstantiationStrategy {


    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor, Object[] args) throws BeansException;

}
