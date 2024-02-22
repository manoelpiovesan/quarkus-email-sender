package io.github.manoelpiovesan.resources;

import io.github.manoelpiovesan.entities.Email;
import io.github.manoelpiovesan.repositories.EmailRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
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

}
