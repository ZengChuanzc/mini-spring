package com.aries.springframework.beans.factory.config;

/**
 * @author zengchuan
 * @version 1.0
 * @date 2024/4/25 17:32
 * @description SingletonBeanRegistry
 *
 *  单例注册表
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);

}
