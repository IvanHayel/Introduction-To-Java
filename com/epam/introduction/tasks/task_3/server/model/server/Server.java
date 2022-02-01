package com.epam.introduction.tasks.task_3.server.model.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Server implements AutoCloseable {
    private final Logger LOG = Logger.getLogger("Socket Server");
    private final int PORT = 8080;

    private static Server instance;

    private ServerStatus status;
    private ServerSocket serverSocket;
    private int totalConnections;

    private Server() {
        status = ServerStatus.UNAVAILABLE;
        totalConnections = 0;
    }

    public static Server instance() {
        if (instance == null) {
            instance = new Server();
        }
        return instance;
    }

    public void start() throws IOException {
        status = ServerStatus.UNKNOWN;
        serverSocket = new ServerSocket(PORT);
        status = ServerStatus.RUNNING;
        LOG.log(Level.INFO, "Socket server started on port: " + PORT);
        Socket clientSocket = serverSocket.accept();
        LOG.log(Level.INFO, "Someone connected... Total connections: " + ++totalConnections);
        clientSocket.close();
    }

    @Override
    public void close() throws Exception {
        status = ServerStatus.UNKNOWN;
        serverSocket.close();
        LOG.log(Level.INFO, "Socket server now unavailable on port: " + PORT);
        status = ServerStatus.UNAVAILABLE;
    }
}