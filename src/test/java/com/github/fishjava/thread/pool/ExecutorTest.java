package com.github.fishjava.thread.pool;

import org.junit.Test;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExecutorTest {
    @Test
    public void thread(){
        Executor executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100; i++) {
            executor.execute(() -> {
                System.out.println(Thread.currentThread().getName());
            });
        }
    }
}
