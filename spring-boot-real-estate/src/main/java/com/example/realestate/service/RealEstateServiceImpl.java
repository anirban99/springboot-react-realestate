package com.example.realestate.service;

import com.example.realestate.model.RealEstate;
import com.example.realestate.model.RealEstateCount;
import com.example.realestate.model.RealEstateInfo;
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
    public List<RealEstate> findRealEstatesSortedByProductType() {
        return realEstateRepository.findAll(new Sort(Sort.Direction.ASC, "resultListEntries.productType"));
//        return realEstateRepository.findAll(new Sort(Sort.Direction.ASC, new RealEstateInfo().getProductType()));
    }

    @Override
    public List<RealEstateCount> findRealEstatesGroupedByPostCode() {
        return realEstateRepository.getRealEstateCount();
    }

    @Override
    public List<RealEstate> findAllRealEstates() {
        return realEstateRepository.findAll();
    }

    @Override
    public Optional<RealEstate> findRealEstateById(String id) {
        return realEstateRepository.findById(id);
    }
}
