package com.example.e_shop;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static com.example.e_shop.ProductDetailsActivity.productOtherDetails;
import static com.example.e_shop.ProductDetailsActivity.tabPosition;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProductDesciptionFragment extends Fragment {


    public ProductDesciptionFragment() {
        // Required empty public constructor
    }

    private TextView descriptionBody;
    public static String productDescription;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_product_desciption, container, false);
        descriptionBody = view.findViewById(R.id.tv_product_description);
        if (tabPosition == 0) {
            descriptionBody.setText(productDescription);
        }else {
            descriptionBody.setText(productOtherDetails);
        }
        return view;
    }

}
