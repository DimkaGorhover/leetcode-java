package org.gd.leetcode.p0208;

import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test for {@link Trie}
 *
 * @since 2019-09-24
 */
@DisplayName("LeetCode #208: Implement Trie (Prefix Tree)")
class TrieTest {

    @SuppressWarnings("CodeBlock2Expr")
    private static Stream<Arguments> fileTestCasesArguments() {

        val testCasesFileNames = Arrays.asList(
                "test_case_001.txt",
                "test_case_002.txt",
                "test_case_003.txt",
                "test_case_004.txt"
        );

        return testCasesFileNames.stream()
                .map(fileName -> {
                    return TrieTestUtils.rawTestCases(fileName)
                            .map(TestAssertion::of)
                            .collect(Collectors.collectingAndThen(
                                    Collectors.toList(),
                                    testAssertions -> new TestCase(fileName, testAssertions)));
                });
    }

    private static Stream<Arguments> customManualArguments() {
        String word0 = TrieTestUtils.generateRandomLongWord();
        return Stream.of(
                new TestCase("custom", Arrays.asList(
                        trie -> assertFalse(trie.search("apple")),
                        trie -> assertFalse(trie.search(TrieTestUtils.generateRandomLongWord())),
                        trie -> assertFalse(trie.search(TrieTestUtils.generateRandomLongWord())),
                        trie -> assertFalse(trie.search(TrieTestUtils.generateRandomLongWord())),
                        trie -> assertFalse(trie.startsWith("app")),
                        InsertTestAssertion.of("apple"),
                        InsertTestAssertion.of(null),
                        InsertTestAssertion.of(""),
                        new StartsWithTestAssertion("", true),
                        //trie -> assertThrows(Trie.ToLongWordException.class, () -> trie.insert(TrieTestUtils.generateRandomWord(1 << 12))),
                        new SearchTestAssertion("apple", true),
                        trie -> assertFalse(trie.search("app")),
                        trie -> assertTrue(trie.startsWith("app")),
                        InsertTestAssertion.of("app"),
                        new SearchTestAssertion("app", true),
                        trie -> assertFalse(trie.search("appa")),
                        trie -> assertFalse(trie.search("appab")),
                        InsertTestAssertion.of("applezzz"),
                        InsertTestAssertion.of("zzz"),
                        new SearchTestAssertion("zzz", true),
                        trie -> assertTrue(trie.startsWith("zzz")),
                        trie -> assertTrue(trie.startsWith("zz")),
                        InsertTestAssertion.of(word0),
                        new SearchTestAssertion(word0, true),
                        trie -> assertTrue(trie.startsWith(word0.substring(0, word0.length() - 10))),
                        trie -> assertFalse(trie.search(word0.substring(1)))
                ))
        );
    }

    private static Stream<Arguments> args() {
        return Stream.concat(
                fileTestCasesArguments(),
                customManualArguments());
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("main")
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    void test_main(TestAssertion testCase) {
        assertNotNull(testCase);
        testCase.doAssert(new Trie());
    }
}
