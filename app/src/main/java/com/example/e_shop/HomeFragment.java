package com.example.e_shop;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }

    private RecyclerView categoryRecyclerView;
    private CategoryAdapter categoryAdapter;

    ////////////////////Banner Slider
    private ViewPager bannerSliderViewPager;
    private List<SliderModel> sliderModelList;
    private int currentPage = 2;
    private Timer timer;
    final private long DELAY_TIME = 3000;
    final private long PERIOD_TIME = 3000;

    ////////////////////Banner Slider

    ////////////Strip Ad
    private ImageView stripAdImage;
    private ConstraintLayout stripAdContainer;
    ////////////Strip Ad

    //////////// Horizontal Product Layout
    private TextView horizontalLayoutTitle;
    private Button horizontalLayoutViewAllBtn;
    private RecyclerView horizontalRecyclerView;
    //////////// Horizontal Product Layout



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        categoryRecyclerView = view.findViewById(R.id.category_recyclerview);
        Context context;
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        categoryRecyclerView.setLayoutManager(layoutManager);

        List<CategoryModel> categoryModelList = new ArrayList<CategoryModel>();
        categoryModelList.add(new CategoryModel("link","Home"));
        categoryModelList.add(new CategoryModel("link","Electronic"));
        categoryModelList.add(new CategoryModel("link","Appliances"));
        categoryModelList.add(new CategoryModel("link","Furniture"));
        categoryModelList.add(new CategoryModel("link","Toys"));
        categoryModelList.add(new CategoryModel("link","Home"));
        categoryModelList.add(new CategoryModel("link","Electronic"));
        categoryModelList.add(new CategoryModel("link","Appliances"));
        categoryModelList.add(new CategoryModel("link","Furniture"));
        categoryModelList.add(new CategoryModel("link","Toys"));


        categoryAdapter = new CategoryAdapter(categoryModelList);
        categoryRecyclerView.setAdapter(categoryAdapter);
        categoryAdapter.notifyDataSetChanged();


        ////////////////////Banner Slider

        bannerSliderViewPager = view.findViewById(R.id.banner_slider_viewPager);

        sliderModelList = new ArrayList<SliderModel>();

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


        SliderAdapter sliderAdapter = new SliderAdapter(sliderModelList);
        bannerSliderViewPager.setAdapter(sliderAdapter);
        bannerSliderViewPager.setClipToPadding(false);
        bannerSliderViewPager.setPageMargin(20);

        bannerSliderViewPager.setCurrentItem(currentPage);

        ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                currentPage = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

                if (state == ViewPager.SCROLL_STATE_IDLE){
                    pageLooper();
                }
            }
        };
        bannerSliderViewPager.addOnPageChangeListener(onPageChangeListener);

        startBannerSlideShow();

        bannerSliderViewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                pageLooper();
                stopBannerSlideShow();
                if (event.getAction() == MotionEvent.ACTION_UP){
                    startBannerSlideShow();
                }

                return false;
            }
        });

       ////////////////////Banner Slider

        ////////////Strip  Ad

        stripAdImage = view.findViewById(R.id.strip_ad_image);
        stripAdContainer = view.findViewById(R.id.strip_ad_container);

        stripAdImage.setImageResource(R.drawable.sliderbanner);
        stripAdContainer.setBackgroundColor(Color.parseColor("#000000"));

        ////////////Strip Ad

        //////////// Horizontal Product Layout

        horizontalLayoutTitle = view.findViewById(R.id.horizontal_scroll_layout_title);
        horizontalLayoutViewAllBtn = view.findViewById(R.id.horizontal_scroll_viewall_button);
        horizontalRecyclerView = view.findViewById(R.id.horizontal_scroll_layout_recyclerView);

        List<HorizontalProdutScrollModel> horizontalProdutScrollModelList =new ArrayList<>();
        horizontalProdutScrollModelList.add(new HorizontalProdutScrollModel(R.drawable.forgotton_pw,"Redmi 5A","SD 625 Processer","Rs.5999/-"));
        horizontalProdutScrollModelList.add(new HorizontalProdutScrollModel(R.drawable.forgotton_pw,"Redmi 5A","SD 625 Processer","Rs.5999/-"));
        horizontalProdutScrollModelList.add(new HorizontalProdutScrollModel(R.drawable.forgotton_pw,"Redmi 5A","SD 625 Processer","Rs.5999/-"));
        horizontalProdutScrollModelList.add(new HorizontalProdutScrollModel(R.drawable.forgotton_pw,"Redmi 5A","SD 625 Processer","Rs.5999/-"));
        horizontalProdutScrollModelList.add(new HorizontalProdutScrollModel(R.drawable.forgotton_pw,"Redmi 5A","SD 625 Processer","Rs.5999/-"));
        horizontalProdutScrollModelList.add(new HorizontalProdutScrollModel(R.drawable.forgotton_pw,"Redmi 5A","SD 625 Processer","Rs.5999/-"));
        horizontalProdutScrollModelList.add(new HorizontalProdutScrollModel(R.drawable.forgotton_pw,"Redmi 5A","SD 625 Processer","Rs.5999/-"));
        horizontalProdutScrollModelList.add(new HorizontalProdutScrollModel(R.drawable.forgotton_pw,"Redmi 5A","SD 625 Processer","Rs.5999/-"));

        HorizontalProductScrollAdapter horizontalProductScrollAdapter = new HorizontalProductScrollAdapter(horizontalProdutScrollModelList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        horizontalRecyclerView.setLayoutManager(linearLayoutManager);

        horizontalRecyclerView.setAdapter(horizontalProductScrollAdapter);
        horizontalProductScrollAdapter.notifyDataSetChanged();
        //////////// Horizontal Product Layout

        //////////// Grid Product Layout

        TextView gridLayoutTitle = view.findViewById(R.id.grid_product_layout_title);
        Button gridLayoutViewAllBtn = view.findViewById(R.id.grid_product_layout_viewall_btn);
        GridView gridView = view.findViewById(R.id.grid_product_layout_gridview);

        gridView.setAdapter(new GridProductLayoutAdapter(horizontalProdutScrollModelList));

        //////////// Grid Product Layout

        ///////////////////////testing

        RecyclerView testing = view.findViewById(R.id.testing);
        LinearLayoutManager testingLayoutManager = new LinearLayoutManager(getContext());
        testing.setLayoutManager(testingLayoutManager);

        List<HomePageModel> homePageModelList = new ArrayList<>();
        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.sliderbanner,"ffff00"));
        homePageModelList.add(new HomePageModel(2,"Deals of the Day!",horizontalProdutScrollModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.sliderbanner,"ffff00"));
        homePageModelList.add(new HomePageModel(3,"Deals of the Day!",horizontalProdutScrollModelList));
        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(3,"Deals of the Day!",horizontalProdutScrollModelList));
        homePageModelList.add(new HomePageModel(3,"Deals of the Day!",horizontalProdutScrollModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.sliderbanner,"ffff00"));
        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.sliderbanner,"ffff00"));

        HomePageAdapter adapter = new HomePageAdapter(homePageModelList);
        testing.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        ///////////////////////testing

        return view;
    }

    ////////////////////Banner Slider

    private void pageLooper(){
        if (currentPage == sliderModelList.size()-2){
            currentPage = 2;
            bannerSliderViewPager.setCurrentItem(currentPage,false);
        }
        if (currentPage == 1){
            currentPage = sliderModelList.size()-3;
            bannerSliderViewPager.setCurrentItem(currentPage,false);
        }
    }

    private void startBannerSlideShow(){
        final Handler handler = new Handler();
        final Runnable update = new Runnable() {
            @Override
            public void run() {
                if (currentPage >= sliderModelList.size()){
                    currentPage = 1;
                }
                bannerSliderViewPager.setCurrentItem(currentPage++,true);

            }
        };

        timer= new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        },DELAY_TIME,PERIOD_TIME);

    }

    private void stopBannerSlideShow(){
        timer.cancel();
    }

    ////////////////////Banner Slider

}
