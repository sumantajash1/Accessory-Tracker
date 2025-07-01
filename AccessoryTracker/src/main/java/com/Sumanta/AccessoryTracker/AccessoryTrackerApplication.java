package com.Sumanta.AccessoryTracker;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.Sumanta.AccessoryTracker.Entity.Product;

@SpringBootApplication
public class AccessoryTrackerApplication {

	public static void main(String[] args) {
    Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
    dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));
    ApplicationContext context = SpringApplication.run(AccessoryTrackerApplication.class, args);
}

}
