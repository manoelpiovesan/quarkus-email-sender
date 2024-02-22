package io.github.manoelpiovesan.repositories;

import io.github.manoelpiovesan.entities.Email;
import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.WebApplicationException;

@ApplicationScoped
public class EmailRepository {

    @Inject
    Mailer mailer;

    public Email sendEmail(Email email) {
        validateEmail(email);

        mailer.send(Mail.withText(email.email, email.subject, email.message));

        return email;
    }

    private void validateEmail(Email email) {
        if (email.email == null || email.email.isBlank()) {
            throw new WebApplicationException("Email is required", 400);
        }

        if (email.message == null || email.message.isBlank()) {
            throw new WebApplicationException("Message is required", 400);
        }

        if (email.subject == null || email.subject.isBlank()) {
            throw new WebApplicationException("Subject is required", 400);
        }

        String regex = "^(.+)@(.+)$";

        if (!email.email.matches(regex)) {
            throw new WebApplicationException("Invalid email", 400);
        }

    }

}
