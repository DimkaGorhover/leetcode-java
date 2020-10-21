package org.gd.leetcode.p0208;

import lombok.RequiredArgsConstructor;

import static org.junit.jupiter.api.Assertions.*;

@RequiredArgsConstructor(staticName = "of")
class InsertTestAssertion implements TestAssertion {

    private final String word;

    @Override
    public void doAssert(Trie trie) {
        assertNotNull(trie);
        assertDoesNotThrow(() -> trie.insert(word), this::toString);
    }

    @Override
    public String toString() {
        return String.format("inserting word \"%s\"", word);
    }
}
