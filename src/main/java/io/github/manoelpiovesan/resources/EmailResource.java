package io.github.manoelpiovesan.resources;

import io.github.manoelpiovesan.entities.Email;
import io.github.manoelpiovesan.repositories.EmailRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/email")
public class EmailResource {

    @Inject
    EmailRepository emailRepository;

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Transactional
    public Response sendEmail(Email email) {
        Email localEmail = emailRepository.sendEmail(email);

        return Response.ok(localEmail).build();
    }

    @GET
    @Produces("application/json")
    public Response getEmails() {
        return Response.ok(Email.listAll()).build();
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response getEmail(@PathParam("id") Long id) {
        Email email = Email.findById(id);

        if (email == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(email).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces("application/json")
    @Transactional
    public Response deleteEmail(@PathParam("id") Long id) {
        Email email = Email.findById(id);

        if (email == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        email.delete();

        return Response.noContent().build();
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public Response countEmails() {
        return Response.ok(Email.count()).build();
    }

}
