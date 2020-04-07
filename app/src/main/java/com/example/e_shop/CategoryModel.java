package com.example.e_shop;

public class CategoryModel {

    private String CategoryIconLink;
    private String categoryName;

    public CategoryModel(String categoryIconlink, String categoryName) {
        CategoryIconLink = categoryIconlink;
        this.categoryName = categoryName;
    }

    public String getCategoryIconlink() {
        return CategoryIconLink;
    }

    public void setCategoryIconlink(String categoryIconlink) {
        CategoryIconLink = categoryIconlink;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
