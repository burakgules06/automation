package com.guvenpanjur.guvenpanjur;

import com.guvenpanjur.guvenpanjur.model.dto.request.RequestMotorSave;
import com.guvenpanjur.guvenpanjur.model.dto.request.RequestMotorTypeSave;
import com.guvenpanjur.guvenpanjur.model.entity.Customer;
import com.guvenpanjur.guvenpanjur.model.entity.Offer;
import com.guvenpanjur.guvenpanjur.repository.OfferRepository;
import com.guvenpanjur.guvenpanjur.service.ZipPerdeBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.ArrayList;

@SpringBootApplication
public class GuvenpanjurApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(GuvenpanjurApplication.class, args);
	}

	@Autowired
	ZipPerdeBrandService zipPerdeBrandService;

	@Override
	public void run(String... args) throws Exception {
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
	}
}
