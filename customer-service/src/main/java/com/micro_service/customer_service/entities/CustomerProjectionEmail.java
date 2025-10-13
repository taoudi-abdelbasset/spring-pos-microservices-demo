package com.micro_service.customer_service.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "mail",types = Customer.class)
public interface CustomerProjectionEmail {
    String getEmail();
}
