package com.epam.introduction.tasks.task_3.server;

import com.epam.introduction.tasks.task_3.server.model.server.Server;

public class Runner {
    public static void main(String[] args) {
        try(Server server = Server.instance()){
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}