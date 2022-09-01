package org.gd.leetcode.p1032;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test for {@link StreamChecker}
 *
 * @author Horkhover Dmytro
 * @since 2020-08-23
 */
@DisplayName("LeetCode #1032: Stream of Characters")
class StreamCheckerTest {

    @Test
    @DisplayName("Query")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_Query() {

        StreamChecker streamChecker = new StreamChecker(new String[]{"cd", "f", "kl"});
        assertFalse(streamChecker.query('a'));          // return false
        assertFalse(streamChecker.query('b'));          // return false
        assertFalse(streamChecker.query('c'));          // return false
        assertTrue(streamChecker.query('d'));           // return true, because 'cd' is in the wordlist
        assertFalse(streamChecker.query('e'));          // return false
        assertTrue(streamChecker.query('f'));           // return true, because 'f' is in the wordlist
        assertFalse(streamChecker.query('g'));          // return false
        assertFalse(streamChecker.query('h'));          // return false
        assertFalse(streamChecker.query('i'));          // return false
        assertFalse(streamChecker.query('j'));          // return false
        assertFalse(streamChecker.query('k'));          // return false
        assertTrue(streamChecker.query('l'));           // return true, because 'kl' is in the wordlist
    }
}
