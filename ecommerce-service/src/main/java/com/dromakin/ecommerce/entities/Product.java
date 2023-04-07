/*
 * File:     Product
 * Package:  com.dromakin.ecommerce.entities
 * Project:  netology_homework_design_principles_shop
 *
 * Created by dromakin as 04.04.2023
 *
 * author - dromakin
 * maintainer - dromakin
 * version - 2023.04.04
 * copyright - ORGANIZATION_NAME Inc. 2023
 */
package com.dromakin.ecommerce.entities;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, unique = true)
    @ApiModelProperty(notes = "unique code of the product")
    private String code;
    @Column(nullable = false)
    @ApiModelProperty(notes = "name of the product")
    private String name;
    @ApiModelProperty(notes = "description of the product")
    private String description;
    @ApiModelProperty(notes = "price of the product")
    private double price;
    private Long manufacturer;
}
