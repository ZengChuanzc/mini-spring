package com.aries.springframework.beans.factory.config;

import com.aries.springframework.beans.BeansException;

/**
 * @author zengchuan
 * @version 1.0
 * @date 2024/5/8 14:44
 * @description BeanPostProcessor
 *
 * 供了修改新实例化 Bean 对象的扩展点
 */
public interface BeanPostProcessor {


    /**
     * 在Bean对象执行初始化方法之前，执行此方式
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;


    /**
     * 在Bean对象执行初始化方法之后，执行此方式
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;

}
