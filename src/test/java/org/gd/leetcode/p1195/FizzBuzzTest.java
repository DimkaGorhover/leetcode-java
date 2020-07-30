package org.gd.leetcode.p1195;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableList;
import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Test for {@link FizzBuzz}
 *
 * @since 2019-09-19
 */
@DisplayName("LeetCode #1195: Fizz Buzz Multithreaded")
class FizzBuzzTest {

    private static List<String> generateExpectedList(int n) {
        final List<String> list = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0) {
                list.add((i % 5 == 0) ? "fizzbuzz" : "fizz");
            } else {
                list.add((i % 5 == 0) ? "buzz" : "" + i);
            }
        }
        return unmodifiableList(list);
    }

    private static Stream<Arguments> args() {
        return IntStream.of(16, 1 << 7, 1 << 14)
                .mapToObj(n -> arguments(n, generateExpectedList(n)));
    }

    private static Thread run(String name, TestRunnable runnable) {
        requireNonNull(name, "\"name\" cannot be null");
        requireNonNull(runnable, "\"runnable\" cannot be null");
        Thread thread = new Thread(() -> {
            try {
                runnable.run();
            } catch (Exception e) {
                System.err.println(e.toString());
                Thread.currentThread().interrupt();
            }
        });
        thread.setName(name);
        thread.start();
        return thread;
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Fizzbuzz")
    void test_Fizzbuzz(int n, List<String> expected) throws Exception {

        Queue<String> strings = new LinkedBlockingQueue<>();

        FizzBuzz fizzBuzz = new FizzBuzz(n);

        LinkedList<Thread> threads = new LinkedList<>(asList(
                run("fizz", () -> fizzBuzz.fizz(() -> strings.add("fizz"))),
                run("buzz", () -> fizzBuzz.buzz(() -> strings.add("buzz"))),
                run("fizzbuzz", () -> fizzBuzz.fizzbuzz(() -> strings.add("fizzbuzz"))),
                run("number", () -> fizzBuzz.number(number -> strings.add("" + number)))
        ));

        while (!threads.isEmpty())
            threads.removeLast().join();

        List<String> actual = new ArrayList<>(strings);

        assertEquals(expected, actual, () -> {
            String s1 = String.format("expected: %s%n", expected);
            String s2 = String.format("actual  : %s%n", actual);
            return s1 + s2;
        });

    }

    @FunctionalInterface
    interface TestRunnable {

        void run() throws Exception;
    }
}