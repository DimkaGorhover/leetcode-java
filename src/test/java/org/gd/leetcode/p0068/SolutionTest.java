package org.gd.leetcode.p0068;

import lombok.var;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover D.
 * @since 2020-07-05
 */
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(
                        new String[]{
                                "This", "is", "an", "example", "of", "text", "justification."
                        }, 16, java.util.Arrays.asList(
                                "This    is    an",
                                "example  of text",
                                "justification.  "
                        )),
                Arguments.of(
                        new String[]{
                                "What", "must", "be", "acknowledgment", "shall", "be"
                        }, 16, java.util.Arrays.asList(
                                "What   must   be",
                                "acknowledgment  ",
                                "shall be        "
                        )),
                Arguments.of(
                        new String[]{
                                "Science", "is", "what", "we", "understand", "well", "enough", "to", "explain",
                                "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"
                        }, 20, java.util.Arrays.asList(
                                "Science  is  what we",
                                "understand      well",
                                "enough to explain to",
                                "a  computer.  Art is",
                                "everything  else  we",
                                "do                  "
                        ))
        );
    }

    @SuppressWarnings({"CodeBlock2Expr"})
    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("FullJustify")
    void test_FullJustify(String[] words, int maxWidth, List<String> expected) {

        var actual = new Solution().fullJustify(words, maxWidth);

        assertEquals(expected.size(), actual.size());

        for (int i = 0; i < actual.size(); i++) {

            String actualLine = actual.get(i);
            String expectedLine = expected.get(i);

            final int actualLength = actualLine.length();
            assertEquals(maxWidth, actualLength, () -> {

                return String.format("line [%s] has wrong line length (%d != %d)",
                        actualLine, maxWidth, actualLength);
            });

            assertEquals(expectedLine, actualLine);
        }

        assertEquals(expected, actual);
    }
}