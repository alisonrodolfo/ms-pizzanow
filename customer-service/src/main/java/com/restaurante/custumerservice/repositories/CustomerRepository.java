package com.restaurante.custumerservice.repositories;

import com.restaurante.custumerservice.domain.entities.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Customer repository.
 *
 * @author https ://github.com/alisonrodolfo
 */
@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel, Long> {
    /* Created by Alison on 28/02/2022 */
}
