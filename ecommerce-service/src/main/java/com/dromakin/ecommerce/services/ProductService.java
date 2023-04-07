/*
 * File:     ProductService
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

import com.dromakin.ecommerce.entities.Product;

import java.util.List;

public interface ProductService {

    Product saveProduct(Product product);

    List<Product> saveProducts(List<Product> productList);

    List<Product> fetchProducts();
    List<Product> fetchProductsByName(String name);
    List<Product> fetchProductsByManufacturerId(Long id);
    Product fetchProductById(Long id);

    Product updateProduct(Product product, Long id);

    void deleteProduct(Long id);
}
