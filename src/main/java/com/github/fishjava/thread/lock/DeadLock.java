package com.github.fishjava.thread.lock;

/**
 * 死锁
 */
public class DeadLock {
    private static Object object1 = new Object();
    private static Object object2 = new Object();

    public static void do1(){
        synchronized (object1){
            System.out.println(Thread.currentThread().getName() + "得到了object1的锁");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (object2){
                System.out.println("111");
            }
        }
    }

    public static void do2() {
        synchronized (object2){
            System.out.println(Thread.currentThread().getName() + "得到了object2的锁");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (object1){
                System.out.println("222");
            }
        }
    }
}
