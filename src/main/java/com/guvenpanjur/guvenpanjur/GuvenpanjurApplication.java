package com.guvenpanjur.guvenpanjur;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.guvenpanjur.guvenpanjur.model.entity.Person;
import com.guvenpanjur.guvenpanjur.service.ZipPerdeBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class GuvenpanjurApplication implements CommandLineRunner {

	public static void main(String[] args) {
		Person sayi = new Person();
		sayi = jsonToJava("deneme.json",Person.class);
		System.out.println(sayi.getSayi()+2);
		SpringApplication.run(GuvenpanjurApplication.class, args);
	}

	@Autowired
	ZipPerdeBrandService zipPerdeBrandService;
	@Override
	public void run(String... args) throws Exception {



		/**
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
		 **/


	}

	public static <T> T jsonToJava(String fileName, Class<T> tClass){
		T t = null;
		File file = new File("src/main/resources/jsonFiles/"+fileName);
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.disable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES);
			t = mapper.readValue(file,tClass);
		}catch (Exception e){
		}
		return t;
	}
}
