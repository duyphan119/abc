package com.api.shoesshop.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.api.shoesshop.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findByAlias(String alias, Pageable pageable);

    Page<Product> findByNameContaining(String name, Pageable pageable);
}
