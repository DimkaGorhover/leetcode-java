package org.gd.leetcode.p0055;

import org.gd.common.IOUtils;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.gd.common.ArrayUtils.copy;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @since 2020-08-03
 */
@DisplayName("LeetCode #55: Jump Game")
@Timeout(value = 50, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    private static Stream<Arguments> testCase(String fileName) {
        return Stream.of(fileName).map(name -> {
            try (var resource = IOUtils.resource(SolutionTest.class, name)) {

                int[] nums = Arrays.stream(resource.readLine().split(","))
                        .mapToInt(Integer::parseInt)
                        .toArray();

                boolean expected = Boolean.parseBoolean(resource.readLine());

                return Arguments.of(nums, expected);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private static Stream<Arguments> args() {
        return Stream.concat(

                Stream.of(
                        Arguments.of(new int[]{0}, true),
                        Arguments.of(new int[]{0, 2, 3}, false),
                        Arguments.of(new int[]{3, 2, 1, 0, 4}, false),
                        Arguments.of(new int[]{2, 3, 1, 1, 4}, true)),

                testCase("test_case_001.txt")
        );
    }

    @ParameterizedTest(name = "{displayName} #{index}")
    @MethodSource("args")
    @DisplayName("CanJump")
    void test_CanJump(int[] nums, boolean expected) {
        assertEquals(expected, new Solution().canJump(copy(nums)));
    }

    @Test
    @DisplayName("NPE")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_NPE() {
        assertThrows(NullPointerException.class, () -> new Solution().canJump(null));
    }
}
