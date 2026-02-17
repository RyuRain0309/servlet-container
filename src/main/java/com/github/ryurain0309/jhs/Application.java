package com.github.ryurain0309.jhs;


import com.github.ryurain0309.jhs.server.HttpServer;
import com.github.ryurain0309.jhs.server.SingleThreadHttpServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);
    private static final int PORT = 8080;

    public static void main(String[] args) {
        HttpServer server = new SingleThreadHttpServer(PORT);
        server.start();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            logger.info("Shutting down server...");
            server.stop();
        }));
    }
}