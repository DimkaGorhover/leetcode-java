package org.gd.leetcode.p0477;

import lombok.var;
import org.gd.leetcode.common.IOUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @since 2020-07-23
 */
@DisplayName("LeetCode #477: Total Hamming Distance")
class SolutionTest {

    private static int[] readTestCase(String testCaseName) {
        try (var resource = IOUtils.resource(SolutionTest.class, testCaseName)) {
            String[] split = resource.readLine().split(",");
            int[] nums = new int[split.length];
            for (int i = 0; i < split.length; i++) {
                nums[i] = Integer.parseInt(split[i]);
            }
            return nums;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(readTestCase("test_case_001.txt"), 748_425_216)
        );
    }

    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    @ParameterizedTest(name = "{displayName} #{index}")
    @MethodSource("args")
    @DisplayName("Solution")
    void test_Solution(int[] nums, int expected) {
        assertEquals(expected, new Solution().totalHammingDistance(nums));
    }

    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    @ParameterizedTest(name = "{displayName} #{index}")
    @MethodSource("args")
    @DisplayName("StreamSolution")
    void test_StreamSolution(int[] nums, int expected) {
        assertEquals(expected, new StreamSolution().totalHammingDistance(nums));
    }
}