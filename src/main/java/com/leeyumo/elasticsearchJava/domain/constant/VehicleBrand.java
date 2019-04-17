package com.leeyumo.elasticsearchJava.domain.constant;

public enum VehicleBrand implements StringPropertyEnum{
    DasAuto("大众"),
    Honda("本田"),
    Toyota("丰田"),
    Nissan("尼桑"),
    Ford("福特"),
    Buick("别克"),
    Benz("奔驰"),
    BMW("宝马"),
    Audi("奥迪");

    private String name;

    VehicleBrand(String name){
        this.name=name;
    }


    @Override
    public String stringValue() {
        return this.name;
    }
}
