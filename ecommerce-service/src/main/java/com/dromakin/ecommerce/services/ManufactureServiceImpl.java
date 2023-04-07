/*
 * File:     ManufactureServiceImpl
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
import com.dromakin.ecommerce.repositories.ManufactureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
@Slf4j
public class ManufactureServiceImpl implements ManufactureService {

    private final ManufactureRepository manufactureRepository;

    @Autowired
    public ManufactureServiceImpl(ManufactureRepository manufactureRepository) {
        this.manufactureRepository = manufactureRepository;
    }

    @Override
    public Manufacturer saveManufacturer(Manufacturer manufacturer) {
        return manufactureRepository.save(manufacturer);
    }

    @Override
    public List<Manufacturer> fetchManufacturer() {
        return manufactureRepository.findAll();
    }

    @Override
    public Manufacturer fetchManufacturerById(Long id) {
        return manufactureRepository.findById(id);
    }

    @Override
    public Manufacturer updateManufacturer(Manufacturer manufacturer, Long id) {
        Manufacturer manDb = manufactureRepository.findOne(id);

        if (Objects.nonNull(manufacturer.getName())
                && !"".equalsIgnoreCase(manufacturer.getName())) {
            manDb.setName(manufacturer.getName());
        }

        if (Objects.nonNull(manufacturer.getDescription())
                && !"".equalsIgnoreCase(manufacturer.getDescription())) {
            manDb.setDescription(manufacturer.getDescription());
        }

        return manufactureRepository.save(manDb);
    }

    @Override
    public void deleteManufacturer(Long id) {
        manufactureRepository.delete(id);
    }
}
