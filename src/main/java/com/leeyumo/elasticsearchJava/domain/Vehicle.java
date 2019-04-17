package com.leeyumo.elasticsearchJava.domain;

import com.leeyumo.elasticsearchJava.domain.constant.VehicleBrand;
import com.leeyumo.elasticsearchJava.domain.constant.VehicleEnergySource;
import com.leeyumo.elasticsearchJava.domain.constant.VehicleSize;
import com.leeyumo.elasticsearchJava.domain.constant.VehicleType;
import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@ApiModel
public class Vehicle {
    private String name;//速腾
    private int price;//150000
    private VehicleBrand brand;//大众
    private VehicleSize size;//A (A级车)
    private VehicleType vehicleType;//轿车；跑车；SUV
    private VehicleEnergySource energySource;//油车电车混动车
    private String description;//国内大众经典车型
}
