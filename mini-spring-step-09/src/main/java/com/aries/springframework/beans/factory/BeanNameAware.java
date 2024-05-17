package com.aries.springframework.beans.factory;

/**
 * @author zengchuan
 * @version 1.0
 * @date 2024/5/17 10:59
 * @description BeanNameAware
 */
public interface BeanNameAware extends Aware{

    void setBeanName(String name);
}
