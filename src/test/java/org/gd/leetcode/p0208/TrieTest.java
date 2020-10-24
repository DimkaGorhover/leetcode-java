package org.gd.leetcode.p0208;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import javax.annotation.Nonnull;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Trie}
 *
 * @since 2019-09-24
 */
@DisplayName("LeetCode #208: Implement Trie (Prefix Tree)")
class TrieTest {

    private static List<Map.Entry<String, String>> rawTestCases(String fileName) {
        requireNonNull(fileName, "\"fileName\" cannot be null");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(TrieTest.class.getResourceAsStream(fileName)))) {

            String ops = reader.readLine();
            String values = reader.readLine();

            List<String> opsList = Arrays.stream((ops.substring(1, ops.length() - 1)).split(","))
                    .map(s -> s.substring(1, s.length() - 1))
                    .collect(Collectors.toList());

            List<String> valuesList = Arrays.stream(values.substring(1, values.length() - 1).split(","))
                    .map(s -> s.length() > 2 ? s.substring(2, s.length() - 2) : "")
                    .collect(Collectors.toList());

            assertEquals(opsList.size(), valuesList.size());

            List<Map.Entry<String, String>> map = new ArrayList<>(valuesList.size());
            for (int i = 0; i < valuesList.size(); i++)
                map.add(new AbstractMap.SimpleEntry<>(opsList.get(i), valuesList.get(i)));

            return map;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String generateRandomWord(int wordLength) {
        return ThreadLocalRandom.current().ints(wordLength, 'a', 'z')
                .mapToObj(code -> (char) code)
                .reduce(new StringBuilder(wordLength), StringBuilder::append, (sb, ignore) -> sb)
                .toString();
    }

    private static Stream<Arguments> args() {

        Stream<TestCase> stream0 = Stream.of("test_case_001.txt")
                .flatMap(fileName -> rawTestCases(fileName).stream())
                .flatMap(entry -> Stream.empty());

        String word0 = generateRandomWord(1 << 10);

        Stream<TestCase> stream1 = Stream.of(
                TestCase.of(
                        trie -> assertFalse(trie.search("apple")),
                        trie -> assertFalse(trie.startsWith("app")),
                        trie -> trie.insert("apple"),
                        trie -> assertThrows(Trie.ToLongWordException.class, () -> trie.insert(generateRandomWord(1 << 12))),
                        trie -> assertTrue(trie.search("apple")),
                        trie -> assertFalse(trie.search("app")),
                        trie -> assertTrue(trie.startsWith("app")),
                        trie -> trie.insert("app"),
                        trie -> assertTrue(trie.search("app")),
                        trie -> trie.insert("applezzz"),
                        trie -> trie.insert("zzz"),
                        trie -> assertTrue(trie.search("zzz")),
                        trie -> assertTrue(trie.startsWith("zzz")),
                        trie -> assertTrue(trie.startsWith("zz")),
                        trie -> trie.insert(word0),
                        trie -> assertTrue(trie.search(word0)),
                        trie -> assertTrue(trie.startsWith(word0.substring(0, word0.length() - 10))),
                        trie -> assertFalse(trie.search(word0.substring(1)))
                )
        );

        return Stream.concat(stream0, stream1);
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("main")
    void test_main(TestCase testCase) {
        final Trie trie = new Trie();
        for (TestAssertion assertion : testCase)
            assertion.doAssert(trie);
    }

    @FunctionalInterface
    interface TestAssertion {

        void doAssert(Trie trie);
    }

    @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
    static class TestCase implements Iterable<TestAssertion>, Arguments {

        private final List<TestAssertion> testAssertions;

        @Deprecated
        static TestCase of(List<Map.Entry<String, String>> entries) {
            requireNonNull(entries, "\"entry\" cannot be null");
            return new TestCase(Collections.emptyList());
        }

        @Nonnull
        static TestCase of(TestAssertion... arr) {
            requireNonNull(arr, "\"arr\" cannot be null");
            return new TestCase(Arrays.asList(arr));
        }

        @Nonnull
        @Override
        public Iterator<TestAssertion> iterator() {
            return testAssertions.iterator();
        }

        @Override
        public Object[] get() { return new Object[]{this}; }
    }
}