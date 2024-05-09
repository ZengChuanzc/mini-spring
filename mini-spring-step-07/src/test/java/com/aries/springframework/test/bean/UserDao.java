package com.aries.springframework.test.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zengchuan
 * @version 1.0
 * @date 2024/5/6 18:00
 * @description UserDao
 */
public class UserDao {


    private static Map<String, String> hashMap = new HashMap<>();

    public void initDataMethod() {
        System.out.println("执行--------init-method");
        hashMap.put("1001", "大帅比1");
        hashMap.put("1002", "大帅比2");
        hashMap.put("1003", "大帅比3");
    }

    public void destroyDataMethod() {
        System.out.println("执行---------destroyMethod");
        hashMap.clear();
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }
}
