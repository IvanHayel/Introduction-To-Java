package com.epam.introduction.tasks.task_3.client;

import com.epam.introduction.tasks.task_3.client.model.client.Client;

public class Runner {
    public static void main(String[] args) {
        try(Client client = new Client()){
            client.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}