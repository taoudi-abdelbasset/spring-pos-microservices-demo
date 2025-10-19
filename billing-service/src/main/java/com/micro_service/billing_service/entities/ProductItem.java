package com.micro_service.billing_service.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.micro_service.billing_service.models.Product;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Getter @Setter @Builder
public class ProductItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Bill bill;
    private String productId;
    private int quantity;
    private double unitPrice;
    @Transient private Product product;

}
