package com.games24x7.paymentservice;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.games24x7.paymentservice.di.module.ConfigModule;
import com.games24x7.paymentservice.di.module.DBModule;
import com.games24x7.paymentservice.health.DatabaseHealthCheck;
import com.games24x7.paymentservice.resource.UserResource;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * This is application's entry point class
 * 
 * @author nawal
 *
 */
public class Entry extends Application<EntryConfiguration> {

    private final Logger logger = LoggerFactory.getLogger(Entry.class);

    public static void main(String[] args) throws Exception {
        new Entry().run(args);
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see io.dropwizard.Application#run(io.dropwizard.Configuration,
     * io.dropwizard.setup.Environment)
     */
    @Override
    public void run(EntryConfiguration configuration, Environment environment) throws Exception {
        logger.info("Method App#run() called");

        logger.info("Initializing Guice Modules");
        Injector injector = Guice.createInjector(new ConfigModule(configuration, environment), new DBModule());

        environment.healthChecks().register("mysqldb", injector.getInstance(DatabaseHealthCheck.class));
        
        registerResources(injector, environment);
    }
    
    private void registerResources(Injector injector, Environment environment) {
        environment.jersey().register(injector.getInstance(UserResource.class));
    }
    

}
