package com.aries.springframework.test;

import cn.hutool.core.io.IoUtil;
import com.aries.springframework.beans.PropertyValue;
import com.aries.springframework.beans.PropertyValues;
import com.aries.springframework.beans.factory.config.BeanDefinition;
import com.aries.springframework.beans.factory.config.BeanReference;
import com.aries.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.aries.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import com.aries.springframework.core.io.DefaultResourceLoader;
import com.aries.springframework.core.io.Resource;
import com.aries.springframework.test.bean.UserDao;
import com.aries.springframework.test.bean.UserService;
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



    private DefaultResourceLoader resourceLoader;

    @Before
    public void init() {
        resourceLoader = new DefaultResourceLoader();
    }

    @Test
    public void test_BeanFactory() {

        //1. 初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        //2. 注册 Bean
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));


        //3. UserService 设置属性[uId、userDao]
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "1001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));


        // 4. UserService 注入bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 5. UserService 获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();


    }


    @Test
    public void test_classpath() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:important.properties");
        InputStream inputStream = resource.getInputStream();
        String con = IoUtil.readUtf8(inputStream);
        System.out.println(con);
    }

    @Test
    public void test_file() throws IOException {
        Resource resource = resourceLoader.getResource("src/test/resources/important.properties");
        InputStream inputStream = resource.getInputStream();
        String con = IoUtil.readUtf8(inputStream);
        System.out.println(con);
    }


    @Test
    public void test_url() throws IOException {
        Resource resource = resourceLoader.getResource("https://github.com/fuzhengwei/small-spring/blob/main/important.properties");
        InputStream inputStream = resource.getInputStream();
        String con = IoUtil.readUtf8(inputStream);
        System.out.println(con);
    }

    @Test
    public void test_xml() {
        // 1. 初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 读取配置文件且注册bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        // 3. 获取bean对象调用方法
        UserService userService = beanFactory.getBean("userService", UserService.class);
        System.out.println(userService.queryUserInfo());
    }


}
