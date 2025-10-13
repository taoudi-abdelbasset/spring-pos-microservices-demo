package com.micro_service.customer_service.repos;

import com.micro_service.customer_service.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CustomerRepo  extends JpaRepository<Customer,Long> {
}
