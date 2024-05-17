package com.aries.springframework.test.bean;

import com.aries.springframework.beans.BeansException;
import com.aries.springframework.beans.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zengchuan
 * @version 1.0
 * @date 2024/5/17 16:52
 * @description ProxyBeanFactory
 */
public class ProxyBeanFactory implements FactoryBean<IUserDao> {


    @Override
    public IUserDao getObject() throws BeansException {

        InvocationHandler handler = (proxy, method, args) -> {

            Map<String, String> hashMap = new HashMap<>();

            hashMap.put("1001", "大帅比1");
            hashMap.put("1002", "大帅比2");
            hashMap.put("1003", "大帅比3");

            return "你被代理了 " + method.getName() + "：" + hashMap.get(args[0].toString());
        };


        return (IUserDao) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{IUserDao.class}, handler);
    }

    @Override
    public Class<?> getObjectType() {
        return IUserDao.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
