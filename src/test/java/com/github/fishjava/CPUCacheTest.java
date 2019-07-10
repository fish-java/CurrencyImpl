package com.github.fishjava;

import org.junit.Test;

public class CPUCacheTest {
    private static int arrLength = 3000;
    @Test
    public void cache(){
        long start = System.currentTimeMillis();
        int[][] arr = new int[arrLength][arrLength];
        for (int i = 0; i < arrLength; i++) {
            for (int j = 0; j < arrLength; j++) {
                arr[i][j] = 1;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        // 44
    }
    @Test
    public void nocache(){
        long start = System.currentTimeMillis();
        int[][] arr = new int[arrLength][arrLength];
        for (int i = 0; i < arrLength; i++) {
            for (int j = 0; j < arrLength; j++) {
                arr[j][i] = 1;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        // 102
    }
}
