package org.gd.leetcode.p1023;

import lombok.var;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @since 2020-08-23
 */
@DisplayName("LeetCode #1023: Camelcase Matching")
class SolutionTest {

    private static Stream<Arguments> args() {

        String[] strings = {"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"};

        return Stream.of(

                Arguments.of(
                        new String[]{
                                "aksvbjLiknuTzqon",
                                "ksvjLimflkpnTzqn",
                                "mmkasvjLiknTxzqn",
                                "ksvjLiurknTzzqbn",
                                "ksvsjLctikgnTzqn",
                                "knzsvzjLiknTszqn"},
                        "ksvjLiknTzqn",
                        java.util.Arrays.asList(true, true, true, true, true, true)),

                Arguments.of(
                        strings, "FoBaT",
                        java.util.Arrays.asList(false, true, false, false, false)),

                Arguments.of(
                        strings, "FoBa",
                        java.util.Arrays.asList(true, false, true, false, false)),

                Arguments.of(
                        strings, "FB",
                        java.util.Arrays.asList(true, false, true, true, false))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("CamelMatch")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_CamelMatch(String[] words, String pattern, List<Boolean> expected) {

        var actual = new Solution().camelMatch(words, pattern);

        assertEquals(expected.size(), actual.size());

        List<Executable> executables = new ArrayList<>(expected.size());

        for (int i = 0; i < expected.size(); i++) {
            final boolean matched = expected.get(i);
            if (matched != actual.get(i)) {
                final String word = words[i];
                executables.add(() -> fail(String.format(
                        "word [%s] should NOT %s to pattern [%s]",
                        word, (matched ? "match" : "NOT match"), pattern)));
            }
        }

        assertAll(executables);
    }
}
