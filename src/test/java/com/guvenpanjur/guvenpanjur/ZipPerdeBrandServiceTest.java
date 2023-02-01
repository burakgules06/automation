package com.guvenpanjur.guvenpanjur;

import com.guvenpanjur.guvenpanjur.model.dto.request.RequestMotorSave;
import com.guvenpanjur.guvenpanjur.model.dto.request.RequestMotorTypeSave;
import com.guvenpanjur.guvenpanjur.service.ZipPerdeBrandService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;

@SpringBootTest
public class ZipPerdeBrandServiceTest {

    ZipPerdeBrandService zipPerdeBrandService;

    @Autowired
    public ZipPerdeBrandServiceTest(ZipPerdeBrandService zipPerdeBrandService) {
        this.zipPerdeBrandService = zipPerdeBrandService;
    }

    @Test
    public void saveMotorTest(){
        RequestMotorSave motorSave=new RequestMotorSave();
        motorSave.setName("Test-Motor-Name");
        motorSave.setMotorType(new ArrayList<>());
        for (int i = 0; i <5 ; i++) {
            RequestMotorTypeSave motorTypeSave=new RequestMotorTypeSave();
            motorTypeSave.setModel("Test-Model");
            motorTypeSave.setUnitCost(new BigDecimal(15));
            motorSave.getMotorType().add(motorTypeSave);
        }
        zipPerdeBrandService.saveMotor(motorSave);
        var motor=zipPerdeBrandService.getAllMotor();
        motor.forEach(responseMotor -> {
            System.out.println("@@@@@Motor Name: "+responseMotor.getName()+"--Id: "+responseMotor.getId());
            responseMotor.getMotorTypes().forEach(responseMotorType -> {
                System.out.println("@@@@@Motor Model: "+responseMotorType.getModel()+"--Id: "+responseMotorType.getId());
            });
        });
    }
}
