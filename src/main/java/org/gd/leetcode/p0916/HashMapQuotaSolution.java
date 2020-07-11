package org.gd.leetcode.p0916;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class HashMapQuotaSolution implements Solution {

    private static List<String> distinct(String[] words) {
        HashSet<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        for (String word : words) {
            if (set.contains(word))
                continue;
            set.add(word);
            list.add(word);
        }
        return list;
    }

    private static List<Subset> distinctSubsets(String[] words) {
        HashSet<String> set = new HashSet<>();
        List<Subset> list = new ArrayList<>();
        for (String word : words) {
            if (set.contains(word))
                continue;
            set.add(word);
            list.add(new Subset(word));
        }
        return list;
    }

    public List<String> wordSubsets(String[] A, String[] B) {

        return distinct(A).stream()
                .filter(new Subsets(B))
                .collect(Collectors.toList());
    }

    static class Subsets implements Predicate<String> {

        private final List<Subset> subsets;

        Subsets(String[] subsets) {
            this.subsets = distinctSubsets(subsets);
        }

        @Override
        public boolean test(String word) {
            for (Subset subset : subsets) {
                if (!subset.containsIn(word))
                    return false;
            }
            return true;
        }
    }

    static class Subset {

        private final char[] map;
        private final int count;

        Subset(String subset) {
            int count = 0;
            map = new char['z' - 'a' + 1];
            for (int i = 0; i < subset.length(); i++) {
                map[subset.charAt(i) - 'a']++;
                count++;
            }
            this.count = count;
        }

        boolean containsIn(String word) {

            int count = this.count;
            if (word == null || word.length() < count)
                return false;

            char[] map = Arrays.copyOf(this.map, this.map.length);

            for (int i = 0; i < word.length() && count > 0; i++) {
                int index = word.charAt(i) - 'a';
                int quota = map[index];
                if (quota == 0)
                    continue;
                map[index]--;
                count--;
            }

            return count == 0;
        }
    }
}
