package io.github.manoelpiovesan.repositories;

import io.github.manoelpiovesan.entities.Email;
import io.github.manoelpiovesan.enums.EmailStatus;
import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;

@ApplicationScoped
public class EmailRepository {

    @Inject
    Mailer mailer;

    @Transactional
    public Email sendEmail(Email email) {
        validateEmail(email);

        email.status = EmailStatus.PENDING;

        try{
            mailer.send(Mail.withText(email.email, email.subject, email.message));
            email.status = EmailStatus.SENT;
        } catch (Exception e) {
            email.status = EmailStatus.ERROR;
            throw new WebApplicationException(e.toString(), 500);
        }

        email.persist();

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
