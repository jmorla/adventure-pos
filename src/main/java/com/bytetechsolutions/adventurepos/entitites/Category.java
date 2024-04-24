package com.bytetechsolutions.adventurepos.entitites;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "categories")
public class Category {
    
    @Id
    private int id;

    private String name;

    private String description;
}
