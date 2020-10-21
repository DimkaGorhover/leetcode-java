package org.gd.leetcode.p0208;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.params.provider.Arguments;

import javax.annotation.Nonnull;
import java.util.Iterator;
import java.util.List;

@RequiredArgsConstructor
class TestCase implements Iterable<TestAssertion>, Arguments, TestAssertion {

    private final String name;
    private final List<TestAssertion> testAssertions;

    @Override
    public void doAssert(Trie trie) {
        for (TestAssertion assertion : this)
            assertion.doAssert(trie);
    }

    @Nonnull
    @Override
    public Iterator<TestAssertion> iterator() {
        return testAssertions.iterator();
    }

    @Override
    public Object[] get() { return new Object[]{this}; }

    @Override
    public String toString() {
        return name + ". Test Assertions = " + testAssertions.size();
    }
}
