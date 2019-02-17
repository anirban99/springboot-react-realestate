package com.example.realestate.repository;

import com.example.realestate.model.RealEstate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RealEstateRepository extends MongoRepository<RealEstate, String>{


}
