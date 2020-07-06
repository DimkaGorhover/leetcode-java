package org.gd.leetcode.p0990;

import org.gd.leetcode.common.BooleanAssertion;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 */
@Disabled
@DisplayName("LeetCode #990: satisfiability of equality equations")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new String[]{"a==z", "a==b", "b==c", "c==d", "b==y", "c==x", "d==w", "g==h", "h==i", "i==j", "a==g", "j!=y"}, false),
                Arguments.of(new String[]{"a==b", "b!=c", "c==a"}, false),
                Arguments.of(new String[]{"a==b", "b!=a"}, false),
                Arguments.of(new String[]{"b==a", "a==b"}, true),
                Arguments.of(new String[]{"c==c", "b==d", "x!=z"}, true)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("LeetCode #990: Satisfiability of Equality Equations")
    void equationsPossible(String[] equations, boolean expected) {

        boolean actual = new Solution().equationsPossible(equations);

        BooleanAssertion.of(expected).doAssert(actual);
    }

    @Test
    @DisplayName("LeetCode #990: Testing equals in inner classes")
    void eq() {

        Solution.Op ac = new Solution.Eq('a', 'c');
        Solution.Op ca = new Solution.Eq('c', 'a');
        Solution.Op cb = new Solution.Eq('c', 'b');

        assertEquals(ac, ca);
        assertEquals(ac.hashCode(), ca.hashCode());

        assertNotEquals(ac, cb);
        assertNotEquals(ac.hashCode(), cb.hashCode());

        ac = new Solution.Neq('a', 'c');
        ca = new Solution.Neq('c', 'a');
        cb = new Solution.Neq('c', 'b');

        assertEquals(ac, ca);
        assertEquals(ac.hashCode(), ca.hashCode());

        assertNotEquals(ac, cb);
        assertNotEquals(ac.hashCode(), cb.hashCode());
    }

    @Test
    @DisplayName("LeetCode #990: Testing LoggedOp")
    void logged() {

        Solution.Op ac = new Solution.Eq('a', 'c');
        Solution.Op ca = Solution.LoggedOp.of(new Solution.Eq('c', 'a'));

        assertEquals(ac, ca);
        assertEquals(ac.hashCode(), ca.hashCode());

        ac = new Solution.Neq('a', 'c');
        ca = Solution.LoggedOp.of(new Solution.Neq('c', 'a'));

        assertEquals(ac, ca);
        assertEquals(ac.hashCode(), ca.hashCode());
    }
}