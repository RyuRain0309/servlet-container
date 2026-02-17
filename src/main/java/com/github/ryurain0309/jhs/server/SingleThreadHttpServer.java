package com.github.ryurain0309.jhs.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SingleThreadHttpServer implements HttpServer {

    private final int port;
    private volatile boolean running = false;
    private ServerSocket serverSocket;
    private static final Logger logger = LoggerFactory.getLogger(SingleThreadHttpServer.class);

    public SingleThreadHttpServer(int port) {
        this.port = port;
    }

    @Override
    public void start() {
        try {
            serverSocket = new ServerSocket(port);
            logger.info("Server started on port : {}", port);

            running = true;
            while (running) {
                Socket socket = serverSocket.accept();
                handleRequest(socket);
            }

        } catch (IOException e) {
            logger.error("Error while accepting socket", e);
        }
    }

    @Override
    public void stop() {
        running = false;
        if (serverSocket != null && !serverSocket.isClosed()) {
            try {
                serverSocket.close();
            } catch (IOException e) {
                logger.error("Error while closing server socket", e);
            }
        }
    }

    private void handleRequest(Socket socket) {
        try (
                socket;
                InputStream input = socket.getInputStream();
                OutputStream output = socket.getOutputStream()
        ) {
            byte[] buffer = new byte[1024];
            int read = input.read(buffer);
            String request = new String(buffer, 0, read);
            logger.info("Received request: {}", request);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
