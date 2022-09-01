package org.gd.leetcode.p1032;

import org.gd.leetcode.common.Repeat;
import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/stream-of-characters/
 *
 * @since 2020-08-23
 */
@Repeat("stolen solution")
@LeetCode(
        name = "Stream of Characters",
        difficulty = LeetCode.Level.HARD,
        state = LeetCode.State.DONE,
        tags = LeetCode.Tags.TRIE
)
class StreamChecker {

    private final TrieNode root;
    private final StringBuilder sb;

    public StreamChecker(String[] words) {
        if (words != null) {
            root = new TrieNode();
            sb = new StringBuilder();
            for (String s : words) {
                TrieNode node = root;
                for (int len = s.length(), i = len - 1; i >= 0; i--)
                    node = node.appendNext(s.charAt(i));
                node.isWord = true;
            }
        } else {
            root = null;
            sb = null;
        }
    }

    public boolean query(char letter) {
        if (root == null)
            return false;

        sb.append(letter);
        TrieNode node = root;
        for (int i = sb.length() - 1; i >= 0 && node != null; i--)
            if ((node = node.next(sb.charAt(i))) != null && node.isWord)
                return true;

        return false;
    }

    static class TrieNode {

        boolean isWord;
        TrieNode[] child = new TrieNode[26];

        TrieNode() {}

        TrieNode appendNext(char letter) {
            TrieNode next = child[letter - 'a'];
            if (next == null)
                next = child[letter - 'a'] = new TrieNode();
            return next;
        }

        TrieNode next(char letter) {
            return child[letter - 'a'];
        }
    }
}
