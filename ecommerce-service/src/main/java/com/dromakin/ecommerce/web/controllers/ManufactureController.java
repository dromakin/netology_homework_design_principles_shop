/*
 * File:     ManufactureController
 * Package:  com.dromakin.ecommerce.web.controllers
 * Project:  netology_homework_design_principles_shop
 *
 * Created by dromakin as 04.04.2023
 *
 * author - dromakin
 * maintainer - dromakin
 * version - 2023.04.04
 * copyright - ORGANIZATION_NAME Inc. 2023
 */
package com.dromakin.ecommerce.web.controllers;

import com.dromakin.ecommerce.entities.Manufacturer;
import com.dromakin.ecommerce.services.ManufactureService;
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
@RequestMapping("/api/manufactures")
@Slf4j
@Api(value = "Manufacture Resource REST Endpoint")
public class ManufactureController {

    private final ManufactureService manufactureService;

    @Autowired
    public ManufactureController(ManufactureService manufactureService) {
        this.manufactureService = manufactureService;
    }


    @PostMapping("")
    public ResponseEntity<Manufacturer> create(
            @ApiParam(name = "Manufacturer json", required = true)
            @Valid @RequestBody Manufacturer manufacturer
    ) {
        Manufacturer createdManufacturer = manufactureService.saveManufacturer(manufacturer);

        if (createdManufacturer == null) {
            return ResponseEntity.notFound().build();

        } else {
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(createdManufacturer.getId())
                    .toUri();

            return ResponseEntity.created(uri)
                    .body(createdManufacturer);
        }
    }


    @GetMapping("")
    public ResponseEntity<List<Manufacturer>> read() {
        List<Manufacturer> manufacturerList = manufactureService.fetchManufacturer();

        if (manufacturerList == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(manufacturerList);
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<Manufacturer> read(
            @ApiParam(name = "Manufacturer id", required = true)
            @PathVariable Long id
    ) {
        Manufacturer manufacturer = manufactureService.fetchManufacturerById(id);
        if (manufacturer == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(manufacturer);
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Manufacturer> update(
            @ApiParam(name = "Manufacturer json", required = true)
            @RequestBody Manufacturer manufacturer,
            @ApiParam(name = "Manufacturer id", value = "1", example = "10", required = true)
            @PathVariable Long id
    ) {
        Manufacturer updatedManufacturer = manufactureService.updateManufacturer(manufacturer, id);
        if (updatedManufacturer == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updatedManufacturer);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(
            @ApiParam(name = "Manufacturer id", value = "1", example = "10", required = true)
            @PathVariable Long id
    ) {
        manufactureService.deleteManufacturer(id);
        return ResponseEntity.noContent().build();
    }


}
