package com.food.producer;

import java.util.List;

public interface IFastFoodService {
    List<String> getMenu(); // Returns available menu items
    void addFoodItem(String item); // Adds a new item to the menu
}
