package com.klix;/*
 * This Java source file was generated by the Gradle 'init' task.
 */


import com.klix.Klix;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.Assert.assertEquals;


public class KlixTest {

    private HttpClient httpClient;

    public KlixTest() {
        HttpClientBuilder builder = HttpClientBuilder.create();
        httpClient = builder.build();
    }

    @Before
    public void runApp() throws InterruptedException {
        Klix app = new Klix();
        ExecutorService threadPoolExecutor = Executors.newSingleThreadExecutor();
        threadPoolExecutor.execute(app);
        System.out.println("Server has issued a start command");
        Thread.sleep(3 * 1000);
    }

    @Test
    public void testKlixHasAGreeting() throws IOException {
        HttpUriRequest request = new HttpGet("http://localhost:443/hello");
        HttpResponse response = httpClient.execute(request);
        assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());
    }
}