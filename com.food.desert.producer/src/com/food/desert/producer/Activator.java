package com.food.desert.producer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
	ServiceRegistration serviceRegistration;

	@Override
	public void start(BundleContext context) throws Exception {
		DessertShopServiceImpl dessertService = new DessertShopServiceImpl();
		serviceRegistration = context.registerService(DessertShopService.class.getName(), dessertService, null);
		System.out.println("Dessert Shop Service Started.");
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		serviceRegistration.unregister();
        System.out.println("Dessert Shop Service Stopped.");
	}

}
