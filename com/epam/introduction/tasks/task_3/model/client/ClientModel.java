package com.epam.introduction.tasks.task_3.model.client;

import com.epam.introduction.tasks.task_3.model.card.StudentCard;
import com.epam.introduction.tasks.task_3.model.card.StudentCards;
import com.epam.introduction.tasks.task_3.model.user.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientModel {
    private static final Logger LOG = Logger.getLogger("ClientModel");

    private final Socket connectionSocket;
    private ObjectOutputStream writer;
    private ObjectInputStream reader;

    public ClientModel(String serverHost, int serverPort) throws IOException {
        connectionSocket = new Socket(serverHost, serverPort);
    }

    public static void terminateWithError(String message) {
        LOG.log(Level.WARNING, message);
        System.exit(1);
    }

    public void setStreams() throws IOException {
        writer = new ObjectOutputStream(connectionSocket.getOutputStream());
        writer.flush();
        reader = new ObjectInputStream(connectionSocket.getInputStream());
    }

    public void terminate() {
        try {
            closeStreams();
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
            LOG.log(Level.WARNING, "Closing streams denied!");
            System.exit(1);
        }
    }

    private void terminateWithError(String message, int errorCode) {
        try {
            LOG.log(Level.WARNING, message);
            closeStreams();
            System.exit(errorCode);
        } catch (IOException e) {
            e.printStackTrace();
            LOG.log(Level.WARNING, "Closing streams denied!");
            System.exit(1);
        }
    }

    private void sendAction(String action) {
        try {
            writer.writeObject(action);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
            terminateWithError("Sending action denied!", 2);
        }
    }

    public boolean loginUser(String login, String password) {
        sendAction("sign in");
        User unknownUser = new User(login, password);
        try {
            writer.writeObject(unknownUser);
            writer.flush();
            return (Boolean) reader.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            terminateWithError("User verification denied!", 2);
        }
        return false;
    }

    public boolean registerUser(String login, String password) {
        sendAction("sign up");
        User user = new User(login, password);
        try {
            writer.writeObject(user);
            writer.flush();
            return (Boolean) reader.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            terminateWithError("User verification denied!", 2);
        }
        return false;
    }

    public void showAllStudentCards() {
        try {
            sendAction("all student cards");
            StudentCards cards = (StudentCards) reader.readObject();
            cards.showCardList();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            terminateWithError("Unable to get data from server!", 3);
        }
    }

    public boolean addStudentCard(StudentCard studentCard) {
        try {
            sendAction("add student card");
            writer.writeObject(studentCard);
            writer.flush();
            return (Boolean) reader.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            terminateWithError("Adding student card declined!", 3);
        }
        return false;
    }

    public boolean verifyCardNumber(long cardNumber) {
        try {
            sendAction("verify card number");
            writer.writeObject(cardNumber);
            writer.flush();
            return (Boolean) reader.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            terminateWithError("Card number verification denied!", 3);
        }
        return false;
    }

    public boolean modifyStudentCard(StudentCard studentCard) {
        try {
            sendAction("modify card");
            writer.writeObject(studentCard);
            writer.flush();
            return (Boolean) reader.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            terminateWithError("Student card modifying denied!", 3);
        }
        return false;
    }

    private void closeStreams() throws IOException {
        if (reader != null) {
            reader.close();
        }
        if (writer != null) {
            writer.close();
        }
        if (connectionSocket != null) {
            connectionSocket.close();
        }
    }
}