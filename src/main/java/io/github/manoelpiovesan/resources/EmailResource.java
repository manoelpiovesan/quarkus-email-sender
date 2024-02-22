package io.github.manoelpiovesan.resources;

import io.github.manoelpiovesan.entities.Email;
import io.github.manoelpiovesan.repositories.EmailRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("/email")
public class EmailResource {

    @Inject
    EmailRepository emailRepository;

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response sendEmail(Email email) {
        Email localEmail = emailRepository.sendEmail(email);

        return Response.ok(localEmail).build();
    }

    @GET
    @Produces("application/json")
    public Response getEmails() {
        return Response.ok(Email.listAll()).build();
    }

}
