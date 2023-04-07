/*
 * File:     SampleJobService
 * Package:  com.dromakin.ecommerce.services
 * Project:  netology_homework_solid_shop
 *
 * Created by dromakin as 07.04.2023
 *
 * author - dromakin
 * maintainer - dromakin
 * version - 2023.04.07
 * copyright - ORGANIZATION_NAME Inc. 2023
 */
package com.dromakin.ecommerce.services;

import com.dromakin.ecommerce.entities.Order;
import com.dromakin.ecommerce.utils.OrderUtil;
import com.dromakin.ecommerce.utils.OrderUtilImpl;
import com.dromakin.ecommerce.web.models.OrderStatus;
import lombok.extern.slf4j.Slf4j;
import org.jobrunr.jobs.annotations.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Slf4j
public class SampleJobService {

    public static final long EXECUTION_TIME = TimeUnit.SECONDS.toMillis(5);
    public static final int MIN = 1;
    public static final int MAX = 2;

    private final OrderService orderService;
    private AtomicInteger count = new AtomicInteger();

    @Autowired
    public SampleJobService(OrderService orderService) {
        this.orderService = orderService;
    }


    @Job(name = "The Delivery job with variable %0", retries = 2)
    public void execute(String variable) {

        OrderUtil orderUtil = new OrderUtilImpl();

        log.info("The sample job has begun. The variable you passed is {}", variable);
        try {
            List<Order> orderDbList = orderService.getActiveOrders();

            for (Order order : orderDbList) {

                // simulate working time
                Thread.sleep(EXECUTION_TIME);
                /*
                Delivered, Returned, Canceled, InDelivery, Wrapping, Checking

                archived: Delivered, Returned, Canceled
                active: InDelivery, Wrapping, Checking

                Checking -> Wrapping -> InDelivery -> Delivered
                Checking -> Wrapping -> InDelivery -> Returned
                Checking -> Canceled
                 */

                OrderStatus status = order.getStatus();

                if (status == OrderStatus.CHECKING) {
                    Integer variant = orderUtil.generatorRandomNumber(MIN, MAX);

                    if (variant == 1) {
                        order.setStatus(OrderStatus.WRAPPING);
                    } else {
                        order.setStatus(OrderStatus.CANCELED);
                        order.setActive(false);
                    }

                } else if (status == OrderStatus.WRAPPING) {
                    order.setStatus(OrderStatus.DELIVERY);

                } else if (status == OrderStatus.DELIVERY) {
                    Integer variant = orderUtil.generatorRandomNumber(MIN, MAX);

                    if (variant == 1) {
                        order.setStatus(OrderStatus.DELIVERED);
                    } else {
                        order.setStatus(OrderStatus.RETURNED);
                    }

                    order.setActive(false);
                }
            }

        } catch (InterruptedException e) {
            log.error("Error while executing sample job", e);
        } finally {
            count.incrementAndGet();
            log.error("Sample job has finished...");
        }
    }

    public int getNumberOfInvocations() {
        return count.get();
    }
}
