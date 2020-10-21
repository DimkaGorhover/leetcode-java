package org.gd.leetcode.p0208;

import lombok.RequiredArgsConstructor;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @see SearchTestAssertion
 */
@RequiredArgsConstructor
class StartsWithTestAssertion implements TestAssertion {

    private final String prefix;
    private final boolean expected;

    @Override
    public void doAssert(Trie trie) {
        if (expected) {
            assertTrue(trie.startsWith(prefix), this::toString);
        } else {
            assertFalse(trie.startsWith(prefix), this::toString);
        }
    }

    @Override
    public String toString() {
        if (expected)
            return String.format("trie must contain some words with prefix \"%s\"", prefix);
        return String.format("trie must not contain any words with prefix \"%s\"", prefix);
    }
}
