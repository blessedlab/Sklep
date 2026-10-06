package com.example.frontsklep;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private List<Item> productList;

    public ProductAdapter(List<Item> productList) {
        this.productList = productList;
    }

    public void filterList(List<Item> filteredList) {
        this.productList = filteredList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Item item = productList.get(position);

        holder.textName.setText(item.getName());
        holder.textPrice.setText(String.format("%.2f zł", item.getPrice()));

        if (item.getAllergens() != null && !item.getAllergens().isEmpty()) {
            holder.textAllergens.setText("Alergeny: " + item.getAllergens());
        } else {
            holder.textAllergens.setText("Alergeny: brak");
        }

        holder.btnAddToCart.setOnClickListener(v -> {
            Toast.makeText(v.getContext(), "Dodano " + item.getName() + " do koszyka", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    static class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView textName, textPrice, textAllergens;
        View btnAddToCart;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.textProductName);
            textPrice = itemView.findViewById(R.id.textProductPrice);
            textAllergens = itemView.findViewById(R.id.textAllergens);
            btnAddToCart = itemView.findViewById(R.id.buttonAddToCart);
        }
    }
}