package com.food.desert.producer;

import java.util.List;

public interface DessertShopService {
	List<String> getDesserts();
    void addFlavor(String flavor);
    void removeFlavor(String flavor);
}
