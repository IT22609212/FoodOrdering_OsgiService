package com.food.desert.consumer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import com.food.desert.producer.DessertShopService;
import java.util.List;

public class DessertShopConsumer implements BundleActivator {
    private ServiceReference<DessertShopService> serviceReference;

    @Override
    public void start(BundleContext context) throws Exception {
        serviceReference = context.getServiceReference(DessertShopService.class);
        if (serviceReference != null) {
            DessertShopService dessertService = context.getService(serviceReference);
            if (dessertService != null) {
                List<String> desserts = dessertService.getDesserts();
                System.out.println("Available Desserts: " + desserts);
                
                // Add a new flavor
                dessertService.addFlavor("Mango Sorbet");

                // Remove a flavor
                dessertService.removeFlavor("Vanilla Ice Cream");

                // Display updated menu
                System.out.println("Updated Desserts: " + dessertService.getDesserts());
            } else {
                System.out.println("DessertService is not available.");
            }
        } else {
            System.out.println("Service Reference not found.");
        }
    }


    @Override
    public void stop(BundleContext context) throws Exception {
        context.ungetService(serviceReference);
        System.out.println("Dessert Shop Consumer Stopped.");
    }
}
