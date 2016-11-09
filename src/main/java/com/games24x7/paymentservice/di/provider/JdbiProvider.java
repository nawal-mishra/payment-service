package com.games24x7.paymentservice.di.provider;

import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Environment;

import org.skife.jdbi.v2.DBI;

import com.games24x7.paymentservice.EntryConfiguration;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * 
 * @author nawal
 *
 */
public class JdbiProvider implements Provider<DBI> {

    private final EntryConfiguration configuration;
    private final Environment environment;

    @Inject
    public JdbiProvider(EntryConfiguration configuration, Environment environment) {
        this.configuration = configuration;
        this.environment = environment;
    }

    @Override
    public DBI get() {
        final DBIFactory factory = new DBIFactory();
        DataSourceFactory dsFactory = configuration.getDataSourceFactory();
        final DBI jdbi = factory.build(environment, dsFactory, "mysql");
        return jdbi;
    }

}
