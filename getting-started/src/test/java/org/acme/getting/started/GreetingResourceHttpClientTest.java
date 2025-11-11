package org.acme.getting.started;

import io.quarkus.test.common.http.TestHTTPResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
public class GreetingResourceHttpClientTest {
    // @TestHTTPResource | tested application's URI -- through -- test class's field
    @TestHTTPResource("/hello")
    URI helloUri;

    // @TestHTTPResource | tested application's URI -- through -- test class's field
    @TestHTTPResource("/hello/greeting/Alfred")
    URI helloNameUri;

    // @TestHTTPResource | tested application's URL -- through -- test class's field
    @TestHTTPResource("/hello")
    URL helloUrl;

    // @TestHTTPResource | tested application's String -- through -- test class's field
    @TestHTTPResource("/hello")
    String helloUrlString;

    private final HttpClient client = HttpClient.newHttpClient();

    // 1. as URI
    @Test
    public void testHelloEndpoint() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(helloUri)
                .GET()
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        assertEquals(200, response.statusCode());
        assertEquals("Hello from Quarkus REST", response.body());
    }

    @Test
    public void testHelloNameEndpoint() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(helloNameUri)
                .GET()
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        assertEquals(200, response.statusCode());
        assertEquals("hello Alfred", response.body());
    }

    // 2. as URL
    @Test
    public void testHelloEndpointAsURL() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(helloUrl.toURI())
                .GET()
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        assertEquals(200, response.statusCode());
        assertEquals("Hello from Quarkus REST", response.body());
    }

    // 3. as String
    @Test
    public void testHelloEndpointAsString() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(helloUrlString))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        assertEquals(200, response.statusCode());
        assertEquals("Hello from Quarkus REST", response.body());
    }
}
