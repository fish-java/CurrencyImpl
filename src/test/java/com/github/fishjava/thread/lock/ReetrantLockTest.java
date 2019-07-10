package com.github.fishjava.thread.lock;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReetrantLockTest {

    /**
     * 验证这个锁是可重入锁
     */
    @Test
    public void do2() {
        new ReetrantLock().do2();
    }
}