package com.aries.springframework.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zengchuan
 * @version 1.0
 * @date 2024/5/6 17:01
 * @description PropertyValues
 */
public class PropertyValues {

    private final List<PropertyValue> propertyValueList = new ArrayList<>();



    public void addPropertyValue(PropertyValue propertyValue) {
        this.propertyValueList.add(propertyValue);
    }

    public PropertyValue[] getPropertyValues() {
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String propertyName) {
        for (PropertyValue propertyValue : this.propertyValueList) {
            if (propertyValue.getName().equals(propertyName)) {
                return propertyValue;
            }
        }
        return null;

    }

}
