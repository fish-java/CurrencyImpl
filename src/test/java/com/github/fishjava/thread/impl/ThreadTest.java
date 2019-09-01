package com.github.fishjava.thread.impl;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 创建线程的两种方式
 */
public class ThreadTest {

    /**
     * 可以看到，两个线程交替的运行
     * @throws Exception
     */
    @Test
    public void run() throws Exception{
        new Thread(new RunnableImpl()).start();

        new ExtendThreadImpl().start();

        Thread.sleep(8000);
    }
}