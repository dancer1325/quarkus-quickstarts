package org.acme.getting.started;

import org.junit.jupiter.api.Test;
import io.quarkus.test.junit.QuarkusTest;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
public class TestUrlSystemPropertyTest {

    private final HttpClient client = HttpClient.newHttpClient();

    @Test
    public void testUsingSystemProperty() throws Exception {
        // Get base test URL from system property
        String baseUrl = System.getProperty("test.url");
        assertNotNull(baseUrl, "test.url system property should be set by Quarkus");
        
        String fullUrl = baseUrl + "/hello";
        
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(fullUrl))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, 
                HttpResponse.BodyHandlers.ofString());

        assertEquals(200, response.statusCode());
        assertEquals("Hello from Quarkus REST", response.body());
        System.out.println("Base test URL: " + baseUrl);
    }

    @Test
    public void testWithPathParameter() throws Exception {
        String baseUrl = System.getProperty("test.url");
        String fullUrl = baseUrl + "/hello/greeting/Alfred";
        
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(fullUrl))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, 
                HttpResponse.BodyHandlers.ofString());

        assertEquals("hello Alfred", response.body());
    }
}
