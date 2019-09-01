package com.github.fishjava.thread.impl;

/**
 * 通过实现Runnable接口的方式创建线程
 */
public class RunnableImpl implements Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程" + Thread.currentThread().getName()
                    + " RunnableImpl运行了");
        }
    }
}
