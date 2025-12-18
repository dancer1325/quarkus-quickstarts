package org.acme.rest.client;

import org.eclipse.microprofile.config.inject.ConfigProperty;

public class Config {
    @ConfigProperty(name = "my.param")
    String myParam;
}
