package com.example.e_shop;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyOrdersFragment extends Fragment {

    public MyOrdersFragment() {
        // Required empty public constructor
    }

    private RecyclerView myOrdersRecyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_orders, container, false);

        myOrdersRecyclerView = view.findViewById(R.id.my_oraders_recyclerview);
        Context context;
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        myOrdersRecyclerView.setLayoutManager(layoutManager);
        List<MyOrderItemModel> myOrderItemModelList = new ArrayList<>();

        myOrderItemModelList.add(new MyOrderItemModel(R.drawable.forgotton_pw,2,"Pixel 2XL (BLACK)","Delivered on Mon , 15th JAN 2020"));
        myOrderItemModelList.add(new MyOrderItemModel(R.drawable.forgotton_pw,1,"Pixel 2XL (BLACK)","Delivered on Mon , 15th JAN 2020"));
        myOrderItemModelList.add(new MyOrderItemModel(R.drawable.forgotton_pw,3,"Pixel 2XL (BLACK)","Cancelled"));
        myOrderItemModelList.add(new MyOrderItemModel(R.drawable.forgotton_pw,2,"Pixel 2XL (BLACK)","Delivered on Mon , 15th JAN 2020"));

        MyOrderAdapter myOrderAdapter = new MyOrderAdapter(myOrderItemModelList);
        myOrdersRecyclerView.setAdapter(myOrderAdapter);
        myOrderAdapter.notifyDataSetChanged();
        return view;
    }

}
