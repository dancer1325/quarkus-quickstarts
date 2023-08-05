package org.acme.microprofile.health;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Startup;

import jakarta.enterprise.context.ApplicationScoped;

@Startup
// Option for slow starting containers -- Normally, unneeded for Quarkus --
// It will be returned under `...q/health/started`
@ApplicationScoped
public class StartupHealthCheck implements HealthCheck {

    @Override
    public HealthCheckResponse call() {
        return HealthCheckResponse.up("Startup health check");
    }
}
