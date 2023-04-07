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

    @Override
    public List<String> getProductCodesFromOrders(List<Order> orderList) {
        return orderList.stream()
                .map(Order::getItems)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }
}
