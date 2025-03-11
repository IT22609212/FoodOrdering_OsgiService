package com.food.desert.producer;

import java.util.ArrayList;
import java.util.List;

public class DessertShopServiceImpl implements DessertShopService {
    private List<String> desserts;

    public DessertShopServiceImpl() {
        desserts = new ArrayList<>();
        desserts.add("Chocolate Cake");
        desserts.add("Vanilla Ice Cream");
        desserts.add("Strawberry Pastry");
    }

    @Override
    public List<String> getDesserts() {
        return new ArrayList<>(desserts);
    }

    @Override
    public void addFlavor(String flavor) {
        if (!desserts.contains(flavor)) {
            desserts.add(flavor);
            System.out.println(flavor + " added to the menu.");
        }
    }

    @Override
    public void removeFlavor(String flavor) {
        if (desserts.contains(flavor)) {
            desserts.remove(flavor);
            System.out.println(flavor + " removed from the menu.");
        }
    }
}

