/*
 * File:     InventoryService
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

import com.dromakin.ecommerce.entities.Inventory;
import com.dromakin.ecommerce.web.models.ProductRatingResponse;

import java.util.List;

public interface InventoryService {

    Inventory createInventoryStock(Inventory inventory);
    List<Inventory> createInventoryStocks(List<Inventory> inventoryList);

    List<Inventory> fetchInventoryStocks();

    Inventory fetchInventoryStockById(Long id);
    Inventory fetchInventoryStockByCode(String code);

    Inventory updateInventoryStock(Inventory Inventory, Long id);

    void deleteInventoryStock(Long id);

    // special
    // quantity
    Inventory addInventoryStockById(Long id);
    Inventory addInventoryStockByCode(String code);

    Inventory sellInventoryStockById(Long id);
    Inventory sellInventoryStockByCode(String code);

    // get rating of Product
    ProductRatingResponse getRatingProductById(Long id);
    ProductRatingResponse getRatingProductByCode(String code);

}
