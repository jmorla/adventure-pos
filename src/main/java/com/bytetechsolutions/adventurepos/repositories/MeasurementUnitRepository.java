package com.bytetechsolutions.adventurepos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bytetechsolutions.adventurepos.entitites.MeasurementUnit;

public interface MeasurementUnitRepository extends JpaRepository<MeasurementUnit, Integer> {
    
}
