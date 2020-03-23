package com.product.catalog.testdata;

import com.product.catalog.model.Television;
import com.product.catalog.model.WashingMachine;

public class TestData {

    public static Television getTelevision(){
        Television tvTestData = new Television();
        tvTestData.setSerialNumber("001");
        tvTestData.setPrice("2400");
        tvTestData.setProductType("TV");
        tvTestData.setDescription("Android tv");
        tvTestData.setBrand("MI");
        tvTestData.setScreenSize("12-inch");
        tvTestData.setPowerConsumptionStar(3);
        return tvTestData;
    }

    public static WashingMachine getWashingMachine() {
        WashingMachine washingMachineTestData = new WashingMachine();
        washingMachineTestData.setSerialNumber("001");
        washingMachineTestData.setPrice("2400");
        washingMachineTestData.setProductType("TV");
        washingMachineTestData.setDescription("Android tv");
        washingMachineTestData.setBrand("MI");
        washingMachineTestData.setCapacity("28KG");
        washingMachineTestData.setOperation("Front load");
        washingMachineTestData.setPowerConsumptionStar(3);
        return washingMachineTestData;
    }
}
