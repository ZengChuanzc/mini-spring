package com.aries.springframework.test;

import com.aries.springframework.context.support.ClassPathXmlApplicationContext;
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
    public void test_xml() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        UserService userService = applicationContext.getBean("userService", UserService.class);
        System.out.println("测试结果：" +userService.queryUserInfo()  );


        System.out.println("ApplicationContextAware："+userService.getApplicationContext());
        System.out.println("BeanFactoryAware："+userService.getBeanFactory());
    }


}
