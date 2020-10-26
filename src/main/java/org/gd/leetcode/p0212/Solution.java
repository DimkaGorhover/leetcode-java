package org.gd.leetcode.p0212;

import org.gd.leetcode.common.LeetCode;

import java.util.*;

/**
 * https://leetcode.com/problems/word-search-ii/
 *
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0079.Solution
 * @see org.gd.leetcode.p0208.Trie
 * @since 2020-10-25
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Word Search II",
        difficulty = LeetCode.Level.HARD,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.BACKTRACKING,
                LeetCode.Tags.TRIE
        }
)
class Solution {

    private static final char VISITED = 0;

    private char[][] board;
    private int rows, cols;
    private List<String> result;

    private Trie next(final Trie trie, int row, int col) {
        if (row >= 0 && row < rows && col >= 0 && col < cols && board[row][col] != VISITED) {
            return trie.next(board[row][col]);
        }
        return null;
    }

    private void search(final Trie trie, final int row, final int col) {
        if (trie.word != null) {
            result.add(trie.word);
            trie.word = null;
        }

        Trie next;

        // up
        if ((next = next(trie, row - 1, col)) != null) {
            char c = board[row - 1][col];
            board[row - 1][col] = VISITED;
            search(next, row - 1, col);
            board[row - 1][col] = c;
        }

        // down
        if ((next = next(trie, row + 1, col)) != null) {
            char c = board[row + 1][col];
            board[row + 1][col] = VISITED;
            search(next, row + 1, col);
            board[row + 1][col] = c;
        }

        // left
        if ((next = next(trie, row, col - 1)) != null) {
            char c = board[row][col - 1];
            board[row][col - 1] = VISITED;
            search(next, row, col - 1);
            board[row][col - 1] = c;
        }

        // right
        if ((next = next(trie, row, col + 1)) != null) {
            char c = board[row][col + 1];
            board[row][col + 1] = VISITED;
            search(next, row, col + 1);
            board[row][col + 1] = c;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {

        if ((this.board = board) == null || (rows = board.length) == 0 || (cols = board[0].length) == 0 || words == null || words.length == 0)
            return Collections.emptyList();

        result = new ArrayList<>(Math.max(1 << 4, words.length >> 1));
        final Trie trie = new Trie();
        for (String word : words)
            trie.insert(word);

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char c = board[row][col];
                Trie next = trie.next(c);
                board[row][col] = VISITED;
                if (next != null)
                    search(next, row, col);
                board[row][col] = c;
            }
        }

        return result;
    }

    static class Trie {

        private static final int NODES_LENGTH = 'z' - 'a' + 1;

        private String word;
        private Trie[] children;
        private int minWordLength = Integer.MAX_VALUE;
        private int maxWordLength = 0;

        public Trie next(char c) {
            return children == null ? null : children[c - 'a'];
        }

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
            trie.word = word;
        }

        @Override
        public String toString() {
            List<String> words = new LinkedList<>();
            Queue<Trie> q = new LinkedList<>();
            q.add(this);
            Trie trie;
            while ((trie = q.poll()) != null) {
                if (trie.children == null)
                    continue;
                for (int i = 0; i < trie.children.length; i++) {
                    Trie child = trie.children[i];
                    if (child == null)
                        continue;
                    q.add(child);
                    if (child.word != null)
                        words.add(child.word);
                }
            }
            return words.toString();
        }
    }
}
