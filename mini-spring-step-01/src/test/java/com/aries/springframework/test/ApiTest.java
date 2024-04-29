package com.aries.springframework.test;

import com.aries.springframework.BeanDefinition;
import com.aries.springframework.BeanFactory;
import com.aries.springframework.test.bean.UserService;
import org.junit.Test;

/**
 * @author zengchuan
 * @version 1.0
 * @date 2024/4/25 16:14
 * @description ApiTest
 */
public class ApiTest {


    @Test
    public void test_BeanFactory() {

        //1. 初始化bean工程
        BeanFactory beanFactory = new BeanFactory();

        //2. 注入bean
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        //3. 获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();

    }


}
