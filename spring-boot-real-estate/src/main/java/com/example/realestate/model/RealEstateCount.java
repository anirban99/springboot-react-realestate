package com.example.realestate.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "real_estate")
public class RealEstateCount {

    private String addressToDisplay;
    private long total;

    public String getAddressToDisplay() {
        return addressToDisplay;
    }

    public void setAddressToDisplay(String addressToDisplay) {
        this.addressToDisplay = addressToDisplay;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
