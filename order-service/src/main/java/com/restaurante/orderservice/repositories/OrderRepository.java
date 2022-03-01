package com.restaurante.orderservice.repositories;

import com.restaurante.orderservice.entities.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author https://github.com/alisonrodolfo
 */
@Repository
public interface OrderRepository extends JpaRepository<OrderModel, Long> {
    /* Created by Alison on 28/02/2022 */
}
