package com.food.producer;

import java.util.ArrayList;
import java.util.List;

public class FastFoodServiceImpl implements IFastFoodService {
    private List<String> menu;

    public FastFoodServiceImpl() {
        menu = new ArrayList<>();
        menu.add("Burger");
        menu.add("Pizza");
        menu.add("French Fries");
    }

    @Override
    public List<String> getMenu() {
        return menu;
    }

    @Override
    public void addFoodItem(String item) {
        menu.add(item);
        System.out.println("New item added to menu: " + item);
    }
}
