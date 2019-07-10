package com.github.fishjava.thread.lock;

import org.junit.Test;

import static org.junit.Assert.*;

public class DeadLockTest {

    @Test
    public void doSomething(){

        new Thread(() -> {
            DeadLock.do1();
        }).start();
        new Thread(() -> {
            DeadLock.do2();
        }).start();

        while (Thread.activeCount() != 1){
        }

        throw new RuntimeException("没有死锁");
    }
}