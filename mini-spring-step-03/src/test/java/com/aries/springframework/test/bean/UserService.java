package com.aries.springframework.test.bean;

/**
 * @author zengchuan
 * @version 1.0
 * @date 2024/4/25 17:59
 * @description UserService
 */
public class UserService {


    private String name;

    public UserService() {
    }

    public UserService(String name) {
        this.name = name;
    }

    public void queryUserInfo() {
        System.out.println("查询用户信息："+ name);
    }


    /*@Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("");
        sb.append("").append(name);
        return sb.toString();
    }*/

    @Override
    public String toString() {
        return "UserService{" +
                "name='" + name + '\'' +
                '}';
    }
}
