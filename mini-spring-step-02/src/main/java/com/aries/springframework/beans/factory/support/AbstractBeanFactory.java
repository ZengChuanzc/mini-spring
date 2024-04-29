package com.aries.springframework.beans.factory.support;

import com.aries.springframework.beans.BeansException;
import com.aries.springframework.beans.factory.BeanFactory;
import com.aries.springframework.beans.factory.config.BeanDefinition;

/**
 * @author zengchuan
 * @version 1.0
 * @date 2024/4/25 17:37
 * @description AbstractBeanFactory
 *
 * 使用模版模式定义抽象bean工厂
 *
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) throws BeansException {
        Object bean = getSingleton(name);
        if (null != bean) {
            return bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }


    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;

}
