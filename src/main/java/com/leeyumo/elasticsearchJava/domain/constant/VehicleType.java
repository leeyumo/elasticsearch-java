package com.leeyumo.elasticsearchJava.domain.constant;

public enum VehicleType implements StringPropertyEnum{
    CAR("轿车"),
    SUV("SUV"),
    ROADSTER("跑车");

    private String name;

    VehicleType(String name){
        this.name=name;
    }

    @Override
    public String stringValue() {
        return this.name;
    }
}
