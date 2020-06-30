package org.gd.leetcode.p0208;

import org.gd.leetcode.common.LeetCode;

import java.util.HashSet;
import java.util.Set;

import static java.util.Objects.requireNonNull;

/**
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 *
 * @since 2019-09-24
 */
@LeetCode(difficulty = LeetCode.Level.MEDIUM, tags = {LeetCode.Tags.DESIGN, LeetCode.Tags.TRIE})
class Trie {

    private static final int NODES_LENGTH = 'z' - 'a' + 1;
    private static final int WORD_MAX_LENGTH = 1 << 10;

    private final Set<String> containsSet = new HashSet<>();
    private final Node root = new Node((char) 0);

    /** Initialize your data structure here. */
    public Trie() {}

    private static void checkWord(String word) {
        requireNonNull(word, "\"word\" cannot be null");
        final int length = word.length();
        if (length > WORD_MAX_LENGTH)
            throw new ToLongWordException(length);
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        checkWord(word);
        containsSet.add(word);
        root.insert(word, 0);
    }

    /**
     * @return {@code true} if the word is in the trie.
     */
    public boolean search(String word) {
        return containsSet.contains(word);
    }

    /**
     * @return {@code true} if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return root.startsWith(prefix, 0);
    }

    static class ToLongWordException extends RuntimeException {

        private static final long serialVersionUID = 9060161481648923766L;

        ToLongWordException(int length) {
            super(String.format("max length: %d, current length: %d", WORD_MAX_LENGTH, length));
        }
    }

    static class Node {

        private final char c;

        private Node[] child;

        Node(char c) { this.c = c; }

        private static int index(char c) { return c - 'a'; }

        /**
         * @return {@code null} if child node doesn't exist
         */
        private Node findNode(char c) {
            return child == null ? null : child[index(c)];
        }

        /**
         * @return always return instance of child node
         */
        private Node getNode(char c) {
            if (child == null)
                child = new Node[NODES_LENGTH];
            Node node = child[index(c)];
            return node != null ? node : (child[index(c)] = new Node(c));
        }

        /**
         * FIXME: it may raise {@link StackOverflowError} because it's de facto recursion. Dirty fix is in {@link Trie#insert(String)}
         */
        void insert(String text, int index) {
            if (index < text.length())
                getNode(text.charAt(index)).insert(text, (index + 1));
        }

        /**
         * FIXME: it may raise {@link StackOverflowError} because it's de facto recursion. Dirty fix is in {@link Trie#insert(String)}
         */
        boolean startsWith(String prefix, int index) {
            final Node node;
            if (prefix == null || index >= prefix.length() || (node = findNode(prefix.charAt(index))) == null)
                return false;
            return (index == prefix.length() - 1) || node.startsWith(prefix, (index + 1));
        }

        @Override
        public String toString() { return "Node{ " + c + " }"; }
    }
}
