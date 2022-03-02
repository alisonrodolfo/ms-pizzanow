package com.restaurante.custumerservice.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.io.Serializable;

/**
 * The type Customer model.
 *
 * @author https ://github.com/alisonrodolfo
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="TB_CUSTOMER")
public class CustomerModel extends RepresentationModel<CustomerModel> implements Serializable {
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
    @Column(name = "nome", nullable = false, length = 100)
    private String name;
    @Basic
    @Column(name = "observacoes", nullable = true, length = 1000)
    private String observacoes;



}
