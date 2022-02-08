package com.epam.introduction.tasks.task_4;

import com.epam.introduction.tasks.task_4.model.port.Port;
import com.epam.introduction.tasks.task_4.model.ship.Ship;
import com.epam.introduction.tasks.task_4.model.ship.type.ShipType;
import com.epam.introduction.tasks.task_4.util.thread_factory.PierThreadFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * TODO:
 *  1. Refactoring!
 *  2. Create test's to application.
 */

/**
 * Multithreading.
 * Port. Ships enter the port to unload/load containers.
 */

public class Runner {
    private static final String PROPERTY_PATH =
            "src/main/java/com/epam/introduction/tasks/task_4/resources/app.properties";
    private static final Properties PROPS = new Properties();
    private static final int PIERS_QUANTITY;
    private static final int PORT_CAPACITY;
    private static final ExecutorService SUPPLIER_SERVICE;
    private static final ExecutorService CONSUMER_SERVICE;

    static {
        loadProperties();
        PIERS_QUANTITY = Integer.parseInt(PROPS.getProperty("port.piers.quantity"));
        PORT_CAPACITY = Integer.parseInt(PROPS.getProperty("port.capacity"));
        int piersForSuppliers = PIERS_QUANTITY >> 1;
        SUPPLIER_SERVICE = Executors.newFixedThreadPool(piersForSuppliers, new PierThreadFactory());
        int piersForConsumers = PIERS_QUANTITY - piersForSuppliers;
        CONSUMER_SERVICE = Executors.newFixedThreadPool(piersForConsumers, new PierThreadFactory());
    }

    public static void main(String[] args) {
        Port port = new Port(PORT_CAPACITY);

        List<Thread> suppliers = new ArrayList<>();
        suppliers.add(new Thread(new Ship.Supplier(ShipType.SMALL, port)));
        suppliers.add(new Thread(new Ship.Supplier(ShipType.SMALL, port)));
        suppliers.add(new Thread(new Ship.Supplier(ShipType.MONSTER, port)));

        List<Thread> consumers = new ArrayList<>();
        consumers.add(new Thread(new Ship.Consumer(ShipType.SMALL, port)));
        consumers.add(new Thread(new Ship.Consumer(ShipType.SMALL, port)));
        consumers.add(new Thread(new Ship.Consumer(ShipType.MEDIUM, port)));

        suppliers.forEach(SUPPLIER_SERVICE::execute);
        consumers.forEach(CONSUMER_SERVICE::execute);

        SUPPLIER_SERVICE.shutdown();
        CONSUMER_SERVICE.shutdown();
    }

    private static void loadProperties() {
        try (FileInputStream propertiesFile = new FileInputStream(PROPERTY_PATH)) {
            PROPS.load(propertiesFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}