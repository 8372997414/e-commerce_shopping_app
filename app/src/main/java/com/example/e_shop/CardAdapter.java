package com.example.e_shop;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter {

    private List<CardItemModel> cardItemModelList;

    public CardAdapter(List<CardItemModel> cardItemModelList) {
        this.cardItemModelList = cardItemModelList;
    }

    @Override
    public int getItemViewType(int position) {

        switch (cardItemModelList.get(position).getType()){
            case 0:
                return CardItemModel.CART_ITEM;
            case 1:
                return CardItemModel.TOTAL_AMOUNT;
            default:
                return -1;
        }

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
       switch (viewType){
           case CardItemModel.CART_ITEM:
               View cartItemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cart_item_layout, viewGroup, false);
               return new CardItemViewholder(cartItemView);
           case CardItemModel.TOTAL_AMOUNT:
               View cartTotalView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_total_amount_layout, viewGroup, false);
               return new CardTotalAmountViewholder(cartTotalView);
           default:
               return null;
       }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        switch (cardItemModelList.get(position).getType()){
            case CardItemModel.CART_ITEM:
                int resource = cardItemModelList.get(position).getProductImage();
                String title = cardItemModelList.get(position).getProductTitle();
                int freeCoupens = cardItemModelList.get(position).getFreeCoupens();
                String productPrice = cardItemModelList.get(position).getProductPrice();
                String cuttedPrice = cardItemModelList.get(position).getCuttedPrice();
                int offersApplied = cardItemModelList.get(position).getOfferApplied();

                ((CardItemViewholder)viewHolder).setItemDetails(resource,title,freeCoupens,productPrice,cuttedPrice,offersApplied);
                break;
            case  CardItemModel.TOTAL_AMOUNT:
                String totalItems = cardItemModelList.get(position).getTotalItems();
                String totalItemPrice = cardItemModelList.get(position).getTotalItemPrice();
                String deliveryPrice = cardItemModelList.get(position).getDeliveryPrice();
                String totalAmount = cardItemModelList.get(position).getTotalAmount();
                String savedAmount = cardItemModelList.get(position).getSavedAmount();

                ((CardTotalAmountViewholder)viewHolder).setTotalAmount(totalItems,totalItemPrice,deliveryPrice,totalAmount,savedAmount);
                break;
            default:
                return;
        }

    }

    @Override
    public int getItemCount() {
        return cardItemModelList.size();
    }

    class CardItemViewholder extends RecyclerView.ViewHolder{

        private ImageView productImage;
        private TextView freeCoupenIcon;
        private TextView productTitle;
        private TextView freeCoupens;
        private TextView productPrice;
        private TextView cuttedPrice;
        private TextView offersApplied;
        private TextView coupensApplied;
        private TextView productQuantity;

        public CardItemViewholder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.product_image);
            productTitle = itemView.findViewById(R.id.product_title);
            freeCoupenIcon = itemView.findViewById(R.id.free_coupen_icon);
            freeCoupens = itemView.findViewById(R.id.tv_free_coupen);
            productPrice = itemView.findViewById(R.id.product_price);
            cuttedPrice = itemView.findViewById(R.id.cutted_price);
            offersApplied = itemView.findViewById(R.id.offers_applied);
            coupensApplied = itemView.findViewById(R.id.coupens_applied);
            productQuantity = itemView.findViewById(R.id.product_quntity);
        }
        private void setItemDetails(int resource,String title,int freeCoupensNo, String productPriceText, String cuttedPriceText, int offersAppliedNo){
            productImage.setImageResource(resource);
            productTitle.setText(title);
            if (freeCoupensNo > 0) {
                freeCoupenIcon.setVisibility(View.VISIBLE);
                freeCoupens.setVisibility(View.VISIBLE);
                if (freeCoupensNo == 1) {
                    freeCoupens.setText("free " + freeCoupensNo + " coupen");
                } else {
                    freeCoupens.setText("free " + freeCoupensNo + " coupens");
                }
            }else {
                freeCoupenIcon.setVisibility(View.INVISIBLE);
                freeCoupens.setVisibility(View.INVISIBLE);
            }
            productPrice.setText(productPriceText);
            cuttedPrice.setText(cuttedPriceText);
            if (offersAppliedNo > 0){
                offersApplied.setVisibility(View.VISIBLE);
                offersApplied.setText(offersAppliedNo + " Offers applied");
            }else {
                offersApplied.setVisibility(View.VISIBLE);
            }
        }
    }

    class CardTotalAmountViewholder extends RecyclerView.ViewHolder{

        private TextView totalTtems;
        private TextView totalTtemsPrice;
        private TextView deliveryPrice;
        private TextView totalAmount;
        private TextView savedAmount;

        public CardTotalAmountViewholder(@NonNull View itemView) {
            super(itemView);

            totalTtems = itemView.findViewById(R.id.total_items);
            totalTtemsPrice = itemView.findViewById(R.id.total_item_price);
            deliveryPrice = itemView.findViewById(R.id.delivery_price);
            totalAmount = itemView.findViewById(R.id.total_price);
            savedAmount = itemView.findViewById(R.id.saved_amount);
        }
        private void setTotalAmount(String totalItemsText, String totalItemPriceText,String deliveryPriceText,String totalAmountText,String savedAmountText){
            totalTtems.setText(totalItemsText);
            totalTtemsPrice.setText(totalItemPriceText);
            deliveryPrice.setText(deliveryPriceText);
            totalAmount.setText(totalAmountText);
            savedAmount.setText(savedAmountText);
        }
    }
}
