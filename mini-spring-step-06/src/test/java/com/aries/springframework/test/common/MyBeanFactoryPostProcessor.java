package com.aries.springframework.test.common;

import com.aries.springframework.beans.BeansException;
import com.aries.springframework.beans.PropertyValue;
import com.aries.springframework.beans.PropertyValues;
import com.aries.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.aries.springframework.beans.factory.config.BeanDefinition;
import com.aries.springframework.beans.factory.config.BeanFactoryPostProcessor;

/**
 * @author zengchuan
 * @version 1.0
 * @date 2024/5/8 16:51
 * @description BeanFactoryPostProcessor
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company", "改为：字节跳动"));
    }

}
