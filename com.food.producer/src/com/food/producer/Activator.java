package com.food.producer;

import org.osgi.framework.BundleActivator; 
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
    private ServiceRegistration serviceRegistration;

    @Override
    public void start(BundleContext context) throws Exception {
        FastFoodServiceImpl fastFoodService = new FastFoodServiceImpl();
        serviceRegistration = context.registerService(IFastFoodService.class.getName(), fastFoodService, null);
        System.out.println("Fast Food Producer Started: Menu Available");
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        serviceRegistration.unregister();
        System.out.println("Fast Food Producer Stopped");
    }
}
