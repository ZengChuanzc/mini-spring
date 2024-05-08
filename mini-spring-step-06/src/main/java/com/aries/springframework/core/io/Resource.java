package com.aries.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author zengchuan
 * @version 1.0
 * @date 2024/5/7 11:21
 * @description Resource
 *
 * 处理资源加载流
 */
public interface Resource {

    InputStream getInputStream() throws IOException;
}
