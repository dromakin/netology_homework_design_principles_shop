/*
 * File:     OrderStatus
 * Package:  com.dromakin.ecommerce.models
 * Project:  netology_homework_design_principles_shop
 *
 * Created by dromakin as 07.04.2023
 *
 * author - dromakin
 * maintainer - dromakin
 * version - 2023.04.07
 * copyright - ORGANIZATION_NAME Inc. 2023
 */
package com.dromakin.ecommerce.web.models;

import lombok.AccessLevel;
import lombok.Getter;

public enum OrderStatus {
    /*
    Checking -> Wrapping -> InDelivery -> Delivered
    Checking -> Wrapping -> InDelivery -> Returned
    Checking -> Canceled

    Active: InDelivery, Wrapping, Checking
    Archives: Delivered, Returned, Canceled
     */

    CHECKING("Checking"), WRAPPING("Wrapping"), DELIVERY("InDelivery"), DELIVERED("Delivered"), RETURNED("Returned"), CANCELED("Canceled");


    @Getter(AccessLevel.PUBLIC)
    public final String status;

    OrderStatus(String status) {
        this.status = status;
    }
}
