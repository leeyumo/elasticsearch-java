package com.leeyumo.elasticsearchJava.domain.constant;

public enum VehicleEnergySource implements StringPropertyEnum{
    PETROL("油车"),
    ELECTRIC("电车"),
    HYBRID("混动车");

    private String name;

    VehicleEnergySource(String name){
        this.name=name;
    }

    @Override
    public String stringValue() {
        return this.name;
    }
}
