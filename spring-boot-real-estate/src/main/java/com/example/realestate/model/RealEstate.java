package com.example.realestate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Data
//@AllArgsConstructor
@Entity
@Document(collection = "real_estate")
public class RealEstate {

//    @TextIndexed
//    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
//    private GeoJsonPoint geoName;

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private String id;
    private String name;

    @Embedded
    private RealEstateInfo resultListEntries;
//    private String addressToDisplay;
//    private String commercializationType;
//    private List<String> features;
//    private String floorSpace;
//    private String docId;
//    private String priceForTotalArea;
//    private String realtorCompanyName;
//    private String realtorName;
//    private String title;
//    private String pictureUrl;
//    private String productType;

    public RealEstate() {

    }

    public RealEstate(String name, RealEstateInfo resultListEntries) {
        this.name = name;
        this.resultListEntries = resultListEntries;
    }

//    public RealEstate(String name, RealEstateInfo resultListEntries, String addressToDisplay) {
//        this.name = name;
//        this.resultListEntries = resultListEntries;
//        this.addressToDisplay = addressToDisplay;
//    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RealEstateInfo getResultListEntries() {
        return resultListEntries;
    }

    public void setResultListEntries(RealEstateInfo resultListEntries) {
        this.resultListEntries = resultListEntries;
    }

    //    public RealEstate(String name, String addressToDisplay, String commercializationType, List<String> features, String floorSpace, String docId, String priceForTotalArea, String realtorCompanyName, String realtorName, String title, String pictureUrl, String productType) {
//        this.name = name;
//        this.addressToDisplay = addressToDisplay;
//        this.commercializationType = commercializationType;
//        this.features = features;
//        this.floorSpace = floorSpace;
//        this.docId = docId;
//        this.priceForTotalArea = priceForTotalArea;
//        this.realtorCompanyName = realtorCompanyName;
//        this.realtorName = realtorName;
//        this.title = title;
//        this.pictureUrl = pictureUrl;
//        this.productType = productType;
//    }

//    public RealEstate(String name, RealEstateInfo resultlistEntries, String addressToDisplay, String commercializationType, List<String> features, String floorSpace, String docId, String priceForTotalArea, String realtorCompanyName, String realtorName, String title, String pictureUrl, String productType) {
//        this.name = name;
//        this.resultlistEntries = resultlistEntries;
//        this.addressToDisplay = addressToDisplay;
//        this.commercializationType = commercializationType;
//        this.features = features;
//        this.floorSpace = floorSpace;
//        this.priceForTotalArea = priceForTotalArea;
//        this.realtorCompanyName = realtorCompanyName;
//        this.realtorName = realtorName;
//        this.title = title;
//        this.pictureUrl = pictureUrl;
//        this.productType = productType;
//    }



//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public RealEstateInfo getResultlistEntries() {
//        return resultlistEntries;
//    }
//
//    public void setResultlistEntries(RealEstateInfo resultlistEntries) {
//        this.resultlistEntries = resultlistEntries;
//    }
//
//    //    public GeoJsonPoint getGeoName() {
////        return geoName;
////    }
////
////    public void setGeoName(GeoJsonPoint geoName) {
////        this.geoName = geoName;
////    }
//
//    public String getAddressToDisplay() {
//        return addressToDisplay;
//    }
//
//    public void setAddressToDisplay(String addressToDisplay) {
//        this.addressToDisplay = addressToDisplay;
//    }
//
//    public String getCommercializationType() {
//        return commercializationType;
//    }
//
//    public void setCommercializationType(String commercializationType) {
//        this.commercializationType = commercializationType;
//    }
//
//    public List<String> getFeatures() {
//        return features;
//    }
//
//    public void setFeatures(List<String> features) {
//        this.features = features;
//    }
//
//    public String getFloorSpace() {
//        return floorSpace;
//    }
//
//    public void setFloorSpace(String floorSpace) {
//        this.floorSpace = floorSpace;
//    }
//
//    public String getDocId() {
//        return docId;
//    }
//
//    public void setDocId(String docId) {
//        this.docId = docId;
//    }
//
//    public String getPriceForTotalArea() {
//        return priceForTotalArea;
//    }
//
//    public void setPriceForTotalArea(String priceForTotalArea) {
//        this.priceForTotalArea = priceForTotalArea;
//    }
//
//    public String getRealtorCompanyName() {
//        return realtorCompanyName;
//    }
//
//    public void setRealtorCompanyName(String realtorCompanyName) {
//        this.realtorCompanyName = realtorCompanyName;
//    }
//
//    public String getRealtorName() {
//        return realtorName;
//    }
//
//    public void setRealtorName(String realtorName) {
//        this.realtorName = realtorName;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getPictureUrl() {
//        return pictureUrl;
//    }
//
//    public void setPictureUrl(String pictureUrl) {
//        this.pictureUrl = pictureUrl;
//    }
//
//    public String getProductType() {
//        return productType;
//    }
//
//    public void setProductType(String productType) {
//        this.productType = productType;
//    }

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
