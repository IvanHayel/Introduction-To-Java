package com.epam.introduction.tasks.task_3.util.parser.xml;

import com.epam.introduction.tasks.task_3.model.card.StudentCards;
import com.epam.introduction.tasks.task_3.model.user.Users;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public final class XMLParser {
    private static final String CARDS_FILE_PATH =
            "src/main/java/com/epam/introduction/tasks/task_3/data/student_cards/cards.xml";
    private static final String USERS_FILE_PATH =
            "src/main/java/com/epam/introduction/tasks/task_3/data/users/users.xml";

    private XMLParser() {
    }

    public static void jaxbStudentCardsToXML(StudentCards cards) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(StudentCards.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            if(Files.exists(Paths.get(CARDS_FILE_PATH))) {
                Files.delete(Paths.get(CARDS_FILE_PATH));
            }
            File file = new File(CARDS_FILE_PATH);
            jaxbMarshaller.marshal(cards, file);
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
    }

    public static StudentCards jaxbStudentCardsFromXML() {
        File xmlFile = new File(CARDS_FILE_PATH);
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(StudentCards.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            return (StudentCards) jaxbUnmarshaller.unmarshal(xmlFile);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void jaxbUsersToXML(Users users) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            if(Files.exists(Paths.get(USERS_FILE_PATH))) {
                Files.delete(Paths.get(USERS_FILE_PATH));
            }
            File file = new File(USERS_FILE_PATH);
            jaxbMarshaller.marshal(users, file);
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
    }

    public static Users jaxbUsersFromXML() {
        File xmlFile = new File(USERS_FILE_PATH);
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(Users.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            return (Users) jaxbUnmarshaller.unmarshal(xmlFile);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}