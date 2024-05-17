package com.aries.springframework.beans.factory;

import com.aries.springframework.beans.BeansException;

/**
 * @author zengchuan
 * @version 1.0
 * @date 2024/5/9 11:23
 * @description InitializingBean
 */
public interface InitializingBean {


    /**
     * Bean 处理了属性填充后调用
     * @throws BeansException
     */
    void afterPropertiesSet() throws BeansException;
}
