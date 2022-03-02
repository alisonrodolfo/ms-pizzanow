package com.restaurante.deliveryservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.io.Serializable;

/**
 * The type Delivery model.
 *
 * @author https ://github.com/alisonrodolfo
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="TB_DELIVERIES")
public class DeliveryModel extends RepresentationModel<DeliveryModel> implements Serializable {
    /* Created by Alison on 28/02/2022 */
  /*
    Esse é um atributo utilizado para controlar a compatibilidade entre o .class usado para serializar
    e o .class que será utilizado na desserialização.
     */
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Column(name = "id", unique = true, nullable = false)
    private long id;
    @Basic
    @Column(name = "orderId", nullable = false)
    private long orderId;
    @Basic
    @Column(name = "customerId", nullable = false)
    private long customerId;
    @Basic
    @Column(name = "address", nullable = false)
    private String address;
    @Basic
    @Column(name = "shippingValue", nullable = false)
    private long shippingValue;



}
