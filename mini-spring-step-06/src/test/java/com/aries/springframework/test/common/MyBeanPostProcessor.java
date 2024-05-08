package com.aries.springframework.test.common;

import com.aries.springframework.beans.BeansException;
import com.aries.springframework.beans.factory.config.BeanPostProcessor;
import com.aries.springframework.test.bean.UserService;

/**
 * @author zengchuan
 * @version 1.0
 * @date 2024/5/8 16:50
 * @description MyBeanPostProcessor
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("userService".equals(beanName)) {
            UserService userService = (UserService) bean;
            userService.setLocation("改为：北京");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

}

