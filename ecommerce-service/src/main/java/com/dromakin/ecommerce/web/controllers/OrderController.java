/*
 * File:     OrderController
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

import com.dromakin.ecommerce.dto.OrderRecommendationsDto;
import com.dromakin.ecommerce.dto.OrderStatusDto;
import com.dromakin.ecommerce.entities.Order;
import com.dromakin.ecommerce.services.OrderService;
import com.dromakin.ecommerce.web.models.OrderFinalPrice;
import com.dromakin.ecommerce.web.models.OrderStatus;
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
@RequestMapping("/api/order")
@Slf4j
@Api(value = "Order Resource REST Endpoint")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // Standard
    @PostMapping("")
    public ResponseEntity<Order> create(
            @ApiParam(name = "Order json", required = true)
            @Valid @RequestBody Order order
    ) {
        Order createdOrder = orderService.createOrder(order);

        if (createdOrder == null) {
            return ResponseEntity.notFound().build();

        } else {
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(createdOrder.getId())
                    .toUri();

            return ResponseEntity.created(uri)
                    .body(createdOrder);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<Order>> read() {
        List<Order> orderList = orderService.fetchOrders();

        if (orderList == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(orderList);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Order> read(
            @ApiParam(name = "Order id", required = true)
            @PathVariable Long id
    ) {
        Order order = orderService.fetchOrderById(id);
        if (order == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(order);
        }
    }


    @GetMapping("/name/{name}")
    public ResponseEntity<List<Order>> readByName(
            @ApiParam(name = "Customer name in Order", required = true)
            @PathVariable String name
    ) {
        List<Order> orderList = orderService.fetchOrderByName(name);
        if (orderList == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(orderList);
        }
    }


    @GetMapping("/email/{email}")
    public ResponseEntity<List<Order>> readByEmail(
            @ApiParam(name = "Customer email in Order", required = true)
            @PathVariable String email
    ) {
        List<Order> orderList = orderService.fetchOrderByEmail(email);
        if (orderList == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(orderList);
        }
    }


    @GetMapping("/customer")
    public ResponseEntity<List<Order>> readByNameAndEmail(
            @ApiParam(name = "Customer name in Order", required = true)
            @RequestParam String name,
            @ApiParam(name = "Customer email in Order", required = true)
            @RequestParam String email
    ) {
        List<Order> orderList = orderService.fetchOrderByNameEmail(name, email);
        if (orderList == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(orderList);
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Order> update(
            @ApiParam(name = "Order", required = true)
            @RequestBody Order order,
            @ApiParam(name = "Order id", required = true)
            @PathVariable Long id
    ) {
        log.warn("Update Order not available!");
        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(
            @ApiParam(name = "Order id", required = true)
            @PathVariable Long id
    ) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }

    // special
    @GetMapping("/active")
    public ResponseEntity<List<Order>> getActiveOrders() {
        List<Order> orderList = orderService.getActiveOrders();
        if (orderList == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(orderList);
        }
    }

    @GetMapping("/archived")
    public ResponseEntity<List<Order>> getArchivedOrders() {
        List<Order> orderList = orderService.getArchiveOrders();
        if (orderList == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(orderList);
        }
    }

    @GetMapping("/items/id/{id}")
    public ResponseEntity<List<String>> getOrderItems(
            @ApiParam(name = "Order id", required = true)
            @PathVariable Long id
    ) {
        List<String> orderItemsList = orderService.getOrderItemsById(id);
        if (orderItemsList == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(orderItemsList);
        }
    }

    // status
    @PostMapping("/status")
    public ResponseEntity<Order> updateStatus(
            @ApiParam(name = "Order status json", required = true)
            @Valid @RequestBody OrderStatusDto orderStatusDto
    ) {
        Order orderDb = orderService.updateStatusOrderById(orderStatusDto.getId(), OrderStatus.getStatusByString(orderStatusDto.getStatus()));
        if (orderDb == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(orderDb);
        }
    }


    @GetMapping("/recommendations/id/{id}")
    public ResponseEntity<List<String>> getRecommendations(
            @ApiParam(name = "Order id", required = true)
            @PathVariable Long id
    ) {
        List<String> orderItemsList = orderService.getRecommendationsById(id);
        if (orderItemsList == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(orderItemsList);
        }
    }

    @PostMapping("/recommendations")
    public ResponseEntity<List<String>> getRecommendations(
            @ApiParam(name = "Order recommendation json", required = true)
            @Valid @RequestBody OrderRecommendationsDto orderRecommendationsDto
    ) {
        List<String> orderItemsList = orderService.getRecommendationsByCustomer(
                orderRecommendationsDto.getCustomerName(),
                orderRecommendationsDto.getCustomerEmail(),
                orderRecommendationsDto.getCustomerAddress()
        );

        if (orderItemsList == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(orderItemsList);
        }
    }

    // price
    @GetMapping("/price/id/{id}")
    public ResponseEntity<OrderFinalPrice> getFinalPriceById(
            @ApiParam(name = "Order id", required = true)
            @PathVariable Long id
    ) {
        OrderFinalPrice orderFinalPrice = orderService.getFinalPrice(id);

        if (orderFinalPrice == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(orderFinalPrice);
        }
    }

}
