package org.acme.opentracing;

import jakarta.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.opentracing.Traced;

@Traced
// Trace additional methods as:
// 1) incoming requests from non-REST calls
// 2) create spans inside a trace
@ApplicationScoped
public class FrancophoneService {

    public String bonjour() {
        return "bonjour";
    }
}
