package com.github.fishjava.safe;

import java.util.concurrent.atomic.AtomicInteger;

public class SafeSequence {
    protected static AtomicInteger value = new AtomicInteger(0);

    public static int getNext(){
        return value.getAndIncrement();
    }
}
