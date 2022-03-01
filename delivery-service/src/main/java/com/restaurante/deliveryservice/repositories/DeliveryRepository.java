package com.restaurante.deliveryservice.repositories;

import com.restaurante.deliveryservice.entities.DeliveryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author https://github.com/alisonrodolfo
 */
@Repository
public interface DeliveryRepository extends JpaRepository<DeliveryModel, Long> {
    /* Created by Alison on 28/02/2022 */
}
