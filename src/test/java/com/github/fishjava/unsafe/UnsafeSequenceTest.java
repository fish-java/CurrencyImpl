package com.github.fishjava.unsafe;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UnsafeSequenceTest {

    @Test
    public void getNext() throws Exception{
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    UnsafeSequence.getNext();
                    //System.out.println(UnsafeSequence.getNext());
                }
            }).start();
        }
        Thread.sleep(2000);

        // 如果没有锁问题的话，结果最后即通过应该是10 * 10000
        System.out.println(UnsafeSequence.value);
        // 48530
    }

    @Test
    public void getNextSafeValue() throws Exception{
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    UnsafeSequence.getNextSafeValue();
                }
            }).start();
        }
        Thread.sleep(2000);

        // 如果没有锁问题的话，结果最后即通过应该是10 * 10000
        System.out.println(UnsafeSequence.safeValue);
        // 100000
    }
}