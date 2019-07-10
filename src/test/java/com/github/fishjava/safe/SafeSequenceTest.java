package com.github.fishjava.safe;

import org.junit.Test;

import static org.junit.Assert.*;

public class SafeSequenceTest {

    @Test
    public void getNext() throws Exception{
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    SafeSequence.getNext();
                }
            }).start();
        }
        Thread.sleep(200);

        // 如果没有锁问题的话，结果最后即通过应该是10 * 10000
        System.out.println(SafeSequence.value);
        // 48530
    }
}