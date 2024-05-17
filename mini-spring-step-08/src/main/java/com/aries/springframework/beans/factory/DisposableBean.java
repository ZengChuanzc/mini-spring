package com.aries.springframework.beans.factory;

import com.aries.springframework.beans.BeansException;

/**
 * @author zengchuan
 * @version 1.0
 * @date 2024/5/9 11:24
 * @description DisposableBean
 */
public interface DisposableBean {

    /**
     * Bean 销毁
     * @throws BeansException
     */
    void destroy() throws Exception;
}
