package com.github.fishjava.unsafe;

import com.github.fishjava.annotation.NotThreadSafe;
import com.github.fishjava.annotation.ThreadSafe;

public class UnsafeSequence {
    static int value;

    /**
     *     Code:
     *       stack=3, locals=0, args_size=0
     *          0: getstatic     #2                  // Field value:I
     *          3: dup
     *          4: iconst_1
     *          5: iadd
     *          6: putstatic     #2                  // Field value:I
     *          9: ireturn
     *
     * 从拿到值到修改值，中间有三个指令。
     * 这期间其他线程可能也在使用，导致线程不安全
     * @return
     */
    @NotThreadSafe
    public static int getNext(){
        return value++;
    }

    static int safeValue;

    /**
     *     Code:
     *       stack=3, locals=2, args_size=0
     *          0: ldc           #3                  // class com/github/fishjava/unsafe/UnsafeSequence
     *          2: dup
     *          3: astore_0
     *
     *          4: monitorenter
     *          5: getstatic     #4                  // Field safeValue:I
     *          8: dup
     *          9: iconst_1
     *         10: iadd
     *         11: putstatic     #4                  // Field safeValue:I
     *         14: aload_0
     *         15: monitorexit
     *
     *         16: ireturn
     *         17: astore_1
     *         18: aload_0
     *         19: monitorexit
     *         20: aload_1
     *         21: athrow
     *
     *  先锁定，再操作，可以线程安全
     * @return
     */
    @ThreadSafe
    public static int getNextSafeValue(){
        synchronized (UnsafeSequence.class){
            return safeValue++;
        }
    }
}