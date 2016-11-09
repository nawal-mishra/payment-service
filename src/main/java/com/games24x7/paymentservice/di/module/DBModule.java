package com.games24x7.paymentservice.di.module;

import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.games24x7.paymentservice.EntryConfiguration;
import com.games24x7.paymentservice.di.provider.JdbiProvider;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Named;


/**
 * 
 * @author nawal
 *
 */

public class DBModule extends AbstractModule {
    private static final Logger LOG = LoggerFactory.getLogger(DBModule.class);

    @Override
    protected void configure() {
        LOG.info("Initializing DBModule");
        bind(DBI.class).toProvider(JdbiProvider.class).in(Singleton.class);
        //bind(Repository.class).toProvider(RepositoryProvider.class);
    }

    @Provides
    @Named("validationQuery")
    public String provideValidationQuery(EntryConfiguration config) {
        return config.getDataSourceFactory().getValidationQuery();
    }

}
