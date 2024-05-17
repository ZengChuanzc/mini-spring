package com.aries.springframework.beans.factory.support;

import com.aries.springframework.beans.BeansException;
import com.aries.springframework.beans.InstantiationStrategy;
import com.aries.springframework.beans.factory.config.BeanDefinition;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

/**
 * @author zengchuan
 * @version 1.0
 * @date 2024/5/6 12:12
 * @description CglibSubclassingInstantiationStrategy
 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy {


    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        //同JDK实例化一样  当为无参构造函数时，直接实例化
        if (null == ctor) {
            return enhancer.create();
        }
        //当为有参构造函数时，使用有参构造函数实例化
        return enhancer.create(ctor.getParameterTypes(), args);
    }
}
