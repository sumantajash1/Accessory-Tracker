package com.Sumanta.AccessoryTracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.Sumanta.AccessoryTracker.Entity.Product;

@SpringBootApplication
public class AccessoryTrackerApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(AccessoryTrackerApplication.class, args);
		//Product product = context.getBean(Product.class);
	}

}
