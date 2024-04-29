package com.aries.springframework.beans.factory.support;

import com.aries.springframework.beans.BeansException;
import com.aries.springframework.beans.factory.config.BeanDefinition;

/**
 * @author zengchuan
 * @version 1.0
 * @date 2024/4/25 17:46
 * @description AbstractOverwireCapableBeanFactory
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {


    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {

        Object bean = null;

        try {
            // 通过反射获取bean的实例
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("Instantiation of bean failed", e);
        }

        addSingleton(beanName, bean);

        return bean;
    }
}
