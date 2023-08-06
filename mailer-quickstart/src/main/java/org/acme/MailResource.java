package org.acme;

import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import io.quarkus.mailer.reactive.ReactiveMailer;
import io.smallrye.common.annotation.Blocking;
import io.smallrye.mutiny.Uni;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/mail")
public class MailResource {

    @Inject
    Mailer mailer;
    // Managed by Quarkus

    @GET
    @Blocking
    // We need to block, since this endpoint is via imperative mailer + RESTEasy Reactive
    public void sendEmail() {
        // Define the destination (to), subject or text to send
        mailer.send(Mail
                .withText("your-destination-email@quarkus.io",
                        "Ahoy from Quarkus",
                        "A simple email sent from a Quarkus application."));
    }

    @Inject
    ReactiveMailer reactiveMailer;

    @GET
    @Path("/reactive")
    // Since it's reactive -> Unneeded to block it
    public Uni<Void> sendEmailUsingReactiveMailer() {
        // Returns Uni, since it's reactive. Once the mail is sent -> it's completed
        return reactiveMailer.send(                         // <4>
                Mail.withText("alfrejose92@gmail.com",
                        "Ahoy from Quarkus",
                        "A simple email sent from a Quarkus application using the reactive API."
                )
        );
    }

}