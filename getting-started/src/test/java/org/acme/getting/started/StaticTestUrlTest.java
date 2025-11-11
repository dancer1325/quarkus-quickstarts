package org.acme.getting.started;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
public class StaticTestUrlTest {

    private static String testBaseUrl;

    @BeforeAll
    static void setup() {
        // Can't use injection in static @BeforeAll
        testBaseUrl = System.getProperty("test.url");
        assertNotNull(testBaseUrl, "test.url should be available in @BeforeAll");
        System.out.println("Test server running at: " + testBaseUrl);
    }

    @Test
    public void testAfterSetup() throws Exception {
        String response = TestUtils.makeRequest("/hello");
        assertEquals("Hello from Quarkus REST", response);
    }

    @Test
    public void testWithStaticField() throws Exception {
        // Using static field set in @BeforeAll
        String response = TestUtils.makeRequest("/hello/greeting/Andrea");
        assertEquals("hello Andrea", response);
        System.out.println("Used base URL: " + testBaseUrl);
    }

    @Test
    public void testUtilityMethod() throws Exception {
        String baseUrl = TestUtils.getBaseTestUrl();
        assertNotNull(baseUrl);
        assertEquals(testBaseUrl, baseUrl);
    }
}
