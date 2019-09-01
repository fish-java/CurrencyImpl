package com.github.fishjava.thread.impl;

/**
 * 通过继承Thread类的方式创建线程
 */
public class ExtendThreadImpl extends Thread {
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程" + Thread.currentThread().getName()
                    + " ExtendThreadImpl运行了");
        }
    }
}
