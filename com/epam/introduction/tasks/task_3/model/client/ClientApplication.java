package com.epam.introduction.tasks.task_3.model.client;

import java.io.IOException;

public class ClientApplication {
    private ClientModel clientModel;

    public void start() {
        int port = 8080;
        String host = "localhost";
        try {
            clientModel = new ClientModel(host, port);
        } catch (IOException e) {
            e.printStackTrace();
            String errorMessage = String.format("Connection to %s:%d failed.", host, port);
            ClientModel.terminateWithError(errorMessage);
        }
        try {
            clientModel.setStreams();
        } catch (IOException e) {
            e.printStackTrace();
            ClientModel.terminateWithError("Setting up streams failed.");
        }
        ClientView clientView = new ClientView(clientModel);
        clientView.authenticate();
    }
}