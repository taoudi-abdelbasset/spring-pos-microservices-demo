package com.micro_service.billing_service.models;

import lombok.*;

@Getter
@Setter
public class Product {
    private String id;
    private String name;
    private double price;
    private int quantity;
}
