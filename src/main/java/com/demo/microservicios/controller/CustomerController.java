package com.demo.microservicios.controller;

import com.demo.microservicios.entity.Customer;
import com.demo.microservicios.repository.CustomerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {


    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Customer> findById(@PathVariable Long id) {
        return customerRepository.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody Customer input) {
        Customer customer = customerRepository.save(input);
        return ResponseEntity.ok(customer);
    }
}
