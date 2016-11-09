package com.games24x7.paymentservice.core.service;

import java.sql.Timestamp;

import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.games24x7.paymentservice.db.repository.Repository;
import com.google.inject.Inject;

/**
 * 
 * @author nawal
 *
 */
public class UserService {

    private final DBI jdbi;

    @Inject
    public UserService(DBI jdbi) {
        this.jdbi = jdbi;
    }

    private final Logger logger = LoggerFactory.getLogger(UserService.class);
    
    public String getDepositorStatus(long userId) {
        logger.info("getting status for userId-" + userId );
        Repository repo = jdbi.onDemand(Repository.class);
        Timestamp timeStamp = repo.getRealAccountCreationDate(userId);
        StringBuilder sb = new StringBuilder("{\"firstDepositor\":");
        if ( timeStamp == null ) {
            sb.append("\"true\"}");
        } else {
            sb.append("\"false\"}");
        }
        return sb.toString();
    }
    
}
