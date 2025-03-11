package com.food.consumer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class Activator implements BundleActivator {

    private static BundleContext context;

    static BundleContext getContext() {
        return context;
    }

    public void start(BundleContext bundleContext) throws Exception {
        Activator.context = bundleContext;
        // Start the CustomerConsumer when the bundle starts
        CustomerConsumer consumer = new CustomerConsumer();
        consumer.start(bundleContext); // Call start method to run consumer logic
    }

    public void stop(BundleContext bundleContext) throws Exception {
        Activator.context = null;
    }
}
