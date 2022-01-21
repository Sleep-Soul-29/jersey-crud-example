//Create a Resource class - StudentResource.java
package com.java.jersey.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.java.jersey.model.User;
import com.java.jersey.services.StudService;

@Path("/students")
public class StudentResource {

    private StudService studService = new StudService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> fetchAll() {
        return studService.fetchAll();
    }

    @GET
    @Path("student/{no}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("no") int no) {
        return Response.ok().entity(new Student(34, "Pooja", "2000-03-02","2022-01-21")).build();
    }
 
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Student student) {
        // create notification
        StudService.create(student);
        return Response.status(Status.CREATED).build();
    }
 
    @PUT
    @Path("/student/{no}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("no") long no, Student student) {
        userService.update(student);
        return Response.noContent().build();
    }

    @DELETE
    @Path("/student/{no}")
    public Response delete(@PathParam("no") long no) {
        userService.delete(no);
        return Response.status(202).entity("User deleted successfully !!").build();
    }
}