package com.aries.springframework.context.support;

import com.aries.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.aries.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author zengchuan
 * @version 1.0
 * @date 2024/5/8 15:51
 * @description AbstractXmlApplicationContext
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext{

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader  = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (null != configLocations) {
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }

    }

    protected abstract String[] getConfigLocations();
}
