package org.acme.config;

import java.time.Duration;
import java.util.Optional;

import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithDefault;

// group MULTIPLE sources
@ConfigMapping(prefix = "server")
public interface ServerConfig {
    
    @WithDefault("localhost")
    String host();  // server.host
    
    @WithDefault("8080")
    int port();     // server.port
    
    @WithDefault("false")
    boolean ssl();  // server.ssl
    
    @WithDefault("30s")
    Duration timeout();  // server.timeout
    
    Optional<String> version();  // server.version - optional
}