package com.example.realestate.controller;

import com.example.realestate.model.RealEstate;
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
    public List<RealEstate> getChargingStationSortedByProductType() {
        return realEstateService.findChargingStationSortedByProductType();
    }

    /** GET request to return all real estates **/
    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public List<RealEstate> getAllChargingStations() {
        return realEstateService.findAllChargingStations();
    }

    /** GET request to return real estate based on ID **/
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Optional<RealEstate> getChargingStationById(@PathVariable String id) {
        return realEstateService.findChargingStationById(id);
    }
}
