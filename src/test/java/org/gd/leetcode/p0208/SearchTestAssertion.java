package org.gd.leetcode.p0208;

import lombok.RequiredArgsConstructor;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @see StartsWithTestAssertion
 */
@RequiredArgsConstructor
class SearchTestAssertion implements TestAssertion {

    private final String word;
    private final boolean expected;

    @Override
    public void doAssert(Trie trie) {
        if (expected) {
            assertTrue(trie.search(word), this::toString);
        } else {
            assertFalse(trie.search(word), this::toString);
        }
    }

    @Override
    public String toString() {
        if (expected)
            return String.format("trie must contain the word \"%s\"", word);
        return String.format("trie must not contain the word \"%s\"", word);
    }
}
