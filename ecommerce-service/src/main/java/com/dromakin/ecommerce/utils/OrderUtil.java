/*
 * File:     OrderUtil
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

import java.util.List;

public interface OrderUtil {
    List<String> getProductCodesFromOrders(List<Order> orderList);

    Double getDeliveryFeeByCountItems(Integer count);
}
