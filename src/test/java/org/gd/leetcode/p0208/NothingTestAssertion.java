package org.gd.leetcode.p0208;

class NothingTestAssertion implements TestAssertion {

    public static final NothingTestAssertion INSTANCE = new NothingTestAssertion();

    private NothingTestAssertion() {}

    @Override
    public void doAssert(Trie trie) {}

    @Override
    public String toString() { return "Do Nothing"; }
}
