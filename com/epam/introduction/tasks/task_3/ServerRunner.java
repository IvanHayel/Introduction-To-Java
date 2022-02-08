package com.epam.introduction.tasks.task_3;

import com.epam.introduction.tasks.task_3.model.server.ServerApplication;

/*
 * TODO:
 *  1. Refactoring!
 *  2. Create test's to application.
 */

/*
 * ATTENTION!
 * Base users:
 * Login: admin Password: admin - administrator
 * Login: user Password: user - user
 */

/**
 * Client-server application "Archive".
 */

public class ServerRunner {
    public static void main(String[] args) {
        try(ServerApplication app = ServerApplication.instance()){
            app.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}