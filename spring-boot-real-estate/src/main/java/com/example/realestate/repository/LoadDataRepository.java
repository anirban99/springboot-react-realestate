package com.example.realestate.repository;

import com.example.realestate.model.RealEstate;
import com.example.realestate.model.RealEstateInfo;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@Slf4j
public class LoadDataRepository {

    static final private Logger logger = LoggerFactory.getLogger(LoadDataRepository.class);

    @Bean
    CommandLineRunner initDatabase(RealEstateRepository realEstateRepository) {
        return args -> {
            realEstateRepository.deleteAll();
            logger.info("Preloading " + realEstateRepository.save(new RealEstate("Berlin", new RealEstateInfo("10178, Berlin", "RENT", Arrays.asList("2 Bedroom, Kitchen, Bathroom") ,"80 sq. m","65573128","1100 EUR", "EB Immo", "Michael", "EBM", "www.google.com", "L"))));
            logger.info("Preloading " + realEstateRepository.save(new RealEstate("Berlin", new RealEstateInfo("10179, Berlin", "BUY", Arrays.asList("1 Bedroom, Kitchen, Bathroom"), "50 sq. m", "65573129","700 EUR", "Best Immo", "Eric", "BI", "www.google.com", "S"))));
            logger.info("Preloading " + realEstateRepository.save(new RealEstate("Berlin", new RealEstateInfo("10589, Berlin", "BUY", Arrays.asList("3 Bedroom, Kitchen, Bathroom, Balcony"), "90 sq. m", "65573130","1300 EUR", "Immowelt", "Christian", "IW", "www.google.com", "L"))));
        };
    }
}