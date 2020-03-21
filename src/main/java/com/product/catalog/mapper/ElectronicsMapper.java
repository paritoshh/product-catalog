package com.product.catalog.mapper;

import com.product.catalog.entity.TelevisionData;
import com.product.catalog.entity.WashingMachineData;
import com.product.catalog.model.Television;
import com.product.catalog.model.WashingMachine;
import org.springframework.stereotype.Component;

@Component
public class ElectronicsMapper {

    public TelevisionData mapTelevision(Television product){
        return TelevisionData.tvDataBuilder()
                .serialNumber(product.getSerialNumber())
                .brand(product.getBrand())
                .price(product.getPrice())
                .powerConsumptionStar(product.getPowerConsumptionStar())
                .screenSize(product.getScreenSize())
                .build();
    }
    public WashingMachineData mapWashingMachine(WashingMachine product){
        return WashingMachineData.washingMachineDataBuilder()
                .serialNumber(product.getSerialNumber())
                .brand(product.getBrand())
                .price(product.getPrice())
                .powerConsumptionStar(product.getPowerConsumptionStar())
                .capacity(product.getCapacity())
                .operation(product.getOperation())
                .build();
    }
}