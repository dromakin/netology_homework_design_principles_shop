package com.dromakin.ecommerce.repositories;

import com.dromakin.ecommerce.entities.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufactureRepository extends JpaRepository<Manufacturer, Long> {
    Manufacturer findById(Long id);
}
