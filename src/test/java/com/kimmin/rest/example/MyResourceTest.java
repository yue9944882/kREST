package com.kimmin.rest.example;

/**
 * Created by min.jin on 2016/2/22.
 */



import java.io.IOException;
import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import org.glassfish.grizzly.http.server.HttpServer;

import com.sun.jersey.api.container.grizzly2.GrizzlyServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;

public class MyResourceTest {

    public static URI getBaseURI(){
        return UriBuilder.fromUri("http://localhost/").port(9998).build();
    }

    public static final URI BASE_URI = getBaseURI();

    protected static HttpServer startServer() throws IllegalArgumentException, NullPointerException, IOException{
        System.out.println("Start server...");
        ResourceConfig config = new PackagesResourceConfig("com.study.jersey.server");
        return GrizzlyServerFactory.createHttpServer(BASE_URI, config);
    }
    public static void main(String[] args) {
        try {
            HttpServer httpServer = startServer();
            System.out.println(String.format("Jersey app started with WADL available at" + "%sapplication.wadl\nTry out %shelloworld\nHit enter to stop it...", BASE_URI, BASE_URI));
            System.in.read();
            httpServer.stop();
        } catch (Throwable e) {
            e.printStackTrace();
        }

    }
}