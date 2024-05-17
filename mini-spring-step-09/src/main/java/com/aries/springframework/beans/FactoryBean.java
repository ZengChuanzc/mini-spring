package com.aries.springframework.beans;

/**
 * @author zengchuan
 * @version 1.0
 * @date 2024/5/17 16:29
 * @description FactoryBean
 */
public interface FactoryBean<T> {


    T getObject() throws BeansException;


    Class<?> getObjectType();

    boolean isSingleton();


}
