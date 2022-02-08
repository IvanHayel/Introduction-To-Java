package com.epam.introduction.tasks.task_4.util.thread_factory;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class PierThreadFactory implements ThreadFactory {
    private static final AtomicInteger counter = new AtomicInteger(0);

    @Override
    public Thread newThread(Runnable task) {
        String prefix = "pier #";
        return new Thread(task, prefix + counter.incrementAndGet());
    }
}