package com.berkanaslan.springdemo.rest;

import com.berkanaslan.springdemo.entity.Customer;
import com.berkanaslan.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Berkan Aslan
 * 4.04.2021
 */

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId) {
        Customer customer = customerService.getCustomer(customerId);

        if (customer == null) {
            throw new CustomerNotFoundException("Customer not found. - " + customerId);
        }

        return customer;
    }
}
