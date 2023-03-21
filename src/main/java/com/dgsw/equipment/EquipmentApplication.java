package com.dgsw.equipment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class EquipmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(EquipmentApplication.class, args);
	}

}
