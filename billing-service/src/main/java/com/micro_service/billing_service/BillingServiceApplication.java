package com.micro_service.billing_service;

import com.micro_service.billing_service.entities.Bill;
import com.micro_service.billing_service.entities.ProductItem;
import com.micro_service.billing_service.feign.CustomerRestClient;
import com.micro_service.billing_service.feign.ProductRestClient;
import com.micro_service.billing_service.models.Customer;
import com.micro_service.billing_service.models.Product;
import com.micro_service.billing_service.repo.BillRepo;
import com.micro_service.billing_service.repo.ProductItemRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}

    @Bean
    CommandLineRunner commandLineRunner(
            BillRepo billRepo,
            ProductItemRepo productItemRepo,
            CustomerRestClient customerRestClient,
            ProductRestClient productRestClient
    ){
        return args -> {
            Collection<Customer> customers = customerRestClient.findAllCustomer().getContent();
            Collection<Product> products = productRestClient.findAllProducts().getContent();
            customers.forEach(customer -> {
                Bill bill = Bill.builder()
                        .billingDate(new Date())
                        .customerId(customer.getId())
                        .customer(customer)
                        .build();
                billRepo.save(bill);

                products.forEach(product -> {
                    if(Math.random()<0.7)
                        return;
                    ProductItem productItem = ProductItem.builder()
                            .bill(bill)
                            .productId(product.getId())
                            .product(product)
                            .quantity(1 + new Random().nextInt(10))
                            .unitPrice(product.getPrice())
                            .build();
                    productItemRepo.save(productItem);
                });
            });
        };
    }
}
