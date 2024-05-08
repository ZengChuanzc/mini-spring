package com.aries.springframework.beans.factory.config;

/**
 * @author zengchuan
 * @version 1.0
 * @date 2024/5/6 17:49
 * @description BeanReference
 *
 * Bean 的引用
 */
public class BeanReference {


    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
