package com.micro_service.billing_service.repo;

import com.micro_service.billing_service.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductItemRepo extends JpaRepository<ProductItem,Long> {
    List<ProductItem> findByBillId(Long bullId);
}
