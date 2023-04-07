package com.dromakin.ecommerce.repositories;

import com.dromakin.ecommerce.entities.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    Inventory findById(Long id);

    Inventory findByProductCode(String code);

}
