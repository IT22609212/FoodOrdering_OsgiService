package com.food.healthy.consumer;

import org.osgi.framework.BundleActivator;  
import org.osgi.framework.BundleContext;



public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Healthy Food Consumer started.");
		Activator.context = bundleContext;
		HealthyFoodConsumer consumer = new HealthyFoodConsumer();
		consumer.start(bundleContext);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Healthy Food Consumer stopped.");
		Activator.context = null;
	}

}



//Activator.context = bundleContext;
//// Start the CustomerConsumer when the bundle starts
//CustomerConsumer consumer = new CustomerConsumer();
//consumer.start(bundleContext); // Call start method to run consumer logic