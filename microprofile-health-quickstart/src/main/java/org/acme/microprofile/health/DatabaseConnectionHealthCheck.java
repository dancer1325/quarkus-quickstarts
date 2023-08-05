package org.acme.microprofile.health;

import jakarta.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.HealthCheckResponseBuilder;
import org.eclipse.microprofile.health.Readiness;

@Readiness
// It will be returned under `...q/health/ready`
@ApplicationScoped
public class DatabaseConnectionHealthCheck implements HealthCheck {

    @ConfigProperty(name = "database.up", defaultValue = "false")
    boolean databaseUp;

    @Override
    public HealthCheckResponse call() {

        HealthCheckResponseBuilder responseBuilder = HealthCheckResponse.named("Database connection health check");

        try {
            simulateDatabaseConnectionVerification();
            responseBuilder.up();
        } catch (IllegalStateException e) {
            // Catch just this error, since it's the thrown manually by us
            // cannot access the database
            responseBuilder.down()
                    // Possible to supply arbitrary data via key-value pairs. Pretty useful in error scenarios
                    .withData("error", e.getMessage()); // pass the exception message
        }

        return responseBuilder.build();
    }

    private void simulateDatabaseConnectionVerification() {
        if (!databaseUp) {
            throw new IllegalStateException("Cannot contact database");
        }
    }
}
