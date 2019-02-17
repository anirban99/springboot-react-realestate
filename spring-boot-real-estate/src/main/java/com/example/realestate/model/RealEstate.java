package com.example.realestate.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "real_estate")
public class RealEstate {

    @TextIndexed
    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
    private GeoJsonPoint geoName;

    private String addressToDisplay;
    private String commercializationType;
    private String features;
    private String floorSpace;
    private @Id String id;
    private String priceForTotalArea;
    private String realtorCompanyName;
    private String realtorName;
    private String title;
    private String pictureUrl;
    private String productType;

    public RealEstate(GeoJsonPoint geoName, String addressToDisplay, String commercializationType, String features, String floorSpace, String priceForTotalArea, String realtorCompanyName, String realtorName, String title, String pictureUrl, String productType) {
        this.geoName = geoName;
        this.addressToDisplay = addressToDisplay;
        this.commercializationType = commercializationType;
        this.features = features;
        this.floorSpace = floorSpace;
        this.id = id;
        this.priceForTotalArea = priceForTotalArea;
        this.realtorCompanyName = realtorCompanyName;
        this.realtorName = realtorName;
        this.title = title;
        this.pictureUrl = pictureUrl;
        this.productType = productType;
    }

    public GeoJsonPoint getGeoName() {
        return geoName;
    }

    public void setGeoName(GeoJsonPoint geoName) {
        this.geoName = geoName;
    }

    public String getAddressToDisplay() {
        return addressToDisplay;
    }

    public void setAddressToDisplay(String addressToDisplay) {
        this.addressToDisplay = addressToDisplay;
    }

    public String getCommercializationType() {
        return commercializationType;
    }

    public void setCommercializationType(String commercializationType) {
        this.commercializationType = commercializationType;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getFloorSpace() {
        return floorSpace;
    }

    public void setFloorSpace(String floorSpace) {
        this.floorSpace = floorSpace;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPriceForTotalArea() {
        return priceForTotalArea;
    }

    public void setPriceForTotalArea(String priceForTotalArea) {
        this.priceForTotalArea = priceForTotalArea;
    }

    public String getRealtorCompanyName() {
        return realtorCompanyName;
    }

    public void setRealtorCompanyName(String realtorCompanyName) {
        this.realtorCompanyName = realtorCompanyName;
    }

    public String getRealtorName() {
        return realtorName;
    }

    public void setRealtorName(String realtorName) {
        this.realtorName = realtorName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        final RealEstate that = (RealEstate) o;
        return Objects.equals(this.getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId());
    }
}
