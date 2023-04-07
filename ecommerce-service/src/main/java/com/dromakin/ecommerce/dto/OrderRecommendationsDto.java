/*
 * File:     OrderRecommendationsDto
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

import lombok.Data;

@Data
public class OrderRecommendationsDto {
    private String customerName;
    private String customerEmail;
    private String customerAddress;
}
