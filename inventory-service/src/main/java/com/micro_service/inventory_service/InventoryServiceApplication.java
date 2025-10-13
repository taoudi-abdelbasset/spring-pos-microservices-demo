package com.micro_service.inventory_service;

import com.micro_service.inventory_service.entities.Product;
import com.micro_service.inventory_service.repo.ProductRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

    @Bean
    CommandLineRunner commandLineRunner(ProductRepo productRepo) {
        return args -> {
            Stream.of("Milk","Fridge","Computer","Printer").forEach((c)->{
                Product product = Product.builder()
                        .name(c)
                        .price(Math.random()*9999 + 1000)
                        .quantity((int)Math.random()*978+100)
                        .build();
                productRepo.save(product);
            });
        };
    }
}
