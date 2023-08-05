package org.acme.microprofile.health;

import jakarta.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

@Liveness
// It will be returned under `...q/health/live`
@ApplicationScoped
// Recommendation to annotate with this or @Singleton
public class DataHealthCheck implements HealthCheck {

    @Override
    public HealthCheckResponse call() {
        return HealthCheckResponse.named("Health check with data")
                .up()
                // Possible to supply arbitrary data via key-value pairs
                .withData("foo", "fooValue")
                .withData("bar", "barValue")
                .build();
    }
}
