package com.aries.springframework.beans.factory;

import com.aries.springframework.beans.BeansException;

/**
 * @author zengchuan
 * @version 1.0
 * @date 2024/5/17 10:55
 * @description BeanFactoryAware
 *
 * 实现该接口，可以感知到所属的BeanFactory
 */
public interface BeanFactoryAware extends Aware{

    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
