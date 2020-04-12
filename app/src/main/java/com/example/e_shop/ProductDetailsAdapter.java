package com.example.e_shop;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ProductDetailsAdapter extends FragmentPagerAdapter {

    private int totalTab;

    public ProductDetailsAdapter(FragmentManager fm, int totalTab) {
        super(fm);
        this.totalTab = totalTab;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0:
                ProductDesciptionFragment productDesciptionFragment1 = new ProductDesciptionFragment();
                return productDesciptionFragment1;

            case 1:
                ProductSpecificationFragment productSpecificationFragment = new ProductSpecificationFragment();
                return productSpecificationFragment;

            case 2:
                ProductDesciptionFragment productDesciptionFragment2 = new ProductDesciptionFragment();
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