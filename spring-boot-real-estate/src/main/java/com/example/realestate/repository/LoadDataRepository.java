package com.example.realestate.repository;

import com.example.realestate.model.RealEstate;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

@Configuration
@Slf4j
public class LoadDataRepository {

    static final private Logger logger = LoggerFactory.getLogger(LoadDataRepository.class);

    @Bean
    CommandLineRunner initDatabase(RealEstateRepository realEstateRepository) {
        return args -> {
            realEstateRepository.deleteAll();
            logger.info("Preloading " + realEstateRepository.save(new RealEstate(new GeoJsonPoint(Double.valueOf(13.404954),Double.valueOf(52.525008)), "10178, Berlin",
                "RENT","2 Bedroom, Kitchen, Bathroom", "80 sq. m", "1100 EUR", "EB Immo", "Michael", "EBM", "www.google.com", "L")));
            logger.info("Preloading " + realEstateRepository.save(new RealEstate(new GeoJsonPoint(Double.valueOf(13.406954),Double.valueOf(52.513008)), "10179, Berlin",
                "BUY", "1 Bedroom, Kitchen, Bathroom", "50 sq. m", "700 EUR", "Best Immo", "Eric", "BI", "www.google.com", "S")));
            logger.info("Preloading " + realEstateRepository.save(new RealEstate(new GeoJsonPoint(Double.valueOf(13.300954),Double.valueOf(52.524008)), "10589, Berlin",
                "BUY", "3 Bedroom, Kitchen, Bathroom, Balcony", "90 sq. m", "1300 EUR", "Immowelt", "Christian", "IW", "www.google.com", "L")));
        };
    }
}
