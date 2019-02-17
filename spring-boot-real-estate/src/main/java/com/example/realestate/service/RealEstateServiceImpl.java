package com.example.realestate.service;

import com.example.realestate.model.RealEstate;
import com.example.realestate.repository.RealEstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component("realEstateService")
public class RealEstateServiceImpl implements RealEstateService {

    @Autowired
    RealEstateRepository realEstateRepository;

    public RealEstateServiceImpl(RealEstateRepository realEstateRepository) {
        this.realEstateRepository = realEstateRepository;
    }

    @Override
    public List<RealEstate> findChargingStationSortedByProductType() {
        return realEstateRepository.findAll(new Sort(Sort.Direction.ASC, "productType"));
    }

    @Override
    public List<RealEstate> findAllChargingStations() {
        return realEstateRepository.findAll();
    }

    @Override
    public Optional<RealEstate> findChargingStationById(String id) {
        return realEstateRepository.findById(id);
    }
}
