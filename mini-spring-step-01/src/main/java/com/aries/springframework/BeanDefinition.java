package com.aries.springframework;

/**
 * @author zengchuan
 * @version 1.0
 * @date 2024/4/25 16:01
 * @description BeanDefinition
 */
public class BeanDefinition {

    private Object bean;


    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }
}
