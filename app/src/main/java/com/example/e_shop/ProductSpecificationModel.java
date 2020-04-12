package com.example.e_shop;

public class ProductSpecificationModel {

    private String featureName;
    private String getFeatureValue;


    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }


    public String getFeatureName() {
        return featureName;
    }

    public String getGetFeatureValue() {
        return getFeatureValue;
    }

    public void setGetFeatureValue(String getFeatureValue) {
        this.getFeatureValue = getFeatureValue;
    }

    public ProductSpecificationModel(String featureName, String getFeatureValue){

    }
}
