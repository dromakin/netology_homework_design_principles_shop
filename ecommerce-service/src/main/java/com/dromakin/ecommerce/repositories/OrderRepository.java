/*
 * File:     InventorySoldRepository
 * Package:  com.dromakin.inventoryservice.repositories
 * Project:  netology_homework_design_principles_shop
 *
 * Created by dromakin as 06.04.2023
 *
 * author - dromakin
 * maintainer - dromakin
 * version - 2023.04.06
 * copyright - ORGANIZATION_NAME Inc. 2023
 */
package com.dromakin.ecommerce.repositories;

import com.dromakin.ecommerce.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findById(Long id);
    List<Order> findByCustomerName(String name);
    List<Order> findByCustomerEmail(String email);
    List<Order> findByCustomerNameAndCustomerEmail(String name, String email);

    List<Order> findByCustomerNameAndCustomerEmailAndCustomerAddressAndActive(String name, String email, String address, boolean active);

    List<Order> findByActive(boolean active);
    List<Order> findByActiveAndId(boolean active, Long id);
}
