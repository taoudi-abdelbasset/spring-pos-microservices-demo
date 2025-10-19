package com.micro_service.billing_service.web;

import com.micro_service.billing_service.entities.Bill;
import com.micro_service.billing_service.feign.CustomerRestClient;
import com.micro_service.billing_service.feign.ProductRestClient;
import com.micro_service.billing_service.repo.BillRepo;
import com.micro_service.billing_service.repo.ProductItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillRestController {
    @Autowired
    private BillRepo billRepo;
    @Autowired
    private ProductItemRepo productItemRepo;
    @Autowired
    private CustomerRestClient customerRestClient;
    @Autowired
    private ProductRestClient productRestClient;

    @GetMapping(path="/bills/{id}")
    public Bill getBill(@PathVariable Long id){
        Bill bill = billRepo.findById(id).get();
        bill.setCustomer(customerRestClient.findCustomerById(bill.getCustomerId()));
        bill.getProductItems().forEach(productItem -> {
            productItem.setProduct(productRestClient.findProductById(productItem.getProductId()));
        });
        return bill;
    }
}
