package org.gd.leetcode.p0120;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * test for {@link Solution}
 */
@DisplayName("LeetCode #120: Triangle")
class SolutionTest {

    private static Stream<Arguments> args() {

        var solutions = Stream.of(
                new SolutionFactoryImpl(),
                new MemoSolutionFactory()
        );

        return solutions.flatMap(solutionFactory -> {

            return Stream.of(
                    Arguments.of(
                            solutionFactory,
                            List.of(
                                    List.of(2),
                                    List.of(3, 4),
                                    List.of(6, 5, 7),
                                    List.of(4, 1, 8, 3)
                            ), 11),
                    Arguments.of(solutionFactory, List.of(List.of(2)), 2),
                    Arguments.of(solutionFactory, List.of(), 0),
                    Arguments.of(solutionFactory, null, 0),
                    Arguments.of(
                            solutionFactory,
                            List.of(
                                    List.of(2),
                                    List.of(3, 4),
                                    List.of(4, 1, 8)
                            ), 6),
                    Arguments.of(
                            solutionFactory,
                            List.of(
                                    List.of(2),
                                    List.of(3, 4)
                            ), 5)
            );
        });

    }

    @ParameterizedTest
    @MethodSource("args")
    void minimumTotal(SolutionFactory solutionFactory, List<List<Integer>> triangle, int expected) {

        var solution = solutionFactory.create();

        int actual = solution.minimumTotal(mutable(triangle));

        assertEquals(expected, actual);
    }

    private static List<List<Integer>> mutable(List<List<Integer>> triangle) {

        if (triangle == null)
            return null;

        if (triangle.isEmpty())
            return Collections.emptyList();

        List<List<Integer>> list = new ArrayList<>(triangle.size());
        for (List<Integer> line : triangle)
            list.add(new ArrayList<>(line));

        return list;
    }

}