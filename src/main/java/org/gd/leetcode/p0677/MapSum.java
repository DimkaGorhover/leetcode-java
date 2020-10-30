package org.gd.leetcode.p0677;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/map-sum-pairs/
 *
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0208.Trie
 * @since 2020-10-30
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Map Sum Pairs",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = LeetCode.Tags.TRIE
)
class MapSum {

    private final Trie rootTrie;

    public MapSum() {
        rootTrie = new Trie();
    }

    public void insert(String key, int val) {
        rootTrie.insert(key, val);
    }

    public int sum(String prefix) {
        Trie trie = rootTrie.searchTrie(prefix);
        return trie == null ? 0 : trie.sum();
    }

    static class Trie {

        private static final int NODES_LENGTH = 'z' - 'a' + 1;

        private int value = 0;
        private Trie[] children;

        int sum() {
            int sum = value;
            for (int i = 0; children != null && i < children.length; i++) {
                if (children[i] != null)
                    sum += children[i].sum();
            }
            return sum;
        }

        void insert(final String word, final int value) {
            if (word == null || word.isEmpty())
                return;

            final int wordLength = word.length();
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
            trie.value = value;
        }

        Trie searchTrie(String prefix) {
            if (prefix == null)
                return null;
            Trie trie = this;
            for (int i = 0, length = prefix.length(); i < length && trie != null; i++) {
                if (trie.children == null)
                    return null;
                trie = trie.children[prefix.charAt(i) - 'a'];
            }
            return trie;
        }
    }
}
