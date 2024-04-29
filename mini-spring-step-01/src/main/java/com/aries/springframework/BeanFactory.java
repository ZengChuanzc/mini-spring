package com.aries.springframework;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zengchuan
 * @version 1.0
 * @date 2024/4/25 16:06
 * @description BeanFactory
 */
public class BeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }


    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
    }

}
