package com.restapi.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
@Path("hello")
public class HelloService {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hi(){
        return "hello jersey";
    }

    @GET
    @Path("{id}")
    public String pathParam(@PathParam("id") Long id) {
        System.out.println(this);
        System.out.println(id);
        return "success";
    }

}
