package com.kimmin.rest.example;

/**
 * Created by min.jin on 2016/2/22.
 */
import java.io.IOException;
import java.net.URI;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;


import com.kimmin.rest.example.POJO.RequestJAXB;
import com.kimmin.rest.example.POJO.ResponseJAXB;
import org.glassfish.grizzly.http.server.HttpServer;

import com.sun.jersey.api.container.grizzly2.GrizzlyServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.api.json.JSONConfiguration;



@Path("query")
public class MyResourceRestJAXB {

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseJAXB query(RequestJAXB req) {
        System.out.println(req.getQuery());

        ResponseJAXB resp = new ResponseJAXB();
        resp.setRespCode(0);
        resp.setRespDesc(req.getQuery());
        return resp;
    }

    public static void main(String[] args) {
        URI uri = UriBuilder.fromUri("http://127.0.0.1").port(10000).build();
        ResourceConfig rc = new PackagesResourceConfig("com.kimmin.rest.example");
        //使用Jersey对POJO的支持，必须设置为true
        //rc.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, true);
        try {
            HttpServer server = GrizzlyServerFactory.createHttpServer(uri, rc);
            server.start();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(1000*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}