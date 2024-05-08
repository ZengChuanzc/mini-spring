package com.aries.springframework.beans.factory;

import com.aries.springframework.beans.BeansException;

import java.util.Map;

/**
 * @author zengchuan
 * @version 1.0
 * @date 2024/5/8 11:11
 * @description ListableBeanFactory
 */
public interface ListableBeanFactory extends BeanFactory{


    /**
     * 按照类型返回 Bean 实例
     * @param type
     * @return
     * @param <T>
     * @throws BeansException
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;


    /**
     * 返回此注册中心中定义的所有bean的名称。
     * @return
     */
    String[] getBeanDefinitionNames();

}
