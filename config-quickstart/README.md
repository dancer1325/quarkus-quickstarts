Quarkus guide: https://quarkus.io/guides/config

# Create the configuration
* configuration -- ONLY based on -- [src/main/resources/application.properties](src/main/resources/application.properties)

# Create a REST resource
* [GreetingResource](src/main/java/org/acme/config/GreetingResource.java)

# Create the configuration
## MULTIPLE sources
* [ServerConfig](src/main/java/org/acme/config/ServerConfig.java) 

# Inject the configuration
* [ServerResource](src/main/java/org/acme/config/ServerResource.java)
* [GreetingResource](src/main/java/org/acme/config/GreetingResource.java)

# 

