package com.example.e_shop;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class HorizontalProductScrollAdapter extends RecyclerView.Adapter<HorizontalProductScrollAdapter.ViewHolder> {

    private List<HorizontalProdutScrollModel> horizontalProdutScrollModelList;

    public HorizontalProductScrollAdapter(List<HorizontalProdutScrollModel> horizontalProdutScrollModelList) {
        this.horizontalProdutScrollModelList = horizontalProdutScrollModelList;
    }

    @NonNull
    @Override
    public HorizontalProductScrollAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.horizontal_scroll_item_layout, viewGroup, false);
       return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalProductScrollAdapter.ViewHolder viewHolder, int position) {
        String resource = horizontalProdutScrollModelList.get(position).getProductImage();
        String title = horizontalProdutScrollModelList.get(position).getProductTitle();
        String description = horizontalProdutScrollModelList.get(position).getProductDescription();
        String price = horizontalProdutScrollModelList.get(position).getProductPrice();

        viewHolder.setData(title,resource,description,price);
    }
    @Override
    public int getItemCount() {
        if (horizontalProdutScrollModelList.size()>8){
            return 8;
        }else {
            return horizontalProdutScrollModelList.size();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView productImage;
        private TextView productTitle;
        private TextView productDescription;
        private TextView productPrice;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.h_s_product_image);
            productTitle = itemView.findViewById(R.id.h_s_product_title);
            productDescription = itemView.findViewById(R.id.h_s_product_description);
            productPrice = itemView.findViewById(R.id.h_s_product_price);
        }

        private void setData(String resource,String title,String description,String price){
            Glide.with(itemView.getContext()).load(resource).apply(new RequestOptions().placeholder(R.drawable.placeholder_icon_1)).into(productImage);
            productTitle.setText(title);
            productDescription.setText(description);
            productPrice.setText("Rs."+price+"/-");

            if (!title.equals("")) {
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent productDetailsIntent = new Intent(itemView.getContext(), ProductDetailsActivity.class);
                        itemView.getContext().startActivity(productDetailsIntent);
                    }
                });
            }
        }
    }
}
