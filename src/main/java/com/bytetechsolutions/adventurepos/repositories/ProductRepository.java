package com.bytetechsolutions.adventurepos.repositories;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bytetechsolutions.adventurepos.entitites.Product;

public interface ProductRepository extends JpaRepository<Product, UUID> {

    @Query("""
        select p from Product p
        where lower(p.name) like lower(concat('%', :name, '%'))""")
    Page<Product> findBySearch(@Param("name") String name, Pageable pageable);


}
