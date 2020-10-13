package org.gd.leetcode.p0622;

import java.util.function.IntFunction;

interface MyCircularQueueFactory extends IntFunction<MyCircularQueue> {

    MyCircularQueue create(int capacity);

    @Override
    default MyCircularQueue apply(int value) {
        return create(value);
    }
}
