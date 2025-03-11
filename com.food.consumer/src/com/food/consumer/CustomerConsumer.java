package com.food.consumer;

import com.food.producer.IFastFoodService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import java.util.List;
import java.util.Scanner;

public class CustomerConsumer implements BundleActivator {
    private ServiceReference serviceReference;

    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("Customer Consumer Started: Looking for Fast Food Service...");

        // Ensure we are finding the service from the OSGi registry
        serviceReference = context.getServiceReference(IFastFoodService.class.getName());

        if (serviceReference != null) {
            IFastFoodService fastFoodService = (IFastFoodService) context.getService(serviceReference);
            List<String> menu = fastFoodService.getMenu();
            
            System.out.println("Menu Available:");
            for (String item : menu) {
                System.out.println("- " + item);
            }

            Scanner scanner = new Scanner(System.in);
            System.out.println("\nEnter a food item to order:");
            String order = scanner.nextLine();

            if (menu.contains(order)) {
                System.out.println("Order placed: " + order);
            } else {
                System.out.println("Item not available.");
            }

            scanner.close();
        } else {
            System.out.println("Fast Food Service not available.");
        }
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        context.ungetService(serviceReference);
        System.out.println("Customer Consumer Stopped.");
    }
}
