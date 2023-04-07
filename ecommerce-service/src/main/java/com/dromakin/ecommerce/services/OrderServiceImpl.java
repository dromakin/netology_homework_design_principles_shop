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
import com.dromakin.ecommerce.web.models.OrderStatus;
import com.dromakin.ecommerce.repositories.OrderRepository;
import com.dromakin.ecommerce.utils.OrderUtil;
import com.dromakin.ecommerce.utils.OrderUtilImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final OrderUtil orderUtil = new OrderUtilImpl();

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> fetchOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order fetchOrderById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public List<Order> fetchOrderByName(String name) {
        return orderRepository.findByCustomerName(name);
    }

    @Override
    public List<Order> fetchOrderByEmail(String email) {
        return orderRepository.findByCustomerEmail(email);
    }

    @Override
    public List<Order> fetchOrderByNameEmail(String name, String email) {
        return orderRepository.findByCustomerNameAndCustomerEmail(name, email);
    }

    @Override
    public Order updateOrder(Order order, Long id) {
        log.warn("No update for Order!");
        return order;
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.delete(id);
    }

    // special
    // active
    @Override
    public List<Order> getActiveOrders() {
        return orderRepository.findByActive(true);
    }

    @Override
    public List<Order> getArchiveOrders() {
        return orderRepository.findByActive(false);
    }


    @Override
    public List<Order> getActiveOrdersAndId(Long id) {
        return orderRepository.findByActiveAndId(true, id);
    }

    @Override
    public List<Order> getArchiveOrdersAndId(Long id) {
        return orderRepository.findByActiveAndId(false, id);
    }

    @Override
    public List<String> getOrderItemsById(Long id) {
        return orderRepository.findById(id).getItems();
    }

    // recommendations
    @Override
    public List<String> getRecommendationsById(Long id) {
        List<Order> orderList = orderRepository.findByActiveAndId(false, id);
        return orderUtil.getProductCodesFromOrders(orderList);
    }

    @Override
    public List<String> getRecommendationsByCustomer(String name, String email, String address) {
        List<Order> orderList = orderRepository.findByCustomerNameAndCustomerEmailAndCustomerAddressAndActive(name, email, address, false);
        return orderUtil.getProductCodesFromOrders(orderList);
    }

    // status update
    @Override
    public Order updateStatusOrderById(Long id, OrderStatus status) {
        Order orderDb = orderRepository.findById(id);
        if (status == OrderStatus.DELIVERED || status == OrderStatus.RETURNED || status == OrderStatus.CANCELED) {
            orderDb.setActive(false);
        }
        orderDb.setStatus(status);
        return orderDb;
    }
}
