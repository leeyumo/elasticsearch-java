package com.leeyumo.elasticsearchJava.domain.constant;

public enum VehicleEnergySource implements StringPropertyEnum{
    PETROL("油车"),
    ELECTRIC("电车"),
    HYBRID("混动车");

    private String value;

    VehicleEnergySource(String value){
        this.value=value;
    }

    @Override
    public String getValue() {
        return this.value;
    }
}
