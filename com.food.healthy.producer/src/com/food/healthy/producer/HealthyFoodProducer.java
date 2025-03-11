package com.food.healthy.producer;

import java.util.List;
import java.util.ArrayList;

public class HealthyFoodProducer implements IHealthyFoodService {
	
	private List<String> menu;
	
	public HealthyFoodProducer() {
        menu = new ArrayList<>();
        menu.add("Grilled Chicken");
        menu.add("Salad");
        menu.add("Smoothie");
    }

	@Override
	public List<String> getMenu() {
		// TODO Auto-generated method stub
		return menu;
	}

	@Override
	public void updateMenu(String item) {
		menu.add(item);
        System.out.println(item + " added to the menu.");
	}

	@Override
	public void removeMenuItem(String item) {
		 menu.remove(item);
	        System.out.println(item + " removed from the menu.");

	}

}
