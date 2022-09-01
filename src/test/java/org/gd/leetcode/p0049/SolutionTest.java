package org.gd.leetcode.p0049;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
                        java.util.Arrays.asList(
                                java.util.Arrays.asList("pop"), java.util.Arrays.asList("peg"), java.util.Arrays.asList("fla"), java.util.Arrays.asList("ill"), java.util.Arrays.asList("bad"),
                                java.util.Arrays.asList("tut"), java.util.Arrays.asList("ere"), java.util.Arrays.asList("paw"), java.util.Arrays.asList("sol"), java.util.Arrays.asList("dun"),
                                java.util.Arrays.asList("bop"), java.util.Arrays.asList("low"), java.util.Arrays.asList("dis"), java.util.Arrays.asList("bob"), java.util.Arrays.asList("rep"),
                                java.util.Arrays.asList("woe"), java.util.Arrays.asList("ion"), java.util.Arrays.asList("mop"), java.util.Arrays.asList("tie"), java.util.Arrays.asList("wyo"),
                                java.util.Arrays.asList("tit"), java.util.Arrays.asList("les"), java.util.Arrays.asList("who"), java.util.Arrays.asList("fop"), java.util.Arrays.asList("hot"),
                                java.util.Arrays.asList("ron"), java.util.Arrays.asList("gay"), java.util.Arrays.asList("gte"), java.util.Arrays.asList("moe"), java.util.Arrays.asList("lee"),
                                java.util.Arrays.asList("huh"), java.util.Arrays.asList("lip"), java.util.Arrays.asList("jay"), java.util.Arrays.asList("tow"), java.util.Arrays.asList("may"),
                                java.util.Arrays.asList("ben"), java.util.Arrays.asList("bay"), java.util.Arrays.asList("doe"), java.util.Arrays.asList("apt", "apt")
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