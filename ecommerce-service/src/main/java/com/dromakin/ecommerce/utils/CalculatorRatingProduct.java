/*
 * File:     CalculatorRatingProduct
 * Package:  com.dromakin.ecommerce.utils
 * Project:  netology_homework_design_principles_shop
 *
 * Created by dromakin as 07.04.2023
 *
 * author - dromakin
 * maintainer - dromakin
 * version - 2023.04.07
 * copyright - ORGANIZATION_NAME Inc. 2023
 */
package com.dromakin.ecommerce.utils;

import com.dromakin.ecommerce.entities.Inventory;
import com.dromakin.ecommerce.web.models.ProductRatingResponse;

public interface CalculatorRatingProduct {

    ProductRatingResponse.Rating getRatingForProduct(Inventory product);
}
