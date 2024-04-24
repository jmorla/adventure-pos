package com.bytetechsolutions.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bytetechsolutions.entitites.Product;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    
}
