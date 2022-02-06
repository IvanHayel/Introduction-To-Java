package com.epam.introduction.tasks.task_3;

import com.epam.introduction.tasks.task_3.model.client.ClientApplication;

import java.io.IOException;

public class ClientRunner {
    public static void main(String[] args) throws IOException {
        ClientApplication app = new ClientApplication();
        app.start();
    }
}