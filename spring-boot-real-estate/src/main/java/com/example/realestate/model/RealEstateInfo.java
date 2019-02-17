package com.example.realestate.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "real_estate")
public class RealEstateInfo {

    private Long id;
    private String longitude;
    private String latitude;


    public RealEstateInfo(Long id, String longitude, String latitude) {
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
