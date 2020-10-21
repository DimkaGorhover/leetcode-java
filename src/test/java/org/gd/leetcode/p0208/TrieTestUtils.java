package org.gd.leetcode.p0208;

import org.gd.common.IOUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

final class TrieTestUtils {

    private TrieTestUtils() { throw new UnsupportedOperationException(); }

    static String cleanupLine(String text) {
        if (text == null || text.isEmpty())
            return text;

        int length = text.length();
        char[] chars = new char[length];
        int j = 0;
        for (int i = 0; i < length; i++) {
            char c = text.charAt(i);
            if (c != '[' && c != ']' && c != '"')
                chars[j++] = c;
        }
        return new String(chars, 0, j);
    }

    static Stream<RawTestCaseEntry> rawTestCases(String fileName) {
        try (var reader = IOUtils.resource(TrieTestUtils.class, fileName)) {

            var ops = cleanupLine(reader.readLine());
            var values = cleanupLine(reader.readLine());
            var results = cleanupLine(reader.readLine());

            String[] opsList = ops.split(",");
            String[] valuesList = values.split(",");
            String[] resultsList = results.split(",");

            assertEquals(opsList.length, valuesList.length);
            assertEquals(opsList.length, resultsList.length);

            RawTestCaseEntry[] map = new RawTestCaseEntry[opsList.length];
            for (int i = 0; i < opsList.length; i++)
                map[i] = RawTestCaseEntry.builder()
                        .id(i)
                        .operation(TestCaseOperation.of(opsList[i]))
                        .value(valuesList[i])
                        .result(resultsList[i])
                        .build();

            return Arrays.stream(map);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static String generateRandomLongWord() {
        int length = ThreadLocalRandom.current().nextInt(1 << 8, 1 << 10);
        return generateRandomWord(length);
    }

    static String generateRandomWord(final int wordLength) {
        char[] chars = new char[wordLength];
        for (int i = 0; i < wordLength; i++) {
            char c = (char) ThreadLocalRandom.current().nextInt('a', 'z' + 1);
            chars[i] = c;
        }
        return new String(chars);
    }
}
