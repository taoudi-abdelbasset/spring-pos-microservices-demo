package com.micro_service.customer_service;

import com.micro_service.customer_service.entities.Customer;
import com.micro_service.customer_service.repos.CustomerRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

    @Bean
    CommandLineRunner start(CustomerRepo customerRepo) {
        return args -> {
            Stream.of("Mohammaed", "anam", "Jilaly", "hornet").forEach(c -> {
                Customer customer = Customer.builder()
                        .nom(c)
                        .email(String.format("%s@gmail.com",c))
                        .build();
                customerRepo.save(customer);
            });

        };
    }
}