package online_food_ordering_system;

public interface RestaurantService {
	 void registerRestaurant(String name, String[] menu);
	    String getMenu(String restaurantName);

}
