package com.example.e_shop;

import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class GridProductLayoutAdapter extends BaseAdapter {

   List<HorizontalProdutScrollModel> horizontalProdutScrollModelList;

   public GridProductLayoutAdapter(List<HorizontalProdutScrollModel> horizontalProdutScrollModelList){
       this.horizontalProdutScrollModelList = horizontalProdutScrollModelList;
   }


    @Override
    public int getCount() {
        return horizontalProdutScrollModelList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        View view;
        if (convertView ==  null){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_scroll_item_layout,null);
            view.setElevation(0);
            view.setBackgroundColor(Color.parseColor("#ffffff"));

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent productDetailsIntent = new Intent(parent.getContext(),ProductDetailsActivity.class);
                    productDetailsIntent.putExtra("PRODUCT_ID",horizontalProdutScrollModelList.get(position).getProductID());
                    parent.getContext().startActivity(productDetailsIntent);
                }
            });

            ImageView productImage = view.findViewById(R.id.h_s_product_image);
            TextView productTitle = view.findViewById(R.id.h_s_product_title);
            TextView productDescription = view.findViewById(R.id.h_s_product_description);
            TextView productPrice = view.findViewById(R.id.h_s_product_price);

            Glide.with(parent.getContext()).load(horizontalProdutScrollModelList.get(position).getProductImage()).apply(new RequestOptions().placeholder(R.drawable.placeholder_icon_1)).into(productImage);
            productTitle.setText(horizontalProdutScrollModelList.get(position).getProductTitle());
            productDescription.setText(horizontalProdutScrollModelList.get(position).getProductDescription());
            productPrice.setText("Rs."+horizontalProdutScrollModelList.get(position).getProductPrice()+"/-");
        }else{
            view = convertView;
        }
        return view;
    }
}
