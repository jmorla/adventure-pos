package com.bytetechsolutions.adventurepos.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bytetechsolutions.adventurepos.entitites.Product;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    
}
