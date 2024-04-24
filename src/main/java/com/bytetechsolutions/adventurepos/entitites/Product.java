package com.bytetechsolutions.adventurepos.entitites;

import java.util.UUID;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "products")
public class Product {
    
    @Id
    private UUID id;

    @Column(name = "product_name")
    private String name;

    private double price;

    private int quantity;

    private double cost;

    @Enumerated(EnumType.STRING)
    private ProductStatus status;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @Fetch(FetchMode.JOIN)
    private Category category;


    public enum ProductStatus {
        ACTIVE, INACTIVE
    }
}
