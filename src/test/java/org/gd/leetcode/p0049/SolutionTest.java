package org.gd.leetcode.p0049;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(
                        new String[]{
                                "ron", "huh", "gay", "tow", "moe", "tie", "who", "ion", "rep", "bob", "gte",
                                "lee", "jay", "may", "wyo", "bay", "woe", "lip", "tit", "apt", "doe", "hot",
                                "dis", "fop", "low", "bop", "apt", "dun", "ben", "paw", "ere", "bad", "ill",
                                "fla", "mop", "tut", "sol", "peg", "pop", "les"
                        },
                        List.of(
                                List.of("pop"), List.of("peg"), List.of("fla"), List.of("ill"), List.of("bad"),
                                List.of("tut"), List.of("ere"), List.of("paw"), List.of("sol"), List.of("dun"),
                                List.of("bop"), List.of("low"), List.of("dis"), List.of("bob"), List.of("rep"),
                                List.of("woe"), List.of("ion"), List.of("mop"), List.of("tie"), List.of("wyo"),
                                List.of("tit"), List.of("les"), List.of("who"), List.of("fop"), List.of("hot"),
                                List.of("ron"), List.of("gay"), List.of("gte"), List.of("moe"), List.of("lee"),
                                List.of("huh"), List.of("lip"), List.of("jay"), List.of("tow"), List.of("may"),
                                List.of("ben"), List.of("bay"), List.of("doe"), List.of("apt", "apt")
                        )
                )
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("LeetCode #49: Group Anagrams")
    void groupAnagrams(String[] strings, List<List<String>> expected) {

        List<List<String>> actual = new Solution().groupAnagrams(strings);

        assertEquals(toSet(expected), toSet(actual));
    }

    private static Set<Set<String>> toSet(List<List<String>> strings) {
        return strings.stream()
                .map(HashSet::new)
                .collect(Collectors.toSet());
    }
}