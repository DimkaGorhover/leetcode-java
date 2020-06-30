package org.gd.leetcode.p0231;

import java.util.stream.Stream;

import org.gd.leetcode.common.BooleanAssertion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {
    
    static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(0, false),
                Arguments.of(-1, false),
                Arguments.of(2, true),
                Arguments.of(536870912, true),
                Arguments.of(3, false)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Is Power Of Two")
    void test(int n, boolean expected) {
        BooleanAssertion.of(expected).doAssert(new Solution().isPowerOfTwo(n));
    }
}
