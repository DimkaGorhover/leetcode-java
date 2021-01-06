package org.gd.leetcode.p1117;

import lombok.NonNull;
import org.gd.common.Utils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test for {@link H2O}.
 *
 * @see SynchronizedH2O
 */
@DisplayName("LeetCode #1117: Building H2O")
@Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
class H2OTest {

    @NonNull
    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(
                        "HOH",
                        Set.of("HHO", "HOH", "OHH")),
                Arguments.of(
                        "OOHHHH",
                        Set.of("HOHHHO", "OHHHHO", "HHOHOH", "HOHHOH", "OHHHOH", "HHOOHH", "HOHOHH", "OHHOHH")),
                Arguments.of(
                        "OOHHHH",
                        Set.of("HOHHHO", "OHHHHO", "HHOHOH", "HOHHOH", "OHHHOH", "HHOOHH", "HOHOHH", "OHHOHH"))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Synchronized H2O Solution")
    void synchronizedSolution(String input, Set<String> expected) {
        String actual = doTest(new SynchronizedH2O(), input);
        assertThat(expected).contains(actual);
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Semaphore H2O Solution")
    void semaphoreSolution(String input, Set<String> expected) {
        String actual = doTest(new SemaphoreH2O(), input);
        assertThat(expected).contains(actual);
    }

    @NonNull
    private static String doTest(@NonNull H2O solution, @NonNull String input) {

        StringBuffer sb = new StringBuffer();

        Molecule.createThreads(input, solution, sb)
                .parallel()
                .peek(Thread::start)
                .collect(Collectors.toList())
                .forEach(thread -> Utils.run(thread::join));

        return sb.toString();
    }
}
