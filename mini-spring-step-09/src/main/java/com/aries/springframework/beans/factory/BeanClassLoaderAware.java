package com.aries.springframework.beans.factory;

import com.aries.springframework.beans.BeansException;

/**
 * @author zengchuan
 * @version 1.0
 * @date 2024/5/17 10:56
 * @description BeanClassLoaderAware
 *
 * 实现该接口，可以感知到所属的ClassLoader
 */
public interface BeanClassLoaderAware extends Aware{


    void setBeanClassLoader(ClassLoader classLoader) throws BeansException;
}
