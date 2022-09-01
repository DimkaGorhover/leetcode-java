package org.gd.leetcode.p0155;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link MinStack}
 *
 * @since 2019-09-10
 */
@DisplayName("LeetCode #155: Min Stack")
@Timeout(value = 50, unit = TimeUnit.MILLISECONDS)
class MinStackTest {

    private static Stream<MinStackFactory> args() {
        return Stream.of(
                new PriorityQueueArrayMinStackFactory(),
                new LinkedStackFactory()
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("LeetCode #155: Min Stack")
    void test(MinStackFactory minStackFactory) {
        
        MinStack minStack = minStackFactory.create();
        
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        
        assertEquals(-3, minStack.getMin());
        
        minStack.pop();
        
        assertEquals(0, minStack.top());
        assertEquals(-2, minStack.getMin());

    }

}