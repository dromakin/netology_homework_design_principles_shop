/*
 * File:     ManufactureService
 * Package:  com.dromakin.ecommerce.services
 * Project:  netology_homework_design_principles_shop
 *
 * Created by dromakin as 04.04.2023
 *
 * author - dromakin
 * maintainer - dromakin
 * version - 2023.04.04
 * copyright - ORGANIZATION_NAME Inc. 2023
 */
package com.dromakin.ecommerce.services;

import com.dromakin.ecommerce.entities.Manufacturer;

import java.util.List;

public interface ManufactureService {

    Manufacturer saveManufacturer(Manufacturer manufacturer);

    List<Manufacturer> fetchManufacturer();
    Manufacturer fetchManufacturerById(Long id);

    Manufacturer updateManufacturer(Manufacturer manufacturer, Long id);

    void deleteManufacturer(Long id);
}
