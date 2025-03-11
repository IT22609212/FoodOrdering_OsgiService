package com.food.healthy.producer;
import java.util.List;

public interface IHealthyFoodService {
	List<String> getMenu(); // Get the list of available healthy meals
    void updateMenu(String item); // Add a new item to the menu
    void removeMenuItem(String item); // Remove an item from the menu
}
