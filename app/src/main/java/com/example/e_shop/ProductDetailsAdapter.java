package com.example.e_shop;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class ProductDetailsAdapter extends FragmentPagerAdapter {

    private int totalTab;
    private String productDescription;
    private String productOtherDetails;
    private List<ProductSpecificationModel> productSpecificationModelList;

    public ProductDetailsAdapter(FragmentManager fm,int totalTab, String productDescription, String productOtherDetails, List<ProductSpecificationModel> productSpecificationModelList) {
        super(fm);
        this.productDescription = productDescription;
        this.productOtherDetails = productOtherDetails;
        this.productSpecificationModelList = productSpecificationModelList;
        this.totalTab = totalTab;

    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0:
                ProductDesciptionFragment productDesciptionFragment1 = new ProductDesciptionFragment();
                productDesciptionFragment1.body = productDescription;
                return productDesciptionFragment1;
            case 1:
                ProductSpecificationFragment productSpecificationFragment = new ProductSpecificationFragment();
                productSpecificationFragment.productSpecificationModelList = productSpecificationModelList;
                return productSpecificationFragment;

            case 2:
                ProductDesciptionFragment productDesciptionFragment2 = new ProductDesciptionFragment();
                productDesciptionFragment2.body = productOtherDetails;
                return productDesciptionFragment2;

                default:

        }
        return null;
    }

    @Override
    public int getCount() {
        return totalTab;
    }
}