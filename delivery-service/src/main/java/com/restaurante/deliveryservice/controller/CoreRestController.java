package com.restaurante.deliveryservice.controller;

import com.restaurante.deliveryservice.entities.DeliveryModel;
import com.restaurante.deliveryservice.exception.ResourceNotFoundException;
import com.restaurante.deliveryservice.repositories.DeliveryRepository;
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
@RestController
@RequestMapping("/api/v1/delivery")
public class CoreRestController {
    /* Created by Alison on 28/02/2022 */

    @Autowired
    private DeliveryRepository deliveryservice;

    /**
     * Gets all deliveries.
     *
     * @return the all deliveries
     */
    @GetMapping("/getall")
    public List<DeliveryModel> getAllDeliveries() {
        return deliveryservice.findAll();
    }

    /**
     * Gets delivery by id.
     *
     * @param deliveryId the delivery id
     * @return the delivery by id
     * @throws ResourceNotFoundException the resource not found exception
     */
    @GetMapping("/get/{id}")
    public ResponseEntity< DeliveryModel > getDeliveryById(@PathVariable(value = "id") Long deliveryId)
            throws ResourceNotFoundException {
        DeliveryModel delivery = deliveryservice.findById(deliveryId)
                .orElseThrow(() -> new ResourceNotFoundException("delivery not found :: " + deliveryId));
        return ResponseEntity.ok().body(delivery);
    }

    /**
     * Create delivery delivery model.
     *
     * @param delivery the delivery
     * @return the delivery model
     */
    @PostMapping("/add")
    public DeliveryModel createDelivery(@Validated @RequestBody DeliveryModel delivery) {
        return deliveryservice.save(delivery);
    }

    /**
     * Update delivery response entity .
     *
     * @param deliveryId      the delivery id
     * @param deliveryDetails the delivery details
     * @return the response entity
     * @throws ResourceNotFoundException the resource not found exception
     */
    @PutMapping("/update/{id}")
    public ResponseEntity < DeliveryModel > updateDelivery(@PathVariable(value = "id") Long deliveryId,
                                                      @Validated @RequestBody DeliveryModel deliveryDetails) throws ResourceNotFoundException {
        DeliveryModel delivery = deliveryservice.findById(deliveryId)
                .orElseThrow(() -> new ResourceNotFoundException("delivery not found for this id :: " + deliveryId));

        delivery.setId(deliveryDetails.getId());
        delivery.setOrderId(deliveryDetails.getOrderId());
        delivery.setCustomerId(deliveryDetails.getCustomerId());
        delivery.setShippingValue(deliveryDetails.getShippingValue());
        delivery.setAddress(deliveryDetails.getAddress());
        final DeliveryModel updateDelivery = deliveryservice.save(delivery);
        return ResponseEntity.ok(updateDelivery);
    }

    /**
     * Delete delivery map.
     *
     * @param deliveryId the delivery id
     * @return the map
     * @throws ResourceNotFoundException the resource not found exception
     */
    @DeleteMapping("/delete/{id}")
    public Map< String, Boolean > deleteDelivery(@PathVariable(value = "id") Long deliveryId)
            throws ResourceNotFoundException {
        DeliveryModel delivery = deliveryservice.findById(deliveryId)
                .orElseThrow(() -> new ResourceNotFoundException("delivery not found for this id :: " + deliveryId));

        deliveryservice.delete(delivery);
        Map< String, Boolean > response = new HashMap< >();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
