package com.leeyumo.elasticsearchJava.domain.constant;

public enum VehicleSize implements StringPropertyEnum{
    A("A"),
    B("B"),
    C("C"),
    D("D");

    private String name;

    VehicleSize(String name){
        this.name=name;
    }

    @Override
    public String stringValue() {
        return this.name;
    }
}
