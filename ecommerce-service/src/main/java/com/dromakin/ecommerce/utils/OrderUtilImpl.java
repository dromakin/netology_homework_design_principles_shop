/*
 * File:     OrderUtilImpl
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

import com.dromakin.ecommerce.entities.Order;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
public class OrderUtilImpl implements OrderUtil {

    protected static double CUSTOMER_PRICE_SMALL = 50.0;
    protected static double CUSTOMER_PRICE_MEDIUM = 70.0;
    protected static double CUSTOMER_PRICE_HIGH = 100.0;
    protected static double SHOP_STANDARD = 20.0;
    protected static double SHOP_PREMIUM = 10.0;

    protected boolean isBetween(int x, int lower, int upper) {
        return lower <= x && x <= upper;
    }

    @Override
    public List<String> getProductCodesFromOrders(List<Order> orderList) {
        return orderList.stream()
                .map(Order::getItems)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    @Override
    public Double getDeliveryFeeByCountItems(Integer count) {
        double price = 0.0;

        if (isBetween(count, 1, 5)) {
            price = CUSTOMER_PRICE_SMALL;
        }

        if (isBetween(count, 6, 20)) {
            price = CUSTOMER_PRICE_MEDIUM;
        }

        if (isBetween(count, 21, 50)) {
            price = CUSTOMER_PRICE_HIGH;
        }

        if (isBetween(count, 51, 100)) {
            price = SHOP_STANDARD;
        }

        if (isBetween(count, 51, 1000)) {
            price = SHOP_PREMIUM;
        }

        return price;
    }
}
