/*
 * File:     OrderItem
 * Package:  com.dromakin.manufacturer.entities
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

import com.dromakin.ecommerce.web.models.OrderStatus;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ApiModelProperty(notes = "customer name")
    private String customerName;
    @ApiModelProperty(notes = "customer email")
    private String customerEmail;
    @ApiModelProperty(notes = "customer address")
    private String customerAddress;
    @ApiModelProperty(notes = "active or archived (no active)", value = "true")
    private boolean active = true;
    @ApiModelProperty(notes = "Delivered, Returned, Canceled, InDelivery, Wrapping, Checking", value = "WRAPPING")
    private OrderStatus status = OrderStatus.CHECKING;
    @ApiModelProperty(notes = "List of product codes")
    private List<String> items;
}
