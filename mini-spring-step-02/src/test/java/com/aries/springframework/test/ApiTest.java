package com.aries.springframework.test;

import com.aries.springframework.beans.factory.BeanFactory;
import com.aries.springframework.beans.factory.config.BeanDefinition;
import com.aries.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.aries.springframework.test.bean.UserService;
import org.junit.Test;

/**
 * @author zengchuan
 * @version 1.0
 * @date 2024/4/25 18:00
 * @description ApiTest
 *
 * debug测试
 * userService1 和 beanFactorySingleton 是同一个对象
 * 则证明该 bean 已经被缓存到内存中了
 *
 */
public class ApiTest {

    @Test
    public void test_BeanFactory() {

        //1. 初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        //2. 注册 Bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        //3. 初次获取bean
        UserService userService1 = (UserService) beanFactory.getBean("userService");
        userService1.queryUserInfo();

        //4. 二次获取bean 单例
        UserService beanFactorySingleton = (UserService) beanFactory.getSingleton("userService");
        beanFactorySingleton.queryUserInfo();

    }
}
