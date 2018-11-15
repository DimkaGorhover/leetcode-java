package org.gd.leetcode.common;

import org.junit.jupiter.api.*;

/**
 * @author Horkhover Dmytro
 * @since 2018-11-15
 */
@FunctionalInterface
public interface BooleanAssertion {

    static BooleanAssertion of(boolean b) {
        return b ? Assertions::assertTrue : Assertions::assertFalse;
    }

    void doAssert(boolean res);
}
