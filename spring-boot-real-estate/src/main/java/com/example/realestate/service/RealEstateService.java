package com.example.realestate.service;

import com.example.realestate.model.RealEstate;

import java.util.List;
import java.util.Optional;

public interface RealEstateService {

    List<RealEstate> findChargingStationSortedByProductType();

    List<RealEstate> findAllChargingStations();

    Optional<RealEstate> findChargingStationById(String id);

}
