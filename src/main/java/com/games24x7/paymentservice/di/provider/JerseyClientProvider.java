package com.games24x7.paymentservice.di.provider;

import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.setup.Environment;

import javax.ws.rs.client.Client;

import com.games24x7.paymentservice.EntryConfiguration;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author nawal
 *
 */
public class JerseyClientProvider implements Provider<Client> {
    Environment env;
    EntryConfiguration config;

    @Inject
    public JerseyClientProvider(Environment env, EntryConfiguration config) {
        this.env = env;
        this.config = config;
    }

    @Override
    public Client get() {
        return new JerseyClientBuilder(env).using(config.getJerseyClientConfiguration()).build(getClass().getName());
    }

}
