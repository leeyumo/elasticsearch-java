package com.leeyumo.elasticsearchJava.domain.constant;

public enum VehicleSize implements StringPropertyEnum{
    A("A"),
    B("B"),
    C("C"),
    D("D");

    private String value;

    VehicleSize(String value){
        this.value=value;
    }

    @Override
    public String getValue() {
        return this.value;
    }
}
