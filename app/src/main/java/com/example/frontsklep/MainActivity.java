package com.example.frontsklep;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProductAdapter adapter;
    private List<Item> productList;
    private EditText editTextSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerViewProducts);
        editTextSearch = findViewById(R.id.editTextSearch);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        productList = new ArrayList<>();
        productList.add(new Item(1, "Pizza Margherita", 32.50, "Gluten, Ser"));
        productList.add(new Item(2, "Burger Wołowy", 28.00, "Gluten, Sezam"));
        productList.add(new Item(3, "Duże Frytki", 12.00, ""));
        productList.add(new Item(4, "Sałatka Cezar", 24.00, "Mleko, Jaja"));
        productList.add(new Item(5, "Coca Cola 0.5l", 8.00, ""));
        productList.add(new Item(6, "Pizza Salami", 36.50, "Gluten, Ser"));

        adapter = new ProductAdapter(productList);
        recyclerView.setAdapter(adapter);

        editTextSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });

        View fabCart = findViewById(R.id.fabCart);
        fabCart.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CartActivity.class);
            startActivity(intent);
        });
    }

    private void filter(String text) {
        List<Item> filteredList = new ArrayList<>();
        for (Item item : productList) {
            if (item.getName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        adapter.filterList(filteredList);
    }
}