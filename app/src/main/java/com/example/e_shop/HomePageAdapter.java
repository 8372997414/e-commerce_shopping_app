package com.example.e_shop;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomePageAdapter extends RecyclerView.Adapter {

    private List<HomePageModel> homePageModelList;
    private RecyclerView.RecycledViewPool recycledViewPool;

    public HomePageAdapter(List<HomePageModel> homePageModelList) {
        this.homePageModelList = homePageModelList;
        recycledViewPool = new RecyclerView.RecycledViewPool();
    }

    @Override
    public int getItemViewType(int position) {
        switch (homePageModelList.get(position).getType()){
            case 0:
                return HomePageModel.BANNER_SLIDER;

            case 1:
                return HomePageModel.STRIP_AD_BANNER;

            case 2:
                return HomePageModel.HORIZONTAL_PRODUCT_VIEW;

            case 3:
                return HomePageModel.GRID_PRODUCT_VIEW;

            default:
                    return -1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        switch (viewType){
            case HomePageModel.BANNER_SLIDER:
                View bannerSliderView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sliding_ad_layout, viewGroup, false);
                return new BannersliderViewholder(bannerSliderView);
            case HomePageModel.STRIP_AD_BANNER:
                View stripAdView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.strip_ad_layout, viewGroup,false);
                return new StripAdBannerViewholder(stripAdView);
            case HomePageModel.HORIZONTAL_PRODUCT_VIEW:
                View horizonalProductView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.horizontal_scroll_layout, viewGroup, false);
                return new HorizontalProductViewholder(horizonalProductView);
            case HomePageModel.GRID_PRODUCT_VIEW:
                View gridProductView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grid_product_layout, viewGroup, false);
                return new GridProductViewHolder(gridProductView);
                default:
                    return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        switch (homePageModelList.get(position).getType()){
            case HomePageModel.BANNER_SLIDER:
                List<SliderModel> sliderModelList = homePageModelList.get(position).getSliderModelList();
                ((BannersliderViewholder)viewHolder).setBannerSliderViewPager(sliderModelList);
                break;
            case HomePageModel.STRIP_AD_BANNER:
                 int resource = homePageModelList.get(position).getResource();
                 String color = homePageModelList.get(position).getBackgroundColor();
                 ((StripAdBannerViewholder)viewHolder).setStripAd(resource,color);
                 break;
            case HomePageModel.HORIZONTAL_PRODUCT_VIEW:
                String horizontalLayoutTitle = homePageModelList.get(position).getTitle();
                List<HorizontalProdutScrollModel> horizontalProdutScrollModelList = homePageModelList.get(position).getHorizontalProdutScrollModelList();
                ((HorizontalProductViewholder)viewHolder).setHorizontalProductLayout(horizontalProdutScrollModelList,horizontalLayoutTitle);
                break;
            case HomePageModel.GRID_PRODUCT_VIEW:
                String gridLayoutTitle = homePageModelList.get(position).getTitle();
                List<HorizontalProdutScrollModel> gridlProdutScrollModelList = homePageModelList.get(position).getHorizontalProdutScrollModelList();
                ((GridProductViewHolder)viewHolder).setGridProductLayout(gridlProdutScrollModelList,gridLayoutTitle);
                break;
                default:
                    return;
        }
    }

    @Override
    public int getItemCount() {
        return homePageModelList.size();
    }

    public class BannersliderViewholder extends RecyclerView.ViewHolder{

        private ViewPager bannerSliderViewPager;
        private int currentPage;
        private Timer timer;
        final private long DELAY_TIME = 3000;
        final private long PERIOD_TIME = 3000;
        private List<SliderModel> arrangedList;

        public BannersliderViewholder(@NonNull View itemView) {
            super(itemView);
            bannerSliderViewPager = itemView.findViewById(R.id.banner_slider_viewPager);
        }
        private void setBannerSliderViewPager(final List<SliderModel> sliderModelList){
            currentPage= 2;
            if (timer != null){
                timer.cancel();
            }
            arrangedList = new ArrayList<>();
            for (int x = 0;x < sliderModelList.size();x++){
                arrangedList.add(x,sliderModelList.get(x));
            }
            arrangedList.add(0,sliderModelList.get(sliderModelList.size() -2));
            arrangedList.add(1,sliderModelList.get(sliderModelList.size() -1));
            arrangedList.add(sliderModelList.get(0));
            arrangedList.add(sliderModelList.get(1));

            SliderAdapter sliderAdapter = new SliderAdapter(arrangedList);
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
                        pageLooper(arrangedList);
                    }
                }
            };
            bannerSliderViewPager.addOnPageChangeListener(onPageChangeListener);

            startBannerSlideShow(arrangedList);

            bannerSliderViewPager.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    pageLooper(arrangedList);
                    stopBannerSlideShow();
                    if (event.getAction() == MotionEvent.ACTION_UP){
                        startBannerSlideShow(arrangedList);
                    }

                    return false;
                }
            });

        }
        private void pageLooper(List<SliderModel> sliderModelList){
            if (currentPage == sliderModelList.size()-2){
                currentPage = 2;
                bannerSliderViewPager.setCurrentItem(currentPage,false);
            }
            if (currentPage == 1){
                currentPage = sliderModelList.size()-3;
                bannerSliderViewPager.setCurrentItem(currentPage,false);
            }
        }
        private void startBannerSlideShow(final List<SliderModel> sliderModelList){
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

    }

    public class StripAdBannerViewholder extends RecyclerView.ViewHolder{

        private ImageView stripAdImage;
        private ConstraintLayout stripAdContainer;

        public StripAdBannerViewholder(@NonNull View itemView) {
            super(itemView);
            stripAdImage = itemView.findViewById(R.id.strip_ad_image);
            stripAdContainer = itemView.findViewById(R.id.strip_ad_container);
        }
        private void setStripAd(int resource,String color){
            stripAdImage.setImageResource(resource);
           // stripAdContainer.setBackgroundColor(Color.parseColor(color));

        }
    }

    public class HorizontalProductViewholder extends RecyclerView.ViewHolder{

        private TextView horizontalLayoutTitle;
        private Button horizontalLayoutViewAllBtn;
        private RecyclerView horizontalRecyclerView;

        public HorizontalProductViewholder(@NonNull View itemView) {
            super(itemView);

            horizontalLayoutTitle = itemView.findViewById(R.id.horizontal_scroll_layout_title);
            horizontalLayoutViewAllBtn = itemView.findViewById(R.id.horizontal_scroll_viewall_button);
            horizontalRecyclerView = itemView.findViewById(R.id.horizontal_scroll_layout_recyclerView);
            horizontalRecyclerView.setRecycledViewPool(recycledViewPool);
        }

        private void setHorizontalProductLayout(List<HorizontalProdutScrollModel>horizontalProdutScrollModelList,String title){

            horizontalLayoutTitle.setText(title);

            if (horizontalProdutScrollModelList.size()>8){
                horizontalLayoutViewAllBtn.setVisibility(View.VISIBLE);
                horizontalLayoutViewAllBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent viewAllIntent = new Intent(itemView.getContext(),ViewAllActivity.class);
                        viewAllIntent.putExtra("layout_code",0);
                        itemView.getContext().startActivity(viewAllIntent);
                    }
                });
            }else {
                horizontalLayoutViewAllBtn.setVisibility(View.INVISIBLE);
            }

            HorizontalProductScrollAdapter horizontalProductScrollAdapter = new HorizontalProductScrollAdapter(horizontalProdutScrollModelList);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(itemView.getContext());
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            horizontalRecyclerView.setLayoutManager(linearLayoutManager);
            horizontalRecyclerView.setAdapter(horizontalProductScrollAdapter);
            horizontalProductScrollAdapter.notifyDataSetChanged();
        }
    }

    public class GridProductViewHolder extends RecyclerView.ViewHolder{

        private TextView gridLayoutTitle;
        private Button gridLayoutViewAllBtn;
        private GridLayout gridProductLayout;

        public GridProductViewHolder(@NonNull View itemView) {
            super(itemView);
            gridLayoutTitle = itemView.findViewById(R.id.grid_product_layout_title);
            gridLayoutViewAllBtn = itemView.findViewById(R.id.grid_product_layout_viewall_btn);
            gridProductLayout = itemView.findViewById(R.id.grid_layout);

        }
        private void setGridProductLayout(List<HorizontalProdutScrollModel> horizontalProdutScrollModelList,String title){
            gridLayoutTitle.setText(title);

            for (int x = 0; x < 4;x++){
                ImageView productImage = gridProductLayout.getChildAt(x).findViewById(R.id.h_s_product_image);
                TextView productTitle = gridProductLayout.getChildAt(x).findViewById(R.id.h_s_product_title);
                TextView productDescription = gridProductLayout.getChildAt(x).findViewById(R.id.h_s_product_description);
                TextView productPrice = gridProductLayout.getChildAt(x).findViewById(R.id.h_s_product_price);

                productImage.setImageResource(horizontalProdutScrollModelList.get(x).getProductImage());
                productTitle.setText(horizontalProdutScrollModelList.get(x).getProductTitle());
                productDescription.setText(horizontalProdutScrollModelList.get(x).getProductDescription());
                productPrice.setText(horizontalProdutScrollModelList.get(x).getProductPrice());
                gridProductLayout.getChildAt(x).setBackgroundColor(Color.parseColor("#ffffff"));
                gridProductLayout.getChildAt(x).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent productDetailsIntent = new Intent(itemView.getContext(),ProductDetailsActivity.class);
                        itemView.getContext().startActivity(productDetailsIntent);
                    }
                });


            }


            gridLayoutViewAllBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent viewAllIntent = new Intent(itemView.getContext(),ViewAllActivity.class);
                    viewAllIntent.putExtra("layout_code",1);
                    itemView.getContext().startActivity(viewAllIntent);

                }
            });
        }
    }
}
