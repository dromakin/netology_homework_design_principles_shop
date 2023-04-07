/*
 * File:     InventoryServiceImpl
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
import com.dromakin.ecommerce.repositories.InventoryRepository;
import com.dromakin.ecommerce.utils.InventoryUtil;
import com.dromakin.ecommerce.utils.InventoryUtilImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
@Slf4j
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    private final InventoryUtil inventoryUtil = new InventoryUtilImpl();

    @Autowired
    public InventoryServiceImpl(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public Inventory createInventoryStock(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public List<Inventory> createInventoryStocks(List<Inventory> inventoryList) {
        return inventoryRepository.save(inventoryList);
    }

    @Override
    public List<Inventory> fetchInventoryStocks() {
        return inventoryRepository.findAll();
    }

    @Override
    public Inventory fetchInventoryStockById(Long id) {
        return inventoryRepository.findById(id);
    }

    @Override
    public Inventory fetchInventoryStockByCode(String code) {
        return inventoryRepository.findByProductCode(code);
    }

    @Override
    public Inventory updateInventoryStock(Inventory Inventory, Long id) {
        Inventory inventoryDb = inventoryRepository.findById(id);

        if (Objects.nonNull(Inventory.getProductCode())
                && !"".equalsIgnoreCase(Inventory.getProductCode())) {
            inventoryDb.setProductCode(Inventory.getProductCode());
        }

        if (Objects.nonNull(Inventory.getNeedQuantity())) {
            inventoryDb.setNeedQuantity(Inventory.getNeedQuantity());
        }

        if (Objects.nonNull(Inventory.getAvailableQuantity())) {
            inventoryDb.setAvailableQuantity(Inventory.getAvailableQuantity());
        }

        return inventoryRepository.save(inventoryDb);
    }

    @Override
    public void deleteInventoryStock(Long id) {
        inventoryRepository.delete(id);
    }

    @Override
    public Inventory addInventoryStockById(Long id) {
        Inventory inventoryDb = inventoryRepository.findById(id);
        inventoryRepository.delete(id);
        return inventoryRepository.save(inventoryUtil.addInventoryStock(inventoryDb));
    }

    @Override
    public Inventory addInventoryStockByCode(String code) {
        Inventory inventoryDb = inventoryRepository.findByProductCode(code);
        inventoryRepository.delete(inventoryDb.getId());
        return inventoryRepository.save(inventoryUtil.addInventoryStock(inventoryDb));
    }

    @Override
    public Inventory sellInventoryStockById(Long id) {
        Inventory inventoryDb = inventoryRepository.findById(id);
        inventoryRepository.delete(id);
        return inventoryRepository.save(inventoryUtil.sellInventoryStock(inventoryDb));
    }

    @Override
    public Inventory sellInventoryStockByCode(String code) {
        Inventory inventoryDb = inventoryRepository.findByProductCode(code);
        inventoryRepository.delete(inventoryDb.getId());
        return inventoryRepository.save(inventoryUtil.sellInventoryStock(inventoryDb));
    }

    @Override
    public ProductRatingResponse getRatingProductById(Long id) {
        Inventory inventoryDb = inventoryRepository.findById(id);
        return inventoryUtil.buildProductRatingResponse(inventoryDb);
    }

    @Override
    public ProductRatingResponse getRatingProductByCode(String code) {
        Inventory inventoryDb = inventoryRepository.findByProductCode(code);
        return inventoryUtil.buildProductRatingResponse(inventoryDb);
    }
}
