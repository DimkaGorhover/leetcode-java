package org.gd.leetcode.p0824;

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
 * @since 2020-08-19
 */
@DisplayName("LeetCode #824: Goat Latin")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(

                Arguments.of(
                        "The quick brown fox jumped over the lazy dog",
                        "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"),

                Arguments.of(
                        "I speak Goat Latin",
                        "Imaa peaksmaaa oatGmaaaa atinLmaaaaa")
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("ToGoatLatin")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_ToGoatLatin(String text, String expected) {
        String actual = new Solution().toGoatLatin(text);
        assertEquals(expected, actual);
    }
}
