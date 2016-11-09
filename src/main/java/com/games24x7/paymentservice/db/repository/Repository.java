package com.games24x7.paymentservice.db.repository;

import java.sql.Timestamp;

import org.skife.jdbi.v2.sqlobject.CreateSqlObject;

import com.games24x7.paymentservice.db.dao.UserDAO;

/**
 * 
 * @author nawal
 *
 */
public abstract class Repository {

    @CreateSqlObject
    abstract UserDAO createUserDao();

    public abstract void close();

    public Timestamp getRealAccountCreationDate(long userId) {
        return createUserDao().getRealAccountCreationDate(userId);
    }

}
