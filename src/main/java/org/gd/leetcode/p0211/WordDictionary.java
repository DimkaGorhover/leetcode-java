package org.gd.leetcode.p0211;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/add-and-search-word-data-structure-design/
 *
 * @see org.gd.leetcode.p0208.Trie
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Add and Search Word - Data structure design",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.DESIGN,
                LeetCode.Tags.BACKTRACKING,
                LeetCode.Tags.TRIE
        })
class WordDictionary {

    private final WordDictionaryProvider provider;

    public WordDictionary() {
        provider = new ToLowerCaseWordDictionaryProvider(
                new FastCacheWordDictionaryProvider(new HashMapWordDictionaryProvider()));
    }

    public void addWord(String word) {
        provider.addWord(word);
    }

    public boolean search(String word) {
        return provider.search(word);
    }

    // ===== WordDictionaryProvider ===========================================

    interface WordDictionaryProvider {

        void addWord(String word);

        boolean search(String word);
    }

    // ===== To Lower Case ====================================================

    static class ToLowerCaseWordDictionaryProvider implements WordDictionaryProvider {

        private final WordDictionaryProvider provider;

        ToLowerCaseWordDictionaryProvider(WordDictionaryProvider provider) {
            if (provider == null)
                throw new NullPointerException();

            this.provider = provider;
        }

        @Override
        public void addWord(String word) {
            if (word != null)
                word.toLowerCase();

            provider.addWord(word);
        }

        @Override
        public boolean search(String word) {
            if (word != null)
                word.toLowerCase();

            return provider.search(word);
        }
    }

    // ===== Fast Cache =======================================================

    static class FastCacheWordDictionaryProvider implements WordDictionaryProvider {

        private final Set<String> fastCache = new HashSet<>();

        private final WordDictionaryProvider provider;

        FastCacheWordDictionaryProvider(WordDictionaryProvider provider) {
            if (provider == null)
                throw new NullPointerException();

            this.provider = provider;
        }

        @Override
        public void addWord(String word) {
            if (word != null && !word.isEmpty())
                fastCache.add(word);

            provider.addWord(word);
        }

        @Override
        public boolean search(String word) {
            return fastCache.contains(word) || provider.search(word);
        }
    }

    // ===== Hash Map =========================================================

    static class HashMapWordDictionaryProvider implements WordDictionaryProvider {

        private final HashMap<Integer, Set<String>> storage = new HashMap<>();

        @Override
        public void addWord(String word) {
            int index = word.length();
            Set<String> set = storage.get(index);
            if (set == null) {
                storage.put(index, set = new HashSet<>());
            }
            set.add(word);
        }

        @Override
        public boolean search(String word) {
            if (word == null)
                return false;

            Set<String> target = storage.get(word.length());
            if (target == null)
                return false;

            if (target.contains(word))
                return true;

            for (String saved : target) {
                if (isEqual(saved, word))
                    return true;
            }
            return false;

        }

        private static boolean isEqual(String saved, String target) {
            for (int i = 0, n = saved.length(); i < n; i++) {
                char c = target.charAt(i);
                if (c != '.' && saved.charAt(i) != c)
                    return false;
            }
            return true;
        }

    }

    // ===== Trie =============================================================

    /**
     * @deprecated uses too much memory
     */
    @Deprecated
    static class TrieWordDictionaryProvider implements WordDictionaryProvider {

        private static final int NODES_LENGTH = ('z' - 'a') + 1;

        private final Node root = new Node((char) 0);

        TrieWordDictionaryProvider() {
        }

        @Override
        public void addWord(String word) {
            if (word == null || word.isEmpty())
                return;

            int n = word.length();
            Node node = root;
            int i = 0;
            while (i < n && node != null) {
                char c = word.charAt(i);
                node = node.insertChild(c);
                i++;
            }
            node.markAsWord();
        }

        @Override
        public boolean search(String word) {
            if (word == null || word.isEmpty())
                return false;

            int n = word.length();
            List<Node> nodes = root.asList();
            int i = 0;

            while (i < n) {

                if (nodes.isEmpty())
                    return false;

                List<Node> nextNodes = new ArrayList<>();
                for (Node node : nodes) {
                    char c = word.charAt(i);
                    nextNodes.addAll(node.getChild(c));
                }

                nodes = nextNodes;
                if (nodes.isEmpty())
                    return false;

                i++;
            }

            for (Node node : nodes) {
                if (node.isWord())
                    return true;
            }

            return false;
        }

        static class Node {

            private final char c;

            private boolean word = false;
            private Node[] children;
            private ArrayList<Node> childrenSet = new ArrayList<>();

            Node(char c) {
                this.c = c;
            }

            void markAsWord() {
                word = true;
            }

            boolean isWord() {
                return word;
            }

            long size() {
                long sum = 1;
                for (Node node : childrenSet)
                    sum += node.size();
                return sum;
            }

            List<Node> getChild(char c) {
                if (childrenSet.isEmpty())
                    return Collections.emptyList();

                if (c == '.')
                    return Collections.unmodifiableList(childrenSet);

                Node node = children[c - 'a'];
                if (node == null)
                    return Collections.emptyList();

                return node.asList();
            }

            Node insertChild(char c) {

                if (children == null)
                    children = new Node[NODES_LENGTH];

                int index = c - 'a';
                Node child = children[index];

                if (child == null)
                    childrenSet.add(children[index] = child = new Node(c));

                return child;
            }

            List<Node> asList() {
                return Collections.singletonList(this);
            }

            @Override
            public String toString() {
                return String.format("{ %s (%d) }", (String.valueOf(c)), size());
            }
        }
    }
}