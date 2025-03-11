package com.food.beverage.producer;

import java.util.ArrayList;
import java.util.List;

public class BeverageServiceImpl implements BeverageService {
    private List<String> beverages;

    public BeverageServiceImpl() {
        beverages = new ArrayList<>();
        beverages.add("Soda");
        beverages.add("Juice");
        beverages.add("Coffee");
    }

    @Override
    public List<String> getBeverages() {
        return new ArrayList<>(beverages);
    }

    @Override
    public void addBeverage(String beverage) {
        if (!beverages.contains(beverage)) {
            beverages.add(beverage);
            System.out.println(beverage + " added to the beverage menu.");
        }
    }

    @Override
    public void removeBeverage(String beverage) {
        if (beverages.contains(beverage)) {
            beverages.remove(beverage);
            System.out.println(beverage + " removed from the beverage menu.");
        }
    }
}
