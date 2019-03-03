package com.example.realestate.controller;

import com.example.realestate.model.RealEstate;
import com.example.realestate.model.RealEstateCount;
import com.example.realestate.service.RealEstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/realestates")
public class RealEstateController {

    @Autowired
    private RealEstateService realEstateService;

    public RealEstateController(RealEstateService realEstateService) {
        this.realEstateService = realEstateService;
    }

    /** GET request to return all real estates sorted by Product Type **/
    @RequestMapping(method = RequestMethod.GET)
    public List<RealEstate> getRealEstatesSortedByProductType() {
        return realEstateService.findRealEstatesSortedByProductType();
    }

    /** GET request to return all real estates grouped by Post Code **/
    @RequestMapping(path = "/count", method = RequestMethod.GET)
    public List<RealEstateCount> getRealEstatesGroupedByPostCode() {
        return realEstateService.findRealEstatesGroupedByPostCode();
    }

    /** GET request to return all real estates **/
    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public List<RealEstate> getAllRealEstates() {
        return realEstateService.findAllRealEstates();
    }

    /** GET request to return real estate based on ID **/
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Optional<RealEstate> getRealEstateById(@PathVariable String id) {
        return realEstateService.findRealEstateById(id);
    }
}
