package org.acme.getting.started;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TestUtils {
    
    public static String makeRequest(String path) throws Exception {
        // Can't inject here - use system property
        String baseUrl = System.getProperty("test.url");
        String fullUrl = baseUrl + path;
        
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(fullUrl))
                .GET()
                .build();
                
        return client.send(request, HttpResponse.BodyHandlers.ofString()).body();
    }
    
    public static String getBaseTestUrl() {
        return System.getProperty("test.url");
    }
}
