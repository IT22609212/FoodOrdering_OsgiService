package online_food_ordering_system;

import java.util.HashMap;
import java.util.Map;

public class RestaurantServiceImpl implements RestaurantService {
	private Map<String, String[]> restaurantMenu = new HashMap<>();
	@Override
	public void registerRestaurant(String name, String[] menu) {
		restaurantMenu.put(name, menu);
        System.out.println("Restaurant " + name + " registered successfully!");
	}

	@Override
	public String getMenu(String restaurantName) {
		if (restaurantMenu.containsKey(restaurantName)) {
            return String.join(", ", restaurantMenu.get(restaurantName));
        } else {
            return "Restaurant not found.";
        }
	}

}
