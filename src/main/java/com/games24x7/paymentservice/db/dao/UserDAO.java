package com.games24x7.paymentservice.db.dao;

import java.sql.Timestamp;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;

/**
 * @author nawal
 *
 */
public interface UserDAO {
    @SqlQuery( "select real_account_creation_date from user_preference where user_id=:userId" )
    Timestamp getRealAccountCreationDate( @Bind( "userId" ) long userId );
}
