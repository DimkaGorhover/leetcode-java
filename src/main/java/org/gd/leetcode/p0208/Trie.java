package org.gd.leetcode.p0208;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 *
 * @since 2019-09-24
 */
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

    private boolean isWord;
    private Trie[] children;
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
        Trie trie = this;
        for (int i = 0; i < wordLength; i++) {
            if (trie.children == null)
                trie.children = new Trie[NODES_LENGTH];
            int index = word.charAt(i) - 'a';
            Trie child = trie.children[index];
            if (child == null)
                trie.children[index] = child = new Trie();
            trie = child;
        }
        trie.isWord = true;
    }

    /**
     * @return {@code true} if the word is in the trie.
     */
    public boolean search(String word) {
        if (word == null || word.length() == 0 || children == null || minWordLength > word.length())
            return false;
        Trie trie = searchTrie(word);
        return trie != null && trie.isWord;
    }

    /**
     * @return {@code true} if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        if (prefix == null) return false;
        if (prefix.isEmpty()) return true;
        if (children == null) return false;
        return searchTrie(prefix) != null;
    }

    private Trie searchTrie(String prefix) {
        int length = prefix.length();
        if (length > maxWordLength)
            return null;
        Trie trie = this;
        for (int i = 0; i < length && trie != null; i++) {
            if (trie.children == null)
                return null;
            trie = trie.children[prefix.charAt(i) - 'a'];
        }
        return trie;
    }
}
