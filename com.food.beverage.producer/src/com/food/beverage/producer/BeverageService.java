package com.food.beverage.producer;

import java.util.List;

public interface BeverageService {
    List<String> getBeverages();      
    void addBeverage(String beverage); 
    void removeBeverage(String beverage);
}
