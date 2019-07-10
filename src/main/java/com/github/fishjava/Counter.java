package com.github.fishjava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Counter {
    private static int threadTotal = 300;
    private static int clientTotal = 5000;

    private static long count = 0;

    private static void add(){
        count = count + 1;
    }

    public static void main(String[] args) {
        ExecutorService executorService =
                Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(threadTotal);

        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (Exception e){
                    e.printStackTrace();
                    System.out.println(e.getMessage());
                }

            });
        }
    }
}
