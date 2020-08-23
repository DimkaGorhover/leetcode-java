package org.gd.leetcode.p1023;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

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
                        List.of(true, true, true, true, true, true)),

                Arguments.of(
                        strings, "FoBaT",
                        List.of(false, true, false, false, false)),

                Arguments.of(
                        strings, "FoBa",
                        List.of(true, false, true, false, false)),

                Arguments.of(
                        strings, "FB",
                        List.of(true, false, true, true, false))
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
