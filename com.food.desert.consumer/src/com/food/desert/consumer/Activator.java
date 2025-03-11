package com.food.desert.consumer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.food.desert.consumer.DessertShopConsumer;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Starting Dessert Shop Consumer...");
		Activator.context = bundleContext;
		DessertShopConsumer consumer = new DessertShopConsumer();
        consumer.start(bundleContext);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Stopping Dessert Shop Consumer...");
		Activator.context = null;
	}

}
