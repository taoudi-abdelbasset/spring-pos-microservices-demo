package com.micro_service.billing_service.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Customer {
    private Long id;
    private String nom;
    private String email;
}