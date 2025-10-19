package com.micro_service.billing_service.repo;

import com.micro_service.billing_service.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepo extends JpaRepository<Bill,Long> {
}
