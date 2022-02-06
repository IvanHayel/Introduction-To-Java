package com.epam.introduction.basics_of_oop.task_1.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class TextFile {
    private final Path directoryPath =
            Paths.get("src/main/java/com/epam/introduction/basics_of_oop/task_1/data/text");

    private Path filePath;

    public TextFile(String fileName) {
        filePath = Path.of(directoryPath + "/" + fileName + ".txt");
        try {
            if (!Files.exists(filePath)) {
                Files.createFile(filePath);
                System.out.printf("Empty file '%s' created successfully!%n", filePath.getFileName());
            } else {
                System.out.printf("File '%s' already exists!%n", filePath.getFileName());
            }
        } catch (IOException exception) {
            System.out.printf("Creation of file '%s' denied!%n", filePath.getFileName());
        }
    }

    public void append(String text) {
        try {
            Files.write(filePath, text.getBytes(), StandardOpenOption.APPEND);
            System.out.printf("Writing to file '%s' successfully ended.%n", filePath.getFileName());
        } catch (IOException exception) {
            System.out.printf("Writing to file '%s' denied!%n", filePath.getFileName());
        }
    }

    public void rewrite(String text) {
        try {
            Files.write(filePath, text.getBytes(), StandardOpenOption.TRUNCATE_EXISTING);
            System.out.printf("Rewriting file '%s' successfully ended.%n", filePath.getFileName());
        } catch (IOException exception) {
            System.out.printf("Rewriting file '%s' denied!%n", filePath.getFileName());
        }
    }

    public void rename(String newFileName) {
        Path newFilePath = Path.of(directoryPath + "/" + newFileName + ".txt");
        try {
            Files.move(filePath, newFilePath);
            System.out.printf("File '%s' successfully renamed to '%s'!%n", filePath.getFileName(), newFilePath.getFileName());
            filePath = newFilePath;
        } catch (IOException exception) {
            System.out.printf("Renaming file '%s' denied!%n", filePath.getFileName());
        }
    }

    public void display() {
        try {
            List<String> content = Files.readAllLines(filePath);
            System.out.printf("'%s' content:%n", filePath.getFileName());
            for (String line : content) {
                System.out.println(line);
            }
        } catch (IOException exception) {
            System.out.printf("Displaying '%s' content denied!%n", filePath.getFileName());
        }
    }

    public void delete() {
        try {
            String fileName = String.valueOf(filePath.getFileName());
            Files.delete(filePath);
            System.out.printf("File '%s' successfully deleted.%n", fileName);
        } catch (IOException e) {
            System.out.printf("File '%s' deletion denied.%n", filePath.getFileName());
        }
    }
}