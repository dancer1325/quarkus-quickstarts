package org.acme.microprofile.health;

import io.smallrye.health.api.AsyncHealthCheck;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

import java.time.Duration;

@Liveness
// It will be returned under `...q/health/live`
// Just supported by "quarkus-smallrye-health", not my "microprofile-health"
@ApplicationScoped
public class LivenessAsync implements AsyncHealthCheck {

    @Override
    public Uni<HealthCheckResponse> call() {
        return Uni.createFrom().item(HealthCheckResponse.up("liveness-reactive"))
                .onItem().delayIt().by(Duration.ofMillis(10));
    }
}
