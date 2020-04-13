package com.example.e_shop;

public class ProductSpecificationModel {

    public static final int SPECIFICATION_TITLE = 0;
    public static final int SPECIFICATION_BOBY = 1;

    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    ////////Specification title
    private String title;

    public ProductSpecificationModel(int type, String title) {
        this.type = type;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    ////////Specification title

    ////////Specification Boby
    private String featureName;
    private String getFeatureValue;
    public ProductSpecificationModel(int type, String featureName, String getFeatureValue) {
        this.type = type;
        this.featureName = featureName;
        this.getFeatureValue = getFeatureValue;
    }
    public String getFeatureName() {
        return featureName;
    }
    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }
    public String getGetFeatureValue() {
        return getFeatureValue;
    }
    public void setGetFeatureValue(String getFeatureValue) {
        this.getFeatureValue = getFeatureValue;
    }
    ////////Specification Boby




}
