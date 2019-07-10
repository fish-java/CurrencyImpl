package com.github.fishjava.thread.lock;

/**
 * synchronized锁本生就是可重入的
 */
public class ReetrantLock {
    public synchronized void do1(){
        System.out.println("111");
    }
    public synchronized void do2(){
        System.out.println("222");
        do1();
    }
}
