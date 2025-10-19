package com.micro_service.billing_service.feign;

import com.micro_service.billing_service.models.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "customer-service")
public interface CustomerRestClient {
    @GetMapping("api/customers/{id}")
    Customer findCustomerById(@PathVariable Long id);
    @GetMapping("api/customers")
    PagedModel<Customer> findAllCustomer();
}
