package com.restaurante.orderservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author https://github.com/alisonrodolfo
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="TB_ORDERS")
public class OrderModel extends RepresentationModel<OrderModel> implements Serializable {
    /* Created by Alison on 28/02/2022 */
  /*
    Esse é um atributo utilizado para controlar a compatibilidade entre o .class usado para serializar
    e o .class que será utilizado na desserialização.
     */
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @Column(name = "id", unique = true, nullable = false)
    private long id;
    @Basic
    @Column(name = "customer_id", nullable = false)
    private String customer_id;
    @Basic
    @Column(name = "description", nullable = false, length = 1000)
    private String description;
    @Basic
    @Column(name = "value")
    private long value;



}
