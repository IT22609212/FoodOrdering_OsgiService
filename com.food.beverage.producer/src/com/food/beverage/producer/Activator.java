package com.food.beverage.producer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
    private ServiceRegistration registration;

    @Override
    public void start(BundleContext context) throws Exception {
        BeverageServiceImpl beverageService = new BeverageServiceImpl();
        registration = context.registerService(BeverageService.class.getName(), beverageService, null);
        System.out.println("Beverage Producer Started: Menu Available");
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        registration.unregister();
        System.out.println("Beverage Producer Stopped");
    }
}
