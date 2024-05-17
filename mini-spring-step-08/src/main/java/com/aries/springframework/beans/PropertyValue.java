package com.aries.springframework.beans;

/**
 * @author zengchuan
 * @version 1.0
 * @date 2024/5/6 17:00
 * @description PropertyValue
 */
public class PropertyValue {

    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
