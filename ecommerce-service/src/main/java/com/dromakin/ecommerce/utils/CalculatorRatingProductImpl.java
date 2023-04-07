/*
 * File:     CalculatorRatingPeoduct
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
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CalculatorRatingProductImpl implements CalculatorRatingProduct {

    public ProductRatingResponse.Rating getRatingForProduct(Inventory product) {
        Integer availableQuantity = product.getAvailableQuantity();
        Integer needQuantity = product.getNeedQuantity();

        ProductRatingResponse.Rating rating = null;

        int diff = availableQuantity - needQuantity;

        if (availableQuantity.equals(needQuantity) && needQuantity == 0) {
            rating = ProductRatingResponse.Rating.NODATA;
        }

        if (diff < 0 && availableQuantity == 0) {
            rating = ProductRatingResponse.Rating.THE_BEST;
        }

        if (diff < 0 && availableQuantity > 0) {
            rating = ProductRatingResponse.Rating.GOOD;
        }

        if (diff == 0 && availableQuantity > 0 && needQuantity > 0) {
            rating = ProductRatingResponse.Rating.NORMAL;
        }

        if (diff > 0 && needQuantity > 0) {
            rating = ProductRatingResponse.Rating.BAD;
        }

        if (diff > 0 && needQuantity == 0) {
            rating = ProductRatingResponse.Rating.THE_WORST;
        }

        return rating;
    }

}
