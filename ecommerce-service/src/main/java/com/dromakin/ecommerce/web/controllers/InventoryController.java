/*
 * File:     InventoryController
 * Package:  com.dromakin.ecommerce.controllers
 * Project:  netology_homework_design_principles_shop
 *
 * Created by dromakin as 07.04.2023
 *
 * author - dromakin
 * maintainer - dromakin
 * version - 2023.04.07
 * copyright - ORGANIZATION_NAME Inc. 2023
 */
package com.dromakin.ecommerce.web.controllers;

import com.dromakin.ecommerce.entities.Inventory;
import com.dromakin.ecommerce.web.models.ProductRatingResponse;
import com.dromakin.ecommerce.services.InventoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@Slf4j
@Api(value = "Inventory Resource REST Endpoint")
public class InventoryController {

    private final InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    // Standard
    @PostMapping("")
    public ResponseEntity<Inventory> create(
            @ApiParam(name = "Inventory json", required = true)
            @Valid @RequestBody Inventory inventory
    ) {
        Inventory createdInventory = inventoryService.createInventoryStock(inventory);

        if (createdInventory == null) {
            return ResponseEntity.notFound().build();

        } else {
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(createdInventory.getId())
                    .toUri();

            return ResponseEntity.created(uri)
                    .body(createdInventory);
        }
    }

    @PostMapping("/many")
    public ResponseEntity<List<Inventory>> create(
            @ApiParam(name = "List of inventory", required = true)
            @Valid @RequestBody List<Inventory> inventoryList
    ) {
        List<Inventory> createdListInventory = inventoryService.createInventoryStocks(inventoryList);

        if (createdListInventory == null) {
            return ResponseEntity.notFound().build();

        } else {
            return ResponseEntity.ok(createdListInventory);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<Inventory>> read() {
        List<Inventory> inventoryList = inventoryService.fetchInventoryStocks();

        if (inventoryList == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(inventoryList);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inventory> read(
            @ApiParam(name = "Inventory id", required = true)
            @PathVariable Long id
    ) {
        Inventory inventory = inventoryService.fetchInventoryStockById(id);
        if (inventory == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(inventory);
        }
    }

    @GetMapping("/{code}")
    public ResponseEntity<Inventory> read(
            @ApiParam(name = "Inventory id", required = true)
            @PathVariable String code
    ) {
        Inventory inventory = inventoryService.fetchInventoryStockByCode(code);
        if (inventory == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(inventory);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inventory> update(
            @ApiParam(name = "Inventory", required = true)
            @RequestBody Inventory inventory,
            @ApiParam(name = "Inventory id", required = true)
            @PathVariable Long id
    ) {
        Inventory updatedInventory = inventoryService.updateInventoryStock(inventory, id);
        if (updatedInventory == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updatedInventory);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(
            @ApiParam(name = "Inventory id", required = true) @PathVariable Long id
    ) {
        inventoryService.deleteInventoryStock(id);
        return ResponseEntity.noContent().build();
    }

    // special
    @GetMapping("/add/{id}")
    public ResponseEntity<Inventory> addInventory(
            @ApiParam(name = "Inventory id", required = true)
            @PathVariable Long id
    ) {
        Inventory updatedInventory = inventoryService.addInventoryStockById(id);
        if (updatedInventory == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updatedInventory);
        }
    }

    @GetMapping("/add/{code}")
    public ResponseEntity<Inventory> addInventory(
            @ApiParam(name = "Inventory id", required = true)
            @PathVariable String code
    ) {
        Inventory updatedInventory = inventoryService.addInventoryStockByCode(code);
        if (updatedInventory == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updatedInventory);
        }
    }

    @GetMapping("/sell/{id}")
    public ResponseEntity<Inventory> sellInventory(
            @ApiParam(name = "Inventory id", required = true)
            @PathVariable Long id
    ) {
        Inventory updatedInventory = inventoryService.sellInventoryStockById(id);
        if (updatedInventory == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updatedInventory);
        }
    }

    @GetMapping("/sell/{code}")
    public ResponseEntity<Inventory> sellInventory(
            @ApiParam(name = "Inventory id", required = true)
            @PathVariable String code
    ) {
        Inventory updatedInventory = inventoryService.sellInventoryStockByCode(code);
        if (updatedInventory == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updatedInventory);
        }
    }

    // Rating
    @GetMapping("/rating/{id}")
    public ResponseEntity<ProductRatingResponse> rating(
            @ApiParam(name = "Inventory id", required = true)
            @PathVariable Long id
    ) {
        ProductRatingResponse response = inventoryService.getRatingProductById(id);
        if (response == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(response);
        }
    }

    @GetMapping("/rating/{code}")
    public ResponseEntity<ProductRatingResponse> rating(
            @ApiParam(name = "Inventory id", required = true)
            @PathVariable String code
    ) {
        ProductRatingResponse response = inventoryService.getRatingProductByCode(code);
        if (response == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(response);
        }
    }

}
