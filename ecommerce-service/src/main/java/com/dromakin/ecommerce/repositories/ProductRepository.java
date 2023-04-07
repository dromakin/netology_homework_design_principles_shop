package com.dromakin.ecommerce.repositories;

import com.dromakin.ecommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByName(String name);
    Product findById(Long id);
    List<Product> findByManufacturer(Long id);
}
