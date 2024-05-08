package com.aries.springframework.test;

import cn.hutool.core.io.IoUtil;
import com.aries.springframework.beans.PropertyValue;
import com.aries.springframework.beans.PropertyValues;
import com.aries.springframework.beans.factory.config.BeanDefinition;
import com.aries.springframework.beans.factory.config.BeanReference;
import com.aries.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.aries.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import com.aries.springframework.context.support.ClassPathXmlApplicationContext;
import com.aries.springframework.core.io.DefaultResourceLoader;
import com.aries.springframework.core.io.Resource;
import com.aries.springframework.test.bean.UserDao;
import com.aries.springframework.test.bean.UserService;
import com.aries.springframework.test.common.MyBeanFactoryPostProcessor;
import com.aries.springframework.test.common.MyBeanPostProcessor;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

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
    public void test_BeanFactoryPostProcessorAndBeanPostProcessor() {

        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 读取配置文件&注册Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        // 3. BeanDefinition 加载完成 & Bean实例化之前，修改 BeanDefinition 的属性值
        MyBeanFactoryPostProcessor beanFactoryPostProcessor = new MyBeanFactoryPostProcessor();
        beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);

        // 4. Bean实例化之后，修改 Bean 属性信息
        MyBeanPostProcessor beanPostProcessor = new MyBeanPostProcessor();
        beanFactory.addBeanPostProcessor(beanPostProcessor);

        // 5. 获取Bean对象调用方法
        UserService userService = beanFactory.getBean("userService", UserService.class);
        String reslut = userService.queryUserInfo();
        System.out.println(reslut);
    }

    @Test
    public void test_xml() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:springPostProcessor.xml");

        // 2. 获取Bean对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println(result);

    }


}
