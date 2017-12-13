package com.klix.app;/*
 * This Java source file was generated by the Gradle 'init' task.
 */


import com.klix.app.link.LinkDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Spark;

import java.util.logging.Level;


import static spark.Spark.post;


public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static LinkDao linkDao;

    public static void main(String[] args) {
        int port = 443;
        String portStr = System.getenv("PORT");
        if (portStr != null && !portStr.equals("")) {
            log.info("using port from environment: " + port);
            port = Integer.valueOf(portStr);
        }


        System.out.println("Port: " + port);
        Spark.staticFileLocation("/public");

        spark.Spark.port(port);
        spark.Spark.init();


        post("/submit", (req, res) -> {
            return req.body();
        });

    }
}
