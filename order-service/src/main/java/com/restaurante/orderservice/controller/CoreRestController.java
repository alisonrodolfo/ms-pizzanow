package com.restaurante.orderservice.controller;

import com.restaurante.orderservice.entities.OrderModel;
import com.restaurante.orderservice.exception.ResourceNotFoundException;
import com.restaurante.orderservice.repositories.OrderRepository;
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
@RequestMapping("/api/v1/order")
public class CoreRestController {
    /* Created by Alison on 28/02/2022 */

    @Autowired
    private OrderRepository orderRepository;

    /**
     * Gets all orders.
     *
     * @return the all orders
     */
    @GetMapping("/getall")
    public List<OrderModel> getAllOrders() {
        return orderRepository.findAll();
    }

    /**
     * Gets orders by id.
     *
     * @param orderId the order id
     * @return the orders by id
     * @throws ResourceNotFoundException the resource not found exception
     */
    @GetMapping("/get/{id}")
    public ResponseEntity< OrderModel > getOrdersById(@PathVariable(value = "id") Long orderId)
            throws ResourceNotFoundException {
        OrderModel order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found :: " + orderId));
        return ResponseEntity.ok().body(order);
    }

    /**
     * Create order order model.
     *
     * @param order the order
     * @return the order model
     */
    @PostMapping("/add")
    public OrderModel createOrder(@Validated @RequestBody OrderModel order) {
        return orderRepository.save(order);
    }

    /**
     * Update order response entity .
     *
     * @param orderId      the order id
     * @param orderDetails the order details
     * @return the response entity
     * @throws ResourceNotFoundException the resource not found exception
     */
    @PutMapping("/update/{id}")
    public ResponseEntity < OrderModel > updateOrder(@PathVariable(value = "id") Long orderId,
                                                @Validated @RequestBody OrderModel orderDetails) throws ResourceNotFoundException {
        OrderModel order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found for this id :: " + orderId));

        order.setCustomer_id(orderDetails.getCustomer_id());
        order.setDescription(orderDetails.getDescription());
        order.setValue(orderDetails.getValue());
        final OrderModel updateCustomer = orderRepository.save(order);
        return ResponseEntity.ok(updateCustomer);
    }

    /**
     * Delete order map.
     *
     * @param orderId the order id
     * @return the map
     * @throws ResourceNotFoundException the resource not found exception
     */
    @DeleteMapping("/delete/{id}")
    public Map< String, Boolean > deleteOrder(@PathVariable(value = "id") Long orderId)
            throws ResourceNotFoundException {
        OrderModel order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found for this id :: " + orderId));

        orderRepository.delete(order);
        Map< String, Boolean > response = new HashMap< >();
        response.put("deleted", Boolean.TRUE);
        return response;
    }


}
