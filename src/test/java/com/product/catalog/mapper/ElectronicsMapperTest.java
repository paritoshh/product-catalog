package com.product.catalog.mapper;

import com.product.catalog.entity.TelevisionData;
import com.product.catalog.entity.WashingMachineData;
import com.product.catalog.model.Television;
import com.product.catalog.model.WashingMachine;
import com.product.catalog.testdata.TestData;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import static org.junit.Assert.assertEquals;

@TestExecutionListeners({DependencyInjectionTestExecutionListener.class})
@RunWith(SpringRunner.class)
public class ElectronicsMapperTest {

    private ElectronicsMapper electronicsMapper;

    @Before
    public void setup(){
        this.electronicsMapper = new ElectronicsMapper();
    }

    @Test
    public void mapTelevisionTest(){
        Television testTVData = TestData.getTelevision();
        TelevisionData response = electronicsMapper.mapTelevision(testTVData);
        assertEquals("Serial number is not correctly mapped", testTVData.getSerialNumber(), response.getSerialNumber());
        assertEquals("Brand is not correctly mapped", testTVData.getBrand(), response.getBrand());
        assertEquals("Price is not correctly mapped", testTVData.getPrice(), response.getPrice());
        assertEquals("Product type is not correctly mapped", testTVData.getProductType(), response.getProductType());
        assertEquals("Description is not correctly mapped", testTVData.getDescription(), response.getDescription());
        assertEquals("Screen size number is not correctly mapped", testTVData.getScreenSize(), response.getScreenSize());
        assertEquals("Power consumption is not correctly mapped", testTVData.getPowerConsumptionStar(), response.getPowerConsumptionStar());
    }

    @Test
    public void mapWashingMachineTest(){
        WashingMachine testWMData = TestData.getWashingMachine();
        WashingMachineData response = electronicsMapper.mapWashingMachine(testWMData);
        assertEquals("Serial number is not correctly mapped", testWMData.getSerialNumber(), response.getSerialNumber());
        assertEquals("Brand is not correctly mapped", testWMData.getBrand(), response.getBrand());
        assertEquals("Price is not correctly mapped", testWMData.getPrice(), response.getPrice());
        assertEquals("Product type is not correctly mapped", testWMData.getProductType(), response.getProductType());
        assertEquals("Description is not correctly mapped", testWMData.getDescription(), response.getDescription());
        assertEquals("Washing machine capacity is not correctly mapped", testWMData.getCapacity(), response.getCapacity());
        assertEquals("Washing machine load type is not correctly mapped", testWMData.getOperation(), response.getOperation());
        assertEquals("Power consumption is not correctly mapped", testWMData.getPowerConsumptionStar(), response.getPowerConsumptionStar());
    }
}