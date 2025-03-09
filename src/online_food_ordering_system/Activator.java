package online_food_ordering_system;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import com.foodorder.order.OrderService;
import org.osgi.framework.ServiceReference;


public class Activator implements BundleActivator {
	private ServiceRegistration<?> serviceRegistration;
	private OrderService orderService;
	 
	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		 RestaurantService restaurantService = new RestaurantServiceImpl();
	        serviceRegistration = context.registerService(RestaurantService.class.getName(), restaurantService, null);
	        System.out.println("Restaurant Service Started!");
	        
	        
	        // Get OrderService from OSGi registry
	        ServiceReference<?> serviceReference = context.getServiceReference(OrderService.class.getName());
	        if (serviceReference != null) {
	            orderService = (OrderService) context.getService(serviceReference);
	            System.out.println("Fetched Order Details: " + orderService.getOrderDetails(101));
	        } else {
	            System.out.println("Order Service not found!");
	        }
	}

	public void stop(BundleContext bundleContext) throws Exception {
		 serviceRegistration.unregister();
	        System.out.println("Restaurant Service Stopped!");
	}

}
