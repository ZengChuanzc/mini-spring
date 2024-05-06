package com.aries.springframework.test;

import com.aries.springframework.beans.factory.config.BeanDefinition;
import com.aries.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.aries.springframework.test.bean.UserService;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

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
        UserService userService1 = (UserService) beanFactory.getBean("userService", "大帅比");
        userService1.queryUserInfo();

    }


    @Test
    public void test_cglib() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserService.class);
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });

        Object obj = enhancer.create(new Class[]{String.class}, new Object[]{"大帅比"});
        System.out.println(obj);
    }


    /**
     * 无参实例
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    @Test
    public void test_newInstance() throws InstantiationException, IllegalAccessException {
        UserService userService = UserService.class.newInstance();
        System.out.println(userService);
    }

    @Test
    public void test_constructor() throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Class<UserService> userServiceClass = UserService.class;
        Constructor<UserService> declaredConstructor = userServiceClass.getDeclaredConstructor(String.class);
        UserService userService = declaredConstructor.newInstance("大帅比");
        System.out.println(userService);

    }

    @Test
    public void test_parameterType() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<UserService> userServiceClass = UserService.class;
        Constructor<?>[] declaredConstructors = userServiceClass.getDeclaredConstructors();
        Constructor<?> constructor = null;
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            if (declaredConstructor.getParameterTypes().length == 1) {
                constructor = declaredConstructor;
                break;
            }
        }
        Constructor<UserService> declaredConstructor = userServiceClass.getDeclaredConstructor(constructor.getParameterTypes());
        UserService userService = declaredConstructor.newInstance("大帅比");
        System.out.println(userService);
    }



}
