/*
 * File:     InventorySoldService
 * Package:  com.dromakin.inventoryservice.services
 * Project:  netology_homework_design_principles_shop
 *
 * Created by dromakin as 06.04.2023
 *
 * author - dromakin
 * maintainer - dromakin
 * version - 2023.04.06
 * copyright - ORGANIZATION_NAME Inc. 2023
 */
package com.dromakin.ecommerce.services;

import com.dromakin.ecommerce.entities.Order;
import com.dromakin.ecommerce.web.models.OrderFinalPrice;
import com.dromakin.ecommerce.web.models.OrderStatus;

import java.util.List;

public interface OrderService {
    Order createOrder(Order order);

    List<Order> fetchOrders();

    Order fetchOrderById(Long id);
    List<Order> fetchOrderByName(String name);
    List<Order> fetchOrderByEmail(String email);
    List<Order> fetchOrderByNameEmail(String name, String email);

    Order updateOrder(Order order, Long id);

    void deleteOrder(Long id);

    // special
    // active or archived
    List<Order> getActiveOrders();
    List<Order> getArchiveOrders();

    // get Products code by id Order
    List<String> getOrderItemsById(Long id);

    // recommendations
    List<String> getRecommendationsById(Long id);
    List<String> getRecommendationsByCustomer(String name, String email, String customerAddress);

    // Delivered, Returned, Canceled, InDelivery, Wrapping, Checking
    Order updateStatusOrderById(Long id, OrderStatus status);

    // price
    OrderFinalPrice getFinalPrice(Long id);
}
