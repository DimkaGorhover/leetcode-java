package org.gd.leetcode.p0722;

import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.gd.leetcode.common.CollectionUtils.listOf;

/**
 * Test for {@see org.gd.leetcode.p0722.Solution}.
 *
 * @author Horkhover Dmytro
 * @see Solution
 * @since 2022-01-24
 */
@DisplayName("LeetCode #722: Remove Comments")
class SolutionTest {

    @NonNull
    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(
                        listOf(
                                "/*Test program */",
                                "int main()",
                                "{ ",
                                "  // variable declaration ",
                                "int a, b, c;",
                                "/* This is a test",
                                "   multiline  ",
                                "   comment for ",
                                "   testing */",
                                "a = b + c;",
                                "print('/* hello world  */')",
                                "print(\"/* hello world  */\")",
                                "}"),
                        listOf(
                                "int main()",
                                "{ ",
                                "  ",
                                "int a, b, c;",
                                "a = b + c;",
                                "print('')",
                                "print(\"\")",
                                "}"
                        )
                )
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Test for removeComments")
    @SneakyThrows
    void test_removeComments(List<String> source, List<String> expected) {
        val array = source.toArray(new String[0]);
        List<String> actual = new MySolution().removeComments(array);
        assertThat(actual).isEqualTo(expected);
    }
}