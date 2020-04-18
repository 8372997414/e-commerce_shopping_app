package com.example.e_shop;

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
public class MyCardFragment extends Fragment {

    public MyCardFragment() {
        // Required empty public constructor
    }

    private RecyclerView cartItemsRecyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_card, container, false);

        cartItemsRecyclerView = view.findViewById(R.id.card_items_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        cartItemsRecyclerView.setLayoutManager(layoutManager);

        List<CardItemModel> cardItemModelList = new ArrayList<>();
        cardItemModelList.add(new CardItemModel(0,R.drawable.forgotton_pw,"Pixel 2",2,"Rs.49999/-","Rs.59999/-",1,0,0));
        cardItemModelList.add(new CardItemModel(0,R.drawable.forgotton_pw,"Pixel 2",0,"Rs.49999/-","Rs.59999/-",1,1,0));
        cardItemModelList.add(new CardItemModel(0,R.drawable.forgotton_pw,"Pixel 2",2,"Rs.49999/-","Rs.59999/-",1,2,0));
        cardItemModelList.add(new CardItemModel(1,"Price (3 items)","Rs.169999/-","Free","Rs.16999/-","Rs.5999/-"));

        CardAdapter cardAdapter = new CardAdapter(cardItemModelList);
        cartItemsRecyclerView.setAdapter(cardAdapter);
        cardAdapter.notifyDataSetChanged();
        return view;
    }
}
