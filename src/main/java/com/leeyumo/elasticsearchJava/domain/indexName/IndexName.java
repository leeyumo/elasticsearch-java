package com.leeyumo.elasticsearchJava.domain.indexName;

import com.leeyumo.elasticsearchJava.domain.constant.StringPropertyEnum;

public enum IndexName implements StringPropertyEnum {
    BOOK("book"),
    VEHICLE("vehicle");

    private String name;

    IndexName(String name){
        this.name=name;
    }

    @Override
    public String stringValue() {
        return this.name;
    }
}
