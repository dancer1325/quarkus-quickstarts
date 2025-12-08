package org.acme.microprofile.health;

import jakarta.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

@Liveness
// It will be returned under `...q/health/live`
@ApplicationScoped
// Recommendation to annotate with this or @Singleton   -- Reason:🧠1! bean instance / ALL health check requests🧠
public class SimpleHealthCheck implements HealthCheck {

    @Override
    public HealthCheckResponse call() {
        return HealthCheckResponse.up("Simple health check");
    }
}
