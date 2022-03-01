package com.restaurante.custumerservice.controller;

import com.restaurante.custumerservice.domain.entities.CustomerModel;
import com.restaurante.custumerservice.exception.ResourceNotFoundException;
import com.restaurante.custumerservice.repositories.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author https://github.com/alisonrodolfo
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/custumer")
public class CoreRestController {
    /* Created by Alison on 28/02/2022 */

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/getall")
    public List<CustomerModel> getAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity< CustomerModel > getCustomerById(@PathVariable(value = "id") Long customerId)
            throws ResourceNotFoundException {
        CustomerModel customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found :: " + customerId));
        log.info("Cadastrando um novo cliente com as informações [{}]", customer);
        return ResponseEntity.ok().body(customer);
    }

    @PostMapping("/add")
    public CustomerModel createCustomer(@Validated @RequestBody CustomerModel customer) {
        return customerRepository.save(customer);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity < CustomerModel > updateCustomer(@PathVariable(value = "id") Long customerId,
                                                      @Validated @RequestBody CustomerModel customerDetails) throws ResourceNotFoundException {
        CustomerModel customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + customerId));

        customer.setName(customerDetails.getName());
        customer.setObservacoes(customerDetails.getObservacoes());
        final CustomerModel updateCustomer = customerRepository.save(customer);
        return ResponseEntity.ok(updateCustomer);
    }

    @DeleteMapping("/delete/{id}")
    public Map< String, Boolean > deleteCustomer(@PathVariable(value = "id") Long customerId)
            throws ResourceNotFoundException {
        CustomerModel customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + customerId));

        customerRepository.delete(customer);
        Map< String, Boolean > response = new HashMap< >();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
