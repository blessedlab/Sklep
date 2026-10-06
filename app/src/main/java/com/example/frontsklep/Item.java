package com.example.frontsklep;

public class Item {
    private int itemId;
    private String name;
    private double price;
    private String allergens;

    public Item(int itemId, String name, double price, String allergens) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
        this.allergens = allergens;
    }

    public int getItemId() { return itemId; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getAllergens() { return allergens; }
}