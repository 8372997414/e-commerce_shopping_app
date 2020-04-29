package com.example.e_shop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class ViewAllActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Deals of the Day");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.recycler_view);
        gridView = findViewById(R.id.grid_view);

        int layout_code = getIntent().getIntExtra("layout_code",-1);

        if (layout_code == 0) {
            recyclerView.setVisibility(View.VISIBLE);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(layoutManager);

            List<WishlistModel> wishlistModelList = new ArrayList<>();
            wishlistModelList.add(new WishlistModel(R.drawable.forgotton_pw, "Pixel 2", 1, "3", 145, "Rs.49999/-", "Rs.59999/-", "Cash on delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.forgotton_pw, "Pixel 2", 0, "3", 145, "Rs.49999/-", "Rs.59999/-", "Cash on delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.forgotton_pw, "Pixel 2", 2, "3", 145, "Rs.49999/-", "Rs.59999/-", "Cash on delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.forgotton_pw, "Pixel 2", 4, "3", 145, "Rs.49999/-", "Rs.59999/-", "Cash on delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.forgotton_pw, "Pixel 2", 1, "3", 145, "Rs.49999/-", "Rs.59999/-", "Cash on delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.forgotton_pw, "Pixel 2", 1, "3", 145, "Rs.49999/-", "Rs.59999/-", "Cash on delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.forgotton_pw, "Pixel 2", 0, "3", 145, "Rs.49999/-", "Rs.59999/-", "Cash on delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.forgotton_pw, "Pixel 2", 2, "3", 145, "Rs.49999/-", "Rs.59999/-", "Cash on delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.forgotton_pw, "Pixel 2", 4, "3", 145, "Rs.49999/-", "Rs.59999/-", "Cash on delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.forgotton_pw, "Pixel 2", 1, "3", 145, "Rs.49999/-", "Rs.59999/-", "Cash on delivery"));


            WishlistAdaptor adaptor = new WishlistAdaptor(wishlistModelList, false);
            recyclerView.setAdapter(adaptor);
            adaptor.notifyDataSetChanged();
        }else if (layout_code == 1) {

            gridView.setVisibility(View.VISIBLE);
            List<HorizontalProdutScrollModel> horizontalProdutScrollModelList = new ArrayList<>();
            horizontalProdutScrollModelList.add(new HorizontalProdutScrollModel(R.drawable.forgotton_pw, "Redmi 5A", "SD 625 Processer", "Rs.5999/-"));
            horizontalProdutScrollModelList.add(new HorizontalProdutScrollModel(R.drawable.forgotton_pw, "Redmi 5A", "SD 625 Processer", "Rs.5999/-"));
            horizontalProdutScrollModelList.add(new HorizontalProdutScrollModel(R.drawable.forgotton_pw, "Redmi 5A", "SD 625 Processer", "Rs.5999/-"));
            horizontalProdutScrollModelList.add(new HorizontalProdutScrollModel(R.drawable.forgotton_pw, "Redmi 5A", "SD 625 Processer", "Rs.5999/-"));
            horizontalProdutScrollModelList.add(new HorizontalProdutScrollModel(R.drawable.forgotton_pw, "Redmi 5A", "SD 625 Processer", "Rs.5999/-"));
            horizontalProdutScrollModelList.add(new HorizontalProdutScrollModel(R.drawable.forgotton_pw, "Redmi 5A", "SD 625 Processer", "Rs.5999/-"));
            horizontalProdutScrollModelList.add(new HorizontalProdutScrollModel(R.drawable.forgotton_pw, "Redmi 5A", "SD 625 Processer", "Rs.5999/-"));
            horizontalProdutScrollModelList.add(new HorizontalProdutScrollModel(R.drawable.forgotton_pw, "Redmi 5A", "SD 625 Processer", "Rs.5999/-"));
            horizontalProdutScrollModelList.add(new HorizontalProdutScrollModel(R.drawable.forgotton_pw, "Redmi 5A", "SD 625 Processer", "Rs.5999/-"));
            horizontalProdutScrollModelList.add(new HorizontalProdutScrollModel(R.drawable.forgotton_pw, "Redmi 5A", "SD 625 Processer", "Rs.5999/-"));
            horizontalProdutScrollModelList.add(new HorizontalProdutScrollModel(R.drawable.forgotton_pw, "Redmi 5A", "SD 625 Processer", "Rs.5999/-"));
            horizontalProdutScrollModelList.add(new HorizontalProdutScrollModel(R.drawable.forgotton_pw, "Redmi 5A", "SD 625 Processer", "Rs.5999/-"));
            horizontalProdutScrollModelList.add(new HorizontalProdutScrollModel(R.drawable.forgotton_pw, "Redmi 5A", "SD 625 Processer", "Rs.5999/-"));
            horizontalProdutScrollModelList.add(new HorizontalProdutScrollModel(R.drawable.forgotton_pw, "Redmi 5A", "SD 625 Processer", "Rs.5999/-"));
            horizontalProdutScrollModelList.add(new HorizontalProdutScrollModel(R.drawable.forgotton_pw, "Redmi 5A", "SD 625 Processer", "Rs.5999/-"));
            horizontalProdutScrollModelList.add(new HorizontalProdutScrollModel(R.drawable.forgotton_pw, "Redmi 5A", "SD 625 Processer", "Rs.5999/-"));


            GridProductLayoutAdapter gridProductLayoutAdapter = new GridProductLayoutAdapter(horizontalProdutScrollModelList);
            gridView.setAdapter(gridProductLayoutAdapter);

        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       if (item.getItemId() == android.R.id.home){
           finish();
           return true;
       }
        return super.onOptionsItemSelected(item);
    }
}
