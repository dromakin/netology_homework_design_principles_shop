/*
 * File:     InventoryUtilImpl
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
public class InventoryUtilImpl implements InventoryUtil {

    @Override
    public Inventory addInventoryStock(Inventory inventory) {
        Integer availableQuantity = inventory.getAvailableQuantity();
        availableQuantity += 1;
        inventory.setAvailableQuantity(availableQuantity);
        return inventory;
    }

    @Override
    public Inventory sellInventoryStock(Inventory inventory) {
        Integer availableQuantity = inventory.getAvailableQuantity();
        Integer needQuantity = inventory.getNeedQuantity();
        availableQuantity -= 1;
        needQuantity += 1;
        inventory.setAvailableQuantity(availableQuantity);
        inventory.setNeedQuantity(needQuantity);
        return inventory;
    }

    @Override
    public ProductRatingResponse buildProductRatingResponse(Inventory inventory) {
        return ProductRatingResponse.builder()
                .productCode(inventory.getProductCode())
                .productRating(new CalculatorRatingProductImpl().getRatingForProduct(inventory))
                .build();
    }
}
