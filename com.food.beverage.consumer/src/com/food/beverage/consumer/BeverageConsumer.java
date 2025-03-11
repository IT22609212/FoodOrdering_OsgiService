package com.food.beverage.consumer;

import com.food.beverage.producer.BeverageService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import java.util.List;
import java.util.Scanner;

public class BeverageConsumer implements BundleActivator {
    private ServiceReference serviceReference;

    @Override
    public void start(BundleContext context) throws Exception {
        serviceReference = context.getServiceReference(BeverageService.class.getName());
        if (serviceReference != null) {
            BeverageService beverageService = (BeverageService) context.getService(serviceReference);
            List<String> beverages = beverageService.getBeverages();
            System.out.println("Available Beverages:");
            for (String item : beverages) {
                System.out.println("- " + item);
            }

            Scanner scanner = new Scanner(System.in);
            System.out.println("\nEnter a beverage to order:");
            String order = scanner.nextLine();

            if (beverages.contains(order)) {
                System.out.println("Beverage order placed: " + order);
            } else {
                System.out.println("Beverage not available.");
            }
            //scanner.close();
        } else {
            System.out.println("Beverage Service not available.");
        }
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        context.ungetService(serviceReference);
    }
}
