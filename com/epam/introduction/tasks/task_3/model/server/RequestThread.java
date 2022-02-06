package com.epam.introduction.tasks.task_3.model.server;

import com.epam.introduction.tasks.task_3.model.card.StudentCard;
import com.epam.introduction.tasks.task_3.model.card.StudentCards;
import com.epam.introduction.tasks.task_3.model.user.User;
import com.epam.introduction.tasks.task_3.model.user.Users;
import com.epam.introduction.tasks.task_3.util.parser.xml.XMLParser;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RequestThread extends Thread {
    private final Logger LOG = Logger.getLogger("RequestThread");

    private final Socket connectionSocket;
    private final ObjectOutputStream writer;
    private final ObjectInputStream reader;
    private User loggedInUser;

    private final Users users;
    private final StudentCards studentCards;

    public RequestThread(Socket connectionSocket, Users users, StudentCards studentCards) throws IOException {
        this.connectionSocket = connectionSocket;
        this.users = users;
        this.studentCards = studentCards;
        writer = new ObjectOutputStream(connectionSocket.getOutputStream());
        writer.flush();
        reader = new ObjectInputStream(connectionSocket.getInputStream());
    }

    @Override
    public void run() {
        InetAddress connectionAddress = connectionSocket.getInetAddress();
        try {
            while (connectionSocket.isConnected()) {
                receiveAction();
            }
        } catch (IOException e) {
            LOG.log(Level.INFO, "Client terminate the connection.");
        } catch (ClassNotFoundException e) {
            LOG.log(Level.WARNING, "Error while processing actions from the client!");
        } finally {
            closeAll();
            LOG.log(Level.INFO, () -> connectionAddress + " disconnected from server!");
        }
    }

    private synchronized void updateUsers() {
        XMLParser.jaxbUsersToXML(users);
    }

    private synchronized void updateStudentCards(){
        XMLParser.jaxbStudentCardsToXML(studentCards);
    }

    private void receiveAction() throws IOException, ClassNotFoundException {
        String action = (String) reader.readObject();
        switch (action) {
            case "sign up" -> loggedInUser = requestUserRegister();
            case "sign in" -> loggedInUser = requestUserLogin();
            case "all student cards" -> requestAllStudentCards();
            case "add student card" -> requestAddStudentCard();
            case "verify card number" -> requestVerifyCardNumber();
            case "modify card" -> requestModifyStudentCard();
            default -> throw new IllegalStateException();
        }
    }

    private User requestUserLogin() throws IOException, ClassNotFoundException {
        User user = (User) reader.readObject();
        Boolean isUserExist = users.contains(user);
        writer.writeObject(isUserExist);
        writer.flush();
        return users.get(user.getLogin());
    }

    private User requestUserRegister() throws IOException, ClassNotFoundException {
        User user = (User) reader.readObject();
        boolean isLoginExist = users.isLoginExist(user.getLogin());
        writer.writeObject(!isLoginExist);
        writer.flush();
        if(isLoginExist){
            return null;
        }
        users.addUser(user);
        updateUsers();
        return user;
    }

    private void requestAllStudentCards() throws IOException {
        if(loggedInUser != null){
            writer.writeObject(studentCards);
            writer.flush();
        }
    }

    private void requestAddStudentCard() throws IOException, ClassNotFoundException {
        StudentCard studentCard = (StudentCard) reader.readObject();
        Boolean response = loggedInUser.isAdmin();
        writer.writeObject(response);
        writer.flush();
        if(Boolean.TRUE.equals(response)){
            studentCards.addCard(studentCard);
            updateStudentCards();
        }
    }

    private void requestVerifyCardNumber() throws IOException, ClassNotFoundException {
        long studentCard = (long) reader.readObject();
        Boolean response = studentCards.isExist(studentCard);
        writer.writeObject(response);
        writer.flush();
    }

    private void requestModifyStudentCard() throws IOException, ClassNotFoundException {
        StudentCard studentCard = (StudentCard) reader.readObject();
        Boolean response = loggedInUser.isAdmin();
        writer.writeObject(response);
        writer.flush();
        if(Boolean.TRUE.equals(response)){
            studentCards.remove(studentCard.getCardNumber());
            studentCards.addCard(studentCard);
            updateStudentCards();
        }
    }

    private void closeAll() {
        try {
            reader.close();
            writer.close();
            connectionSocket.close();
        } catch (IOException e) {
            LOG.log(Level.WARNING, "Closing streams and connections denied!");
            System.exit(1);
        }
    }
}