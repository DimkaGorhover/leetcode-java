package org.gd.leetcode.p0211;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Test for {@link WordDictionary}
 */
@DisplayName("LeetCode #211: Word Dictionary")
class WordDictionaryTest {

    @Test
    @DisplayName("LeetCode #211: Word Dictionary (test #1)")
    void test001() {

        var dict = new WordDictionary();

        assertFalse(dict.search("a"));
        assertFalse(dict.search("abc"));

        dict.addWord("helloworld");
        dict.addWord("hecloworld");

        assertFalse(dict.search("hello"));

        assertFalse(dict.search("he.lo"));
        assertTrue(dict.search("helloworld"));
        assertTrue(dict.search("hell.world"));

        assertFalse(dict.search("helloname"));
    }

    @Test
    @DisplayName("LeetCode #211: Word Dictionary (test #2)")
    void test002() {

        var dict = new WordDictionary();

        dict.addWord("at");
        dict.addWord("and");
        dict.addWord("an");
        dict.addWord("add");

        assertFalse(dict.search("a"));
        assertFalse(dict.search(".at"));
        
        dict.addWord("bat");
        
        assertTrue(dict.search(".at"));
        assertTrue(dict.search("an."));
        assertFalse(dict.search("a.d."));

        assertFalse(dict.search("b."));
        assertTrue(dict.search("a.d"));
        assertFalse(dict.search("."));
    }

}