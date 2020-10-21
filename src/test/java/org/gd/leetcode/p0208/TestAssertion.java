package org.gd.leetcode.p0208;

import lombok.NonNull;

interface TestAssertion {

    @NonNull
    static TestAssertion of(@NonNull RawTestCaseEntry entry) {
        return entry.getOperation().createTestAssertion(entry);
    }

    void doAssert(Trie trie);
}
