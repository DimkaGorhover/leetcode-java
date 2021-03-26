package org.gd.leetcode.p0055;

import org.gd.common.IOUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.gd.common.ArrayUtils.copy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0045.SolutionTest
 * @see org.gd.leetcode.p1306.SolutionTest
 * @since 2020-08-03
 */
@SuppressWarnings("JavadocReference")
@DisplayName("LeetCode #55: Jump Game")
@Timeout(value = 30, unit = TimeUnit.MILLISECONDS)
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

                Stream.of("test_case_001.txt")
                        .flatMap(SolutionTest::testCase)
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
    void test_NPE() {
        assertThrows(NullPointerException.class, () -> new Solution().canJump(null));
    }
}
