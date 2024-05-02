package com.bytetechsolutions.adventurepos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bytetechsolutions.adventurepos.entitites.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
    
}
