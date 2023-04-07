/*
 * File:     OrderStatusDto
 * Package:  com.dromakin.ecommerce.dto
 * Project:  netology_homework_design_principles_shop
 *
 * Created by dromakin as 07.04.2023
 *
 * author - dromakin
 * maintainer - dromakin
 * version - 2023.04.07
 * copyright - ORGANIZATION_NAME Inc. 2023
 */
package com.dromakin.ecommerce.dto;

import com.dromakin.ecommerce.web.models.OrderStatus;
import lombok.Data;

@Data
public class OrderStatusDto {
    private Long id;
    private OrderStatus status;
}
