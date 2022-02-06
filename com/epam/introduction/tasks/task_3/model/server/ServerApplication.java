package com.epam.introduction.tasks.task_3.model.server;

import com.epam.introduction.tasks.task_3.model.card.StudentCards;
import com.epam.introduction.tasks.task_3.model.user.Users;
import com.epam.introduction.tasks.task_3.util.parser.xml.XMLParser;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class ServerApplication implements AutoCloseable {
    private final Logger LOG = Logger.getLogger("ServerApplication");
    private static final int PORT = 8080;

    private static ServerApplication instance;

    private ServerSocket serverSocket;
    private Users users;
    private StudentCards studentCards;

    private ServerApplication() {
    }

    public static ServerApplication instance() {
        if (instance == null) {
            instance = new ServerApplication();
        }
        return instance;
    }

    public void start() {
        createServer();
        loadUsers();
        loadStudentCards();
        acceptClientRequest();
    }

    private void createServer() {
        try {
            serverSocket = new ServerSocket(PORT);
            LOG.log(Level.INFO, () -> "Socket server started on port: " + PORT);
        } catch (IOException e) {
            e.printStackTrace();
            LOG.log(Level.WARNING, () -> "System failed binding socket server to port: " + PORT);
            System.exit(1);
        }
    }

    private void loadUsers() {
        users = XMLParser.jaxbUsersFromXML();
    }

    private void loadStudentCards() {
        studentCards = XMLParser.jaxbStudentCardsFromXML();
    }

    private void acceptClientRequest() {
        LOG.log(Level.INFO, "Server is now ready to accept connections...");
        while (!serverSocket.isClosed()) {
            try {
                Socket connectionSocket = serverSocket.accept();
                InetAddress connectionAddress = connectionSocket.getInetAddress();
                int connectionPort = connectionSocket.getPort();
                LOG.log(Level.INFO, () -> connectionAddress + " connected to server on port: " + connectionPort);
                new RequestThread(connectionSocket, users, studentCards).start();
            } catch (IOException e) {
                e.printStackTrace();
                LOG.log(Level.WARNING, "Connection failed!");
            }
        }
    }

    @Override
    public void close() throws Exception {
        serverSocket.close();
        LOG.log(Level.INFO, () -> "Socket server now unavailable on port: " + PORT);
    }
}