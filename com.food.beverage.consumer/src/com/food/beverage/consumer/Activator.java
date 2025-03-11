package com.food.beverage.consumer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {
    private static BundleContext context;

    static BundleContext getContext() {
        return context;
    }

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        System.out.println("Beverage Consumer Started: Looking for Beverage Service...");
        Activator.context = bundleContext;
        BeverageConsumer consumer = new BeverageConsumer();
        consumer.start(bundleContext);
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        System.out.println("Beverage Consumer Stopped.");
        Activator.context = null;
    }
}
