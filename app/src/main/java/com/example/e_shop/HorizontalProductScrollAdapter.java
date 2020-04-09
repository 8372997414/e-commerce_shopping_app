package com.example.e_shop;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
        int resource = horizontalProdutScrollModelList.get(position).getProductImage();
        String title = horizontalProdutScrollModelList.get(position).getProductTitle();
        String description = horizontalProdutScrollModelList.get(position).getProductDescription();
        String price = horizontalProdutScrollModelList.get(position).getProductPrice();

        viewHolder.setProductImage(resource);
        viewHolder.setProductTitle(title);
        viewHolder.setProductDescription(description);
        viewHolder.setProductPrice(price);
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

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.h_s_product_image);
            productTitle = itemView.findViewById(R.id.h_s_product_title);
            productDescription = itemView.findViewById(R.id.h_s_product_description);
            productPrice = itemView.findViewById(R.id.h_s_product_price);
        }

        private void setProductImage(int resource){
            productImage.setImageResource(resource);
        }
        private void setProductTitle(String title){
            productTitle.setText(title);
        }
        private void setProductDescription(String description){
            productDescription.setText(description);
        }
        private void setProductPrice(String price){
            productPrice.setText(price);
        }
    }
}
