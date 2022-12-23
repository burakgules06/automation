package com.guvenpanjur.guvenpanjur;

import com.guvenpanjur.guvenpanjur.model.entity.Customer;
import com.guvenpanjur.guvenpanjur.model.entity.Offer;
import com.guvenpanjur.guvenpanjur.model.enums.motordirection;
import com.guvenpanjur.guvenpanjur.model.enums.orderstatus;
import com.guvenpanjur.guvenpanjur.model.enums.productinfo;
import com.guvenpanjur.guvenpanjur.repository.OfferRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GuvenpanjurApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuvenpanjurApplication.class, args);
	}



}
