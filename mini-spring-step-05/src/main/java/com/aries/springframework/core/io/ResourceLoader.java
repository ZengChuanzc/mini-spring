package com.aries.springframework.core.io;

/**
 * @author zengchuan
 * @version 1.0
 * @date 2024/5/7 11:46
 * @description ResourceLoader
 *
 * 获取资源接口，里面传递 location 地址即可
 */
public interface ResourceLoader {

    /**
     * Pseduo URL prefix for loading from the class path: "classpath"
     */
    String CLASSPATH_URL_PERFIX = "classpath:";


    Resource getResource(String location);

}
