package com.example.e_shop;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import static com.example.e_shop.DBqueries.categoryModelList;
import static com.example.e_shop.DBqueries.lists;
import static com.example.e_shop.DBqueries.loadCategories;
import static com.example.e_shop.DBqueries.loadFragmentData;
import static com.example.e_shop.DBqueries.loadedCategoriesNames;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }

    private ConnectivityManager connectivityManager;
    private NetworkInfo networkInfo;
    public static SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView categoryRecyclerView;
    private List<CategoryModel> categoryModelFekeList = new ArrayList<>();
    private CategoryAdapter categoryAdapter;
    private RecyclerView homePageRecyclerView;
    private List<HomePageModel> homePageModelFakeList = new ArrayList<>();
    private HomePageAdapter adapter;
    private ImageView noInternetConnection;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        swipeRefreshLayout = view.findViewById(R.id.refresh_layout);
        noInternetConnection = view.findViewById(R.id.no_internet_connection);
        categoryRecyclerView = view.findViewById(R.id.category_recyclerview);
        homePageRecyclerView = view.findViewById(R.id.home_page_recyclerview);

        swipeRefreshLayout.setColorSchemeColors(getContext().getResources().getColor(R.color.btnRed),getContext().getResources().getColor(R.color.btnRed),getContext().getResources().getColor(R.color.btnRed));

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        categoryRecyclerView.setLayoutManager(layoutManager);

        LinearLayoutManager testingLayoutManager = new LinearLayoutManager(getContext());
        testingLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        homePageRecyclerView.setLayoutManager(testingLayoutManager);

        ///categories fake list
        categoryModelFekeList.add(new CategoryModel("null",""));
        categoryModelFekeList.add(new CategoryModel("",""));
        categoryModelFekeList.add(new CategoryModel("",""));
        categoryModelFekeList.add(new CategoryModel("",""));
        categoryModelFekeList.add(new CategoryModel("",""));
        categoryModelFekeList.add(new CategoryModel("",""));
        categoryModelFekeList.add(new CategoryModel("",""));
        categoryModelFekeList.add(new CategoryModel("",""));
        categoryModelFekeList.add(new CategoryModel("",""));
        categoryModelFekeList.add(new CategoryModel("",""));
        ///categories fake list

        ///home page fake list
        List<SliderModel> sliderModelFakeList = new ArrayList<>();
        sliderModelFakeList.add(new SliderModel("null","#dfdfdf"));
        sliderModelFakeList.add(new SliderModel("null","#dfdfdf"));
        sliderModelFakeList.add(new SliderModel("null","#dfdfdf"));
        sliderModelFakeList.add(new SliderModel("null","#dfdfdf"));
        sliderModelFakeList.add(new SliderModel("null","#dfdfdf"));

        List<HorizontalProdutScrollModel> horizontalProdutScrollModelFakeList = new ArrayList<>();
        horizontalProdutScrollModelFakeList.add(new HorizontalProdutScrollModel("","","","",""));
        horizontalProdutScrollModelFakeList.add(new HorizontalProdutScrollModel("","","","",""));
        horizontalProdutScrollModelFakeList.add(new HorizontalProdutScrollModel("","","","",""));
        horizontalProdutScrollModelFakeList.add(new HorizontalProdutScrollModel("","","","",""));
        horizontalProdutScrollModelFakeList.add(new HorizontalProdutScrollModel("","","","",""));
        horizontalProdutScrollModelFakeList.add(new HorizontalProdutScrollModel("","","","",""));
        horizontalProdutScrollModelFakeList.add(new HorizontalProdutScrollModel("","","","",""));

        homePageModelFakeList.add(new HomePageModel(0,sliderModelFakeList));
        homePageModelFakeList.add(new HomePageModel(1,"","#dfdfdf"));
        homePageModelFakeList.add(new HomePageModel(2,"","#dfdfdf",horizontalProdutScrollModelFakeList,new ArrayList<WishlistModel>()));
        homePageModelFakeList.add(new HomePageModel(3,"","#dfdfdf",horizontalProdutScrollModelFakeList));

        ///home page fake list

        categoryAdapter = new CategoryAdapter(categoryModelFekeList);

        adapter = new HomePageAdapter(homePageModelFakeList);

        connectivityManager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null &&networkInfo.isConnected() == true) {
            noInternetConnection.setVisibility(View.GONE);

            if (categoryModelList.size() == 0) {
                loadCategories(categoryRecyclerView, getContext());
            } else {
                categoryAdapter = new CategoryAdapter(categoryModelList);
                categoryAdapter.notifyDataSetChanged();
            }
            categoryRecyclerView.setAdapter(categoryAdapter);
            if (lists.size() == 0) {
                loadedCategoriesNames.add("HOME");
                lists.add(new ArrayList<HomePageModel>());
                loadFragmentData(homePageRecyclerView, getContext(),0,"Home");
            } else {
                adapter = new HomePageAdapter(lists.get(0));
                adapter.notifyDataSetChanged();
            }
            homePageRecyclerView.setAdapter(adapter);
        }else {
            Glide.with(this).load(R.drawable.no_internet_connection).into(noInternetConnection);
            noInternetConnection.setVisibility(View.VISIBLE);
        }
        //// refresh layout

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(true);

                categoryModelList.clear();
                lists.clear();
                loadedCategoriesNames.clear();
                if (networkInfo != null &&networkInfo.isConnected() == true) {
                    noInternetConnection.setVisibility(View.GONE);
                    categoryAdapter = new CategoryAdapter(categoryModelFekeList);
                    adapter = new HomePageAdapter(homePageModelFakeList);
                    categoryRecyclerView.setAdapter(categoryAdapter);
                    homePageRecyclerView.setAdapter(adapter);

                    loadCategories(categoryRecyclerView, getContext());

                    loadedCategoriesNames.add("HOME");
                    lists.add(new ArrayList<HomePageModel>());
                    loadFragmentData(homePageRecyclerView, getContext(),0,"Home");
                }else {
                    Glide.with(getContext()).load(R.drawable.no_internet_connection).into(noInternetConnection);
                    noInternetConnection.setVisibility(View.VISIBLE);
                }
            }
        });
        //// refresh layout

        return view;
    }
}
