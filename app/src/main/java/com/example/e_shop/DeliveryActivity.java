package com.example.e_shop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class DeliveryActivity extends AppCompatActivity {

    private RecyclerView deliveryRecyclerView;
    private Button changeOrNewAddressBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);
        Toolbar toolbar =(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Delivery");

        deliveryRecyclerView = findViewById(R.id.delivery_recyclerview);
        changeOrNewAddressBtn = findViewById(R.id.change_or_add_address_btn);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        deliveryRecyclerView.setLayoutManager(layoutManager);

        List<CardItemModel> cardItemModelList = new ArrayList<>();
        cardItemModelList.add(new CardItemModel(0,R.drawable.forgotton_pw,"Pixel 2",2,"Rs.49999/-","Rs.59999/-",1,0,0));
        cardItemModelList.add(new CardItemModel(0,R.drawable.forgotton_pw,"Pixel 2",0,"Rs.49999/-","Rs.59999/-",1,1,0));
        cardItemModelList.add(new CardItemModel(0,R.drawable.forgotton_pw,"Pixel 2",2,"Rs.49999/-","Rs.59999/-",1,2,0));
        cardItemModelList.add(new CardItemModel(1,"Price (3 items)","Rs.169999/-","Free","Rs.16999/-","Rs.5999/-"));

        CardAdapter cardAdapter = new CardAdapter(cardItemModelList);
        deliveryRecyclerView.setAdapter(cardAdapter);
        cardAdapter.notifyDataSetChanged();
        changeOrNewAddressBtn.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
