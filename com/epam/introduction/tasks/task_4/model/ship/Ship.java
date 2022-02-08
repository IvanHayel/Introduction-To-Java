package com.epam.introduction.tasks.task_4.model.ship;

import com.epam.introduction.tasks.task_4.model.container.Container;
import com.epam.introduction.tasks.task_4.model.port.Port;
import com.epam.introduction.tasks.task_4.model.ship.type.ShipType;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public abstract class Ship implements Runnable {
    private static int nextId = 0;

    private final int ID;

    protected ShipType type;
    protected Port port;
    protected Queue<Container> cargo;

    protected Ship() {
        ID = ++nextId;
    }

    public String getName() {
        return String.format("Ship #%d", ID);
    }

    public int getCapacity() {
        return type.getCapacity();
    }

    public int getSize() {
        return cargo.size();
    }

    public static class Supplier extends Ship {
        public Supplier(ShipType type, Port port) {
            this.type = type;
            this.port = port;
            cargo = new LinkedList<>();
            for (int counter = 0; counter < type.getCapacity(); counter++) {
                cargo.add(new Container());
            }
            port.register(this);
        }

        @Override
        public void run() {
            this.port.unload(this, cargo);
        }
    }

    public static class Consumer extends Ship {
        public Consumer(ShipType type, Port port) {
            this.type = type;
            this.port = port;
            cargo = new ArrayBlockingQueue<>(type.getCapacity());
            port.register(this);
        }

        @Override
        public void run() {
            this.port.load(this, cargo);
        }
    }
}