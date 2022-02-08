package com.epam.introduction.tasks.task_4.model.port;

import com.epam.introduction.tasks.task_4.model.container.Container;
import com.epam.introduction.tasks.task_4.model.ship.Ship;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class Port {
    private final Queue<Container> cargo;
    private final int capacity;

    private int registeredSuppliers;
    private int registeredConsumers;
    private Random generator;

    public Port(int capacity) {
        this.capacity = capacity;
        cargo = new ArrayBlockingQueue<>(capacity, true);
        registeredSuppliers = 0;
        registeredConsumers = 0;
        try {
            generator = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public void unload(Ship.Supplier ship, Queue<Container> cargo) {
        String pierName = Thread.currentThread().getName();
        String shipName = ship.getName();
        System.out.printf("%s arrived to %s for unloading.%n", shipName, pierName);

        while (!cargo.isEmpty()) {
            waitForConsumers();
            if(this.cargo.size() >= capacity && registeredConsumers <= 0)
                break;
            Container container = cargo.poll();
            this.cargo.add(container);
            notifyAllPiers();
            sleepRandomTime();
            System.out.printf("%s unload %s to %s. Port load: %d/%d.%n",
                    shipName, container, pierName, this.cargo.size(), capacity);
        }

        notifyAllPiers();
        registeredSuppliers--;
        System.out.printf("%s has left %s. Ship load: %d/%d.%n",
                shipName, pierName, ship.getSize(), ship.getCapacity());
    }

    public void load(Ship.Consumer ship, Queue<Container> cargo) {
        String pierName = Thread.currentThread().getName();
        String shipName = ship.getName();
        System.out.println(shipName + " arrived to " + pierName + " for loading.");

        while (cargo.size() < ship.getCapacity()) {
            waitForSuppliers();
            if(this.cargo.isEmpty() && registeredSuppliers <= 0) break;
            Container container = this.cargo.poll();
            cargo.add(container);
            notifyAllPiers();
            sleepRandomTime();
            System.out.printf("%s load %s from %s. Port load: %d/%d.%n",
                    shipName, container, pierName, this.cargo.size(), capacity);
        }

        notifyAllPiers();
        registeredConsumers--;
        System.out.printf("%s has left %s. Ship load: %d/%d.%n",
                shipName, pierName, ship.getSize(), ship.getCapacity());
    }

    private synchronized void waitForSuppliers() {
        while (this.cargo.isEmpty() && registeredSuppliers > 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }

    private synchronized void waitForConsumers() {
        while (this.cargo.size() >= capacity && registeredConsumers > 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }

    private synchronized void notifyAllPiers() {
        notifyAll();
    }

    private void sleepRandomTime(){
        try {
            Thread.sleep(1000 + generator.nextLong(2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    public void register(Ship ship) {
        if (ship instanceof Ship.Supplier) {
            registeredSuppliers++;
        }
        if (ship instanceof Ship.Consumer) {
            registeredConsumers++;
        }
    }
}