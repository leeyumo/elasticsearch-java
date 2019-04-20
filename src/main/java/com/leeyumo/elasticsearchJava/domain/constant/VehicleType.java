package com.leeyumo.elasticsearchJava.domain.constant;

public enum VehicleType implements StringPropertyEnum{
    CAR("轿车"),
    SUV("SUV"),
    ROADSTER("跑车");

    private String value;

    VehicleType(String value){
        this.value=value;
    }

    @Override
    public String getValue() {
        return this.value;
    }
}
