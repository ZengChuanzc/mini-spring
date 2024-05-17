package com.aries.springframework.beans.factory;

import com.aries.springframework.beans.BeansException;
import com.aries.springframework.context.ApplicationContext;

/**
 * @author zengchuan
 * @version 1.0
 * @date 2024/5/17 11:01
 * @description ApplicationContextAware
 *
 * 实现该接口，可以感知到所属的ApplicationContext
 */
public interface ApplicationContextAware extends Aware{


    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
