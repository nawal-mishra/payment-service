package com.games24x7.paymentservice.di.module;

import io.dropwizard.setup.Environment;

import javax.ws.rs.client.Client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.games24x7.paymentservice.EntryConfiguration;
import com.games24x7.paymentservice.di.provider.JerseyClientProvider;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

/**
 * 
 * @author nawal
 *
 */
public class ConfigModule extends AbstractModule {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigModule.class);
    private final EntryConfiguration config;
    private final Environment environment;

    public ConfigModule(EntryConfiguration config, Environment environment) {
        this.config = config;
        this.environment = environment;
    }

    @Override
    protected void configure() {
        LOGGER.info("Initializing Config Module");
        bind(EntryConfiguration.class).toInstance(config);
        bind(Environment.class).toInstance(environment);
        bind(Client.class).toProvider(JerseyClientProvider.class).in(Singleton.class);
    }

    @Provides
    @Named("env")
    public String providesEnv(EntryConfiguration config) {
        return config.getEnv();
    }

}
