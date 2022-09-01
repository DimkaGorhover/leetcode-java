package org.gd.leetcode.p0208;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 *
 * @see org.gd.leetcode.p0212.Solution
 * @since 2019-09-24
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Implement Trie (Prefix Tree)",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.DESIGN,
                LeetCode.Tags.TRIE
        })
class Trie {

    private static final int NODES_LENGTH = 'z' - 'a' + 1;

    private Node root;
    private int minWordLength = Integer.MAX_VALUE;
    private int maxWordLength = 0;

    /**
     * Initialize your data structure here.
     */
    public Trie() {}

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (word == null || word.isEmpty())
            return;

        final int wordLength = word.length();
        minWordLength = Math.min(minWordLength, wordLength);
        maxWordLength = Math.max(maxWordLength, wordLength);

        Node trie = root;
        if (trie == null) {
            trie = root = new Node();
        }

        for (int i = 0; i < wordLength; i++) {
            if (trie.children == null) {
                trie.children = new Node[NODES_LENGTH];
            }
            int index = word.charAt(i) - 'a';
            Node child = trie.children[index];
            if (child == null) {
                trie.children[index] = child = new Node();
            }
            trie = child;
        }
        trie.isWord = true;
    }

    /**
     * @return {@code true} if the word is in the trie.
     */
    public boolean search(String word) {
        if (word == null || word.length() == 0 || root == null || root.children == null || minWordLength > word.length()) {
            return false;
        }
        Node trie = searchTrie(word);
        return trie != null && trie.isWord;
    }

    /**
     * @return {@code true} if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        if (prefix == null) return false;
        if (prefix.isEmpty()) return root != null;
        return searchTrie(prefix) != null;
    }

    private Node searchTrie(String prefix) {
        if (prefix == null) {
            return null;
        }
        int length = prefix.length();
        Node trie = root;
        if (trie == null || length > maxWordLength) {
            return null;
        }
        for (int i = 0; i < length && trie != null; i++) {
            if (trie.children == null) {
                return null;
            }
            trie = trie.children[prefix.charAt(i) - 'a'];
        }
        return trie;
    }

    static class Node {

        Node[] children;
        boolean isWord;
    }
}
