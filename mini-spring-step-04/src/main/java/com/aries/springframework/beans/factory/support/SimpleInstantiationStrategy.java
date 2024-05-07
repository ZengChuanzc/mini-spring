package com.aries.springframework.beans.factory.support;

import com.aries.springframework.beans.BeansException;
import com.aries.springframework.beans.InstantiationStrategy;
import com.aries.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author zengchuan
 * @version 1.0
 * @date 2024/5/6 12:02
 * @description SimpleInstantiationStrategy
 *
 * JDK实例化
 *
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {


    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {

        // 获取bean的class信息  class信息是在bean定义时候传递进去的
        Class clazz = beanDefinition.getBeanClass();

        try {
            //有参，使用有参构造函数实例化
            if (null != ctor) {
                return clazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
            } else {
                //无参，无构造函数实例化
                return clazz.getDeclaredConstructor().newInstance();
            }
        } catch (InstantiationException  | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new BeansException("Failed to instantiate [" + clazz.getName() + "]", e);
        }
    }
}
