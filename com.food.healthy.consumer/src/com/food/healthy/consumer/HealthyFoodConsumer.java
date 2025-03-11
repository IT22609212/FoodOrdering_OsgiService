package com.food.healthy.consumer;
import com.food.healthy.producer.IHealthyFoodService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import java.util.List;
import java.util.Scanner;

public class HealthyFoodConsumer implements BundleActivator {
    private ServiceReference serviceReference;

    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("Healthy Food Consumer Started: Looking for Healthy Food Service...");

        serviceReference = context.getServiceReference(IHealthyFoodService.class.getName());

        if (serviceReference != null) {
            IHealthyFoodService healthyFoodService = (IHealthyFoodService) context.getService(serviceReference);
            List<String> menu = healthyFoodService.getMenu();
            
            System.out.println("Menu Available:");
            for (String item : menu) {
                System.out.println("- " + item);
            }

            Scanner scanner = new Scanner(System.in);
            System.out.println("\nEnter a healthy food item to order:");
            String order = scanner.nextLine();

            if (menu.contains(order)) {
                System.out.println("Order placed: " + order);
            } else {
                System.out.println("Item not available.");
            }

            scanner.close();
        } else {
            System.out.println("Healthy Food Service not available.");
        }
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        context.ungetService(serviceReference);
        System.out.println("Healthy Food Consumer Stopped.");
    }
}
