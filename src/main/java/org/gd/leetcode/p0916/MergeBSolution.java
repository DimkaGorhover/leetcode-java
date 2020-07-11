package org.gd.leetcode.p0916;

import org.gd.common.Repeat;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Horkhover D.
 * @since 2020-07-11
 */
@Repeat("this is not my solution :( ")
class MergeBSolution implements Solution {

    private static Stream<String> stream(String[] arr) {
        if (arr == null || arr.length == 0)
            return Stream.empty();
        if (arr.length == 1)
            return Stream.of(arr[0]);
        Stream<String> stream = Arrays.stream(arr);
        if (arr.length > (1 << 8))
            stream = stream.parallel();
        return stream;
    }

    public List<String> wordSubsets(String[] A, String[] B) {

        Subset reduce = stream(B)
                .map(Subset::new)
                .reduce(new Subset(null), Subset::reduce);

        return stream(A)
                .map(Subset::new)
                .filter(reduce)
                .map(Subset::getWord)
                .collect(Collectors.toList());
    }

    static class Subset implements Predicate<Subset> {

        private final int[] map = new int['z' - 'a' + 1];
        private final String word;

        Subset(String word) {
            this.word = word;
            if (word != null) {
                for (int i = 0; i < word.length(); i++) {
                    map[word.charAt(i) - 'a']++;
                }
            }
        }

        Subset reduce(Subset other) {
            if (other != null) {
                for (int i = 0; i < map.length; i++) {
                    map[i] = Math.max(map[i], other.map[i]);
                }
            }
            return this;
        }

        String getWord() { return word; }

        @Override
        public boolean test(Subset subset) {
            for (int i = 0; i < map.length; i++) {
                if (subset.map[i] < map[i]) {
                    return false;
                }
            }
            return true;
        }
    }
}
