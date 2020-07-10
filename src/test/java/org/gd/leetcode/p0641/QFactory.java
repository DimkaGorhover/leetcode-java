package org.gd.leetcode.p0641;

import java.util.function.IntFunction;

interface QFactory extends IntFunction<MyCircularDeque> {

    MyCircularDeque create(int capacity);

    @Override
    default MyCircularDeque apply(int value) { return create(value); }
}
