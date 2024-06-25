package com.bytetechsolutions.adventurepos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bytetechsolutions.adventurepos.domain.MeasurementUnitRecord;
import com.bytetechsolutions.adventurepos.entitites.MeasurementUnit;
import com.bytetechsolutions.adventurepos.repositories.MeasurementUnitRepository;

@Service
public class MesurementUnitServiceImpl implements MesurementUnitService {

    private final MeasurementUnitRepository measurementUnitRepository;

    public MesurementUnitServiceImpl(MeasurementUnitRepository measurementUnitRepository) {
        this.measurementUnitRepository = measurementUnitRepository;
    }

    @Override
    public List<MeasurementUnitRecord> getUnitsOfMesure() {
        return measurementUnitRepository.findAll()
                .stream().map(
                MesurementUnitServiceImpl::mapMeasurementUnitRecord)
                .toList();
    }

    private static final MeasurementUnitRecord mapMeasurementUnitRecord(MeasurementUnit unit) {
        return new MeasurementUnitRecord(unit.getId(), unit.getName(), unit.getDescription());
    }
    
}
