/*
 * File:     Inventory
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
@Table(name = "inventory_stock")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ApiModelProperty(notes = "Unique code of the product")
    @Column(name = "product_code", nullable = false, unique = true)
    private String productCode;
    @ApiModelProperty(notes = "Available Quantity of the product", value = "0")
    @Column(name = "quantity")
    private Integer availableQuantity = 0;
    @ApiModelProperty(notes = "Need Quantity of the product", value = "0")
    private Integer needQuantity = 0;
}
