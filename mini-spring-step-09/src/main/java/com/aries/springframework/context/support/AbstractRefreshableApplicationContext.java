package com.aries.springframework.context.support;

import com.aries.springframework.beans.BeansException;
import com.aries.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.aries.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author zengchuan
 * @version 1.0
 * @date 2024/5/8 15:33
 * @description AbstractRefreshableApplicationContext
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext{
    
    private DefaultListableBeanFactory beanFactory;
    
    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }
    
    

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }
}
