/*
 * File:     OrderFinalPrice
 * Package:  com.dromakin.ecommerce.web.models
 * Project:  netology_homework_solid_shop
 *
 * Created by dromakin as 08.04.2023
 *
 * author - dromakin
 * maintainer - dromakin
 * version - 2023.04.08
 * copyright - ORGANIZATION_NAME Inc. 2023
 */
package com.dromakin.ecommerce.web.models;

import lombok.Builder;

@Builder
public class OrderFinalPrice {
    private Long id;
    private Double price;
}
