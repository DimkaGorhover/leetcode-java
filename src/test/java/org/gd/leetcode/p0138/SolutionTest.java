package org.gd.leetcode.p0138;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @since 2020-08-16
 */
@DisplayName("LeetCode #138: Copy List with Random Pointer")
class SolutionTest {

    private static void assertNodes(Node expected, Node actual) {

        while (expected != null && actual != null) {

            assertNotSame(expected, actual);
            assertEquals(expected.val, actual.val);
            assertNotSame(expected.random, actual.random);
            assertEquals(expected.random.val, actual.random.val);

            expected = expected.next;
            actual = actual.next;
        }

        assertNull(expected);
        assertNull(actual);
    }

    @Test
    @DisplayName("CopyRandomList")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_CopyRandomList() {

        Node expected = Node.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        Node actual = new Solution().copyRandomList(expected);

        assertNodes(expected, actual);
    }
}
