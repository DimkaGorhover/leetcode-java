package org.gd.hackerrank.other;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Test for {@link MissingNumbers}
 *
 * @since 2019-09-23
 */
class MissingNumbersTest {

    private static int readInt(BufferedReader reader) throws IOException {
        int read, sum = 0;
        while ((read = reader.read()) != ' ' && read != '\n' && read != -1)
            sum = sum * 10 + (read - '0');
        return sum;
    }

    private static int[] readInts(BufferedReader reader, int length) throws IOException {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++)
            arr[i] = readInt(reader);
        return arr;
    }

    private static Arguments fileTestCase(String fileName) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(MissingNumbersTest.class.getResourceAsStream(fileName)))) {
            int[] arr = readInts(reader, Integer.parseInt(reader.readLine()));
            int[] brr = readInts(reader, Integer.parseInt(reader.readLine()));
            int[] expected = readInts(reader, Integer.parseInt(reader.readLine()));
            return arguments(arr, brr, expected);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Stream<Arguments> args() {
        return Stream.of(
                fileTestCase("input01.txt"),
                fileTestCase("input02.txt"));
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("MissingNumbers")
    void test_MissingNumbers(int[] arr, int[] brr, int[] expected) {
        int[] actual = MissingNumbers.missingNumbers(arr, brr);
        assertArrayEquals(expected, actual);
    }
}