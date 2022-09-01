package org.gd.leetcode.p0040;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test for {@link Solution}
 *
 * @see org.gd.leetcode.p0039.SolutionTest
 */
@SuppressWarnings("JavadocReference")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(
                        new int[]{10, 1, 2, 7, 6, 1, 5}, 8,
                        java.util.Arrays.asList(
                                java.util.Arrays.asList(1, 7),
                                java.util.Arrays.asList(1, 2, 5),
                                java.util.Arrays.asList(2, 6),
                                java.util.Arrays.asList(1, 1, 6)
                        ))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    void combinationSums(int[] candidates, int target, List<List<Integer>> expected) {

        var actual = new Solution().combinationSum2(candidates, target);

        assertEquals(expected.size(), actual.size());

        var executables = expected.stream()
                .map(new ContainsExecutableFactory(actual))
                .toArray(Executable[]::new);

        assertAll(executables);
    }

    @RequiredArgsConstructor(access = AccessLevel.PACKAGE)
    static class ContainsExecutableFactory implements Function<List<Integer>, Executable> {

        @NonNull
        private final List<List<Integer>> actual;

        @Override
        public Executable apply(@NonNull List<Integer> list) {
            return () -> assertTrue(actual.contains(list));
        }
    }
}
