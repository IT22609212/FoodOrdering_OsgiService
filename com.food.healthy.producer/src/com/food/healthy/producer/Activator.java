package com.food.healthy.producer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.ServiceRegistration;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    private ServiceRegistration registration;

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        HealthyFoodProducer producer = new HealthyFoodProducer();
        
        // Corrected: Use bundleContext instead of uninitialized context
        registration = bundleContext.registerService(IHealthyFoodService.class.getName(), producer, null);
        
        System.out.println("Healthy Food Producer Started: Menu Available");
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        if (registration != null) {
            registration.unregister();
        }
        System.out.println("Healthy Food Producer Stopped");
    }
}
