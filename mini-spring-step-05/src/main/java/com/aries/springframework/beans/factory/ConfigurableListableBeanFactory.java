package com.aries.springframework.beans.factory;

import com.aries.springframework.beans.BeansException;
import com.aries.springframework.beans.factory.config.AutowireCapableBeanFactory;
import com.aries.springframework.beans.factory.config.BeanDefinition;
import com.aries.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * @author zengchuan
 * @version 1.0
 * @date 2024/5/8 11:20
 * @description ConfigurableListableBeanFactory
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {


    BeanDefinition getBeanDefinition(String beanName) throws BeansException;
}
