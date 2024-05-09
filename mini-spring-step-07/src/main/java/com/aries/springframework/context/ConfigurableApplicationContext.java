package com.aries.springframework.context;

import com.aries.springframework.beans.BeansException;

/**
 * @author zengchuan
 * @version 1.0
 * @date 2024/5/8 14:52
 * @description ConfigurableApplicationContext
 */
public interface ConfigurableApplicationContext extends ApplicationContext{

    /**
     * 刷新容器
     * @throws BeansException
     */
    void refresh() throws BeansException;


    /**
     * 注册虚拟机钩子
     */
    void registerShutdownHook();

    /**
     * 关闭
     */
    void close();



}
