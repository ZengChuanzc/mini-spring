package com.aries.springframework.beans.factory.config;

import com.aries.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * @author zengchuan
 * @version 1.0
 * @date 2024/5/8 11:22
 * @description ConfigurableBeanFactory
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";
}
