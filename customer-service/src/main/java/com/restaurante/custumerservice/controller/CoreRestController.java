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
 * The type Core rest controller.
 *
 * @author https ://github.com/alisonrodolfo
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/customer")
public class CoreRestController {
    /* Created by Alison on 28/02/2022 */

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * Gets all customers.
     *
     * @return the all customers
     */
    @GetMapping("/getall")
    public List<CustomerModel> getAllCustomers() {
        return customerRepository.findAll();
    }

    /**
     * Gets customer by id.
     *
     * @param customerId the customer id
     * @return the customer by id
     * @throws ResourceNotFoundException the resource not found exception
     */
    @GetMapping("/get/{id}")
    public ResponseEntity<CustomerModel> getCustomerById(final @PathVariable(value = "id") Long customerId)
            throws ResourceNotFoundException {
        CustomerModel customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found :: " + customerId));
        log.info("Cadastrando um novo cliente com as informações [{}]", customer);
        return ResponseEntity.ok().body(customer);
    }

    /**
     * Create customer customer model.
     *
     * @param customer the customer
     * @return the customer model
     */
    @PostMapping("/add")
    public CustomerModel createCustomer(final @Validated @RequestBody CustomerModel customer) {
        return customerRepository.save(customer);
    }

    /**
     * Update customer response entity .
     *
     * @param customerId      the customer id
     * @param customerDetails the customer details
     * @return the response entity
     * @throws ResourceNotFoundException the resource not found exception
     */
    @PutMapping("/update/{id}")
    public ResponseEntity <CustomerModel> updateCustomer(final @PathVariable(value = "id") Long customerId,
                                                         final @Validated @RequestBody CustomerModel customerDetails) throws ResourceNotFoundException {
        CustomerModel customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + customerId));

        customer.setName(customerDetails.getName());
        customer.setObservacoes(customerDetails.getObservacoes());
        final CustomerModel updateCustomer = customerRepository.save(customer);
        return ResponseEntity.ok(updateCustomer);
    }

    /**
     * Delete customer map.
     *
     * @param customerId the customer id
     * @return the map
     * @throws ResourceNotFoundException the resource not found exception
     */
    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> deleteCustomer(final @PathVariable(value = "id") Long customerId)
            throws ResourceNotFoundException {
        CustomerModel customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + customerId));

        customerRepository.delete(customer);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
