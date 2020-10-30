package org.gd.leetcode.p0916;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover D.
 * @since 2020-07-11
 */
@DisplayName("LeetCode #916: Word Subsets")
class SolutionTest {

    private static Arguments fromFile(SolutionFactory solutionFactory, String fileName) {
        try (var resourceAsStream = SolutionTest.class.getResourceAsStream(fileName);
             var reader = new BufferedReader(new InputStreamReader(resourceAsStream))) {

            String[] A = reader.readLine().replaceAll("[\\[\\]\"\\s]", "").split(",");
            String[] B = reader.readLine().replaceAll("[\\[\\]\"\\s]", "").split(",");

            return Arguments.of(
                    solutionFactory,
                    A, B,
                    Arrays.stream(reader.readLine().replaceAll("[\\[\\]\"\\s]", "").split(","))
                            .map(String::trim)
                            .collect(Collectors.toList()));

        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private static Stream<Arguments> args() {

        return Stream.of(new HashMapQuotaSolutionFactory(), new MergeBSolutionFactory())
                .flatMap(solutionFactory -> {
                    return Stream.of(
                            fromFile(solutionFactory, "test_001.txt"),
                            Arguments.of(
                                    solutionFactory,
                                    new String[]{"amazon", "apple", "facebook", "google", "leetcode"},
                                    new String[]{"lo", "eo"},
                                    List.of("google", "leetcode")
                            ),
                            Arguments.of(
                                    solutionFactory,
                                    new String[]{"amazon", "apple", "facebook", "google", "leetcode"},
                                    new String[]{"e", "o"},
                                    List.of("facebook", "google", "leetcode")
                            ),
                            Arguments.of(
                                    solutionFactory,
                                    new String[]{"amazon", "apple", "facebook", "google", "leetcode"},
                                    new String[]{"l", "e"},
                                    List.of("apple", "google", "leetcode")
                            ),
                            Arguments.of(
                                    solutionFactory,
                                    new String[]{"amazon", "apple", "facebook", "google", "leetcode"},
                                    new String[]{"e", "oo"},
                                    List.of("facebook", "google")
                            )
                    );
                });
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("WordSubsets")
    void test_WordSubsets(SolutionFactory solutionFactory,
                          String[] A,
                          String[] B,
                          List<String> expected) {
        var actual = solutionFactory.create().wordSubsets(A, B);
        assertEquals(expected, actual);
    }


}
