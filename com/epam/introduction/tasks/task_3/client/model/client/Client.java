package com.epam.introduction.tasks.task_3.client.model.client;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client implements AutoCloseable {
    private final Logger LOG = Logger.getLogger("Socket Client");
    private final int PORT = 8080;
    private final String HOST = "localhost";

    private ClientStatus status;
    private Socket clientSocket;

    public Client() {
    }

    public void connect() throws IOException {
        status = ClientStatus.UNKNOWN;
        clientSocket = new Socket(HOST, PORT);
        status = ClientStatus.CONNECTED;
        LOG.log(Level.INFO, "Connected to " + HOST + ":" + PORT);
    }

    @Override
    public void close() throws Exception {
        status = ClientStatus.UNKNOWN;
        clientSocket.close();
        LOG.log(Level.INFO, "Disconnected from " + HOST + ":" + PORT);
        status = ClientStatus.DISCONNECTED;
    }
}