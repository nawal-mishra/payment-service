package com.games24x7.paymentservice.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;
import com.games24x7.paymentservice.core.service.UserService;
import com.google.inject.Inject;

/**
 * @author nawal
 *
 */
@Path( "/users" )
@Produces( MediaType.APPLICATION_JSON )
public class UserResource {
    
    @Inject
    UserService userService;

    @GET
    @Timed
    @Path( "/getUserType" )
    @Produces( MediaType.APPLICATION_JSON )
    public String getUserType( @QueryParam( "userId" ) long userId )throws Exception {
        return userService.getDepositorStatus(userId);
    }
}