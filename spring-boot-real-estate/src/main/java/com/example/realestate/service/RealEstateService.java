package com.example.realestate.service;

import com.example.realestate.model.RealEstate;
import com.example.realestate.model.RealEstateCount;

import java.util.List;
import java.util.Optional;

public interface RealEstateService {

    List<RealEstate> findRealEstatesSortedByProductType();

    List<RealEstateCount> findRealEstatesGroupedByPostCode();

    List<RealEstate> findAllRealEstates();

    Optional<RealEstate> findRealEstateById(String id);

}
