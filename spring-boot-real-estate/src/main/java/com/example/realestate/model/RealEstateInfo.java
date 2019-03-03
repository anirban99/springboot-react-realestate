package com.example.realestate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.List;

@Data
//@AllArgsConstructor
@Embeddable
@Document(collection = "real_estate")
public class RealEstateInfo {

//    private String add1; //addressToDisplay
//    private String comm1; //commercializationType
//    private List<String> fea1; //features

    private String addressToDisplay;
    private String commercializationType;
    private List<String> features;
    private String floorSpace;
    private String docId;
    private String priceForTotalArea;
    private String realtorCompanyName;
    private String realtorName;
    private String title;
    private String pictureUrl;
    private String productType;


    public RealEstateInfo() {

    }

    public RealEstateInfo(String addressToDisplay, String commercializationType, List<String> features, String floorSpace, String docId, String priceForTotalArea, String realtorCompanyName, String realtorName, String title, String pictureUrl, String productType) {
        this.addressToDisplay = addressToDisplay;
        this.commercializationType = commercializationType;
        this.features = features;
        this.floorSpace = floorSpace;
        this.docId = docId;
        this.priceForTotalArea = priceForTotalArea;
        this.realtorCompanyName = realtorCompanyName;
        this.realtorName = realtorName;
        this.title = title;
        this.pictureUrl = pictureUrl;
        this.productType = productType;
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

    public List<String> getFeatures() {
        return features;
    }

    public void setFeatures(List<String> features) {
        this.features = features;
    }

    public String getFloorSpace() {
        return floorSpace;
    }

    public void setFloorSpace(String floorSpace) {
        this.floorSpace = floorSpace;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
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
}
