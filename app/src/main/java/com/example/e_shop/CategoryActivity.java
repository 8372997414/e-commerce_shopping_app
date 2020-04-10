package com.example.e_shop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {

    private RecyclerView categoryRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        Toolbar toolbar =(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String title = getIntent().getStringExtra("CategoryName");
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        categoryRecyclerView = findViewById(R.id.category_recyclerview);

        ////////////////////Banner Slider
        List<SliderModel> sliderModelList = new ArrayList<SliderModel>();

        sliderModelList.add(new SliderModel(R.drawable.sliderbanner4,"#faf0f0"));
        sliderModelList.add(new SliderModel(R.drawable.sliderbanner5,"#faf0f0"));
        sliderModelList.add(new SliderModel(R.drawable.sliderbanner,"#faf0f0"));

        sliderModelList.add(new SliderModel(R.drawable.sliderbanner1,"#faf0f0"));
        sliderModelList.add(new SliderModel(R.drawable.sliderbanner2,"#faf0f0"));
        sliderModelList.add(new SliderModel(R.drawable.sliderbanner3,"#faf0f0"));
        sliderModelList.add(new SliderModel(R.drawable.sliderbanner4,"#faf0f0"));

        sliderModelList.add(new SliderModel(R.drawable.sliderbanner5,"#faf0f0"));
        sliderModelList.add(new SliderModel(R.drawable.sliderbanner,"#faf0f0"));
        sliderModelList.add(new SliderModel(R.drawable.sliderbanner1,"#faf0f0"));
        ////////////////////Banner Slider

        //////////// Horizontal Product Layout

        List<HorizontalProdutScrollModel> horizontalProdutScrollModelList =new ArrayList<>();
        horizontalProdutScrollModelList.add(new HorizontalProdutScrollModel(R.drawable.forgotton_pw,"Redmi 5A","SD 625 Processer","Rs.5999/-"));
        horizontalProdutScrollModelList.add(new HorizontalProdutScrollModel(R.drawable.forgotton_pw,"Redmi 5A","SD 625 Processer","Rs.5999/-"));
        horizontalProdutScrollModelList.add(new HorizontalProdutScrollModel(R.drawable.forgotton_pw,"Redmi 5A","SD 625 Processer","Rs.5999/-"));
        horizontalProdutScrollModelList.add(new HorizontalProdutScrollModel(R.drawable.forgotton_pw,"Redmi 5A","SD 625 Processer","Rs.5999/-"));
        horizontalProdutScrollModelList.add(new HorizontalProdutScrollModel(R.drawable.forgotton_pw,"Redmi 5A","SD 625 Processer","Rs.5999/-"));
        horizontalProdutScrollModelList.add(new HorizontalProdutScrollModel(R.drawable.forgotton_pw,"Redmi 5A","SD 625 Processer","Rs.5999/-"));
        horizontalProdutScrollModelList.add(new HorizontalProdutScrollModel(R.drawable.forgotton_pw,"Redmi 5A","SD 625 Processer","Rs.5999/-"));
        horizontalProdutScrollModelList.add(new HorizontalProdutScrollModel(R.drawable.forgotton_pw,"Redmi 5A","SD 625 Processer","Rs.5999/-"));

        //////////// Horizontal Product Layout

        ///////////////////////Homepage Recyclerview
        LinearLayoutManager testingLayoutManager = new LinearLayoutManager(this);
        categoryRecyclerView.setLayoutManager(testingLayoutManager);

        List<HomePageModel> homePageModelList = new ArrayList<>();
        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.sliderbanner,"ffff00"));
        homePageModelList.add(new HomePageModel(2,"Deals of the Day!",horizontalProdutScrollModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.sliderbanner,"ffff00"));
        homePageModelList.add(new HomePageModel(3,"Deals of the Day!",horizontalProdutScrollModelList));
        homePageModelList.add(new HomePageModel(3,"Deals of the Day!",horizontalProdutScrollModelList));
        homePageModelList.add(new HomePageModel(3,"Deals of the Day!",horizontalProdutScrollModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.sliderbanner,"ffff00"));
        homePageModelList.add(new HomePageModel(1,R.drawable.sliderbanner,"ffff00"));

        HomePageAdapter adapter = new HomePageAdapter(homePageModelList);
        categoryRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        ///////////////////////Homepage Recyclerview

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_icon, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.main_search_icon) {
            //todo: search
            return true;
        }else if (id == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
