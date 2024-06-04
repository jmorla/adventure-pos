package com.bytetechsolutions.adventurepos.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bytetechsolutions.adventurepos.entitites.Category;


public interface CategoryRepository extends JpaRepository<Category, Integer> {
    
    Optional<Category> findByNameIgnoreCase(String name);
}
