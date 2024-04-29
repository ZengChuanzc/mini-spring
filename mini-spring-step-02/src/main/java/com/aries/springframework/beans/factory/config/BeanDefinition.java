package com.aries.springframework.beans.factory.config;

/**
 * @author zengchuan
 * @version 1.0
 * @date 2024/4/25 17:31
 * @description BeanDefinition
 */
public class BeanDefinition {


    private Class beanClass;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
