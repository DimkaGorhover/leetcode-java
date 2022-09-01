package org.gd.leetcode.p0215;

import lombok.NonNull;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

/**
 * Test for {@see org.gd.leetcode.p0215.Solution}.
 *
 * @author Horkhover Dmytro
 * @see Solution
 * @since 2022-01-31
 */
@DisplayName("LeetCode #215: Kth Largest Element in an Array")
class SolutionTest {

    @NonNull
    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6}, 4, 5)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("SortSolution")
    @SneakyThrows
    void test_SortSolution(int[] arr, int k, int expected) {
        assertThat(new SortSolution().findKthLargest(arr, k)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("HeapSolution")
    @SneakyThrows
    void test_HeapSolution(int[] arr, int k, int expected) {
        assertThat(new HeapSolution().findKthLargest(arr, k)).isEqualTo(expected);
    }

    @SuppressWarnings("CodeBlock2Expr")
    @TestFactory
    @DisplayName("HeapSolution")
    @SneakyThrows
    Stream<DynamicTest> test_Nullability() {

        List<Supplier<Solution>> solutions = Arrays.asList(
                new Supplier<Solution>() {
                    @Override
                    public Solution get() {
                        return new SortSolution();
                    }

                    @Override
                    public String toString() {
                        return "SortSolution";
                    }
                },
                new Supplier<Solution>() {
                    @Override
                    public Solution get() {
                        return new HeapSolution();
                    }

                    @Override
                    public String toString() {
                        return "HeapSolution";
                    }
                }
        );


        return solutions.stream().flatMap(solution -> Stream.of(

                dynamicTest(solution + ": test if array is null", () -> {

                    assertThatThrownBy(() -> solution.get().findKthLargest(null, 2))
                            .isInstanceOf(NullPointerException.class)
                            .hasMessage("nums cannot be null");
                }),

                dynamicTest(solution + ": test if k less than zero", () -> {

                    assertThatThrownBy(() -> solution.get().findKthLargest(new int[]{1, 2, 3}, -1))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage("k cannot be less than 0");
                }),

                dynamicTest(solution + ": test if k is more than length of array", () -> {

                    assertThatThrownBy(() -> solution.get().findKthLargest(new int[]{1, 2, 3}, 3))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage("k cannot be more than length of array");
                })
        ));
    }
}
