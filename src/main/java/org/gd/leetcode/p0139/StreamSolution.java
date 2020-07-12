package org.gd.leetcode.p0139;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

// FIXME: extremely slow
@Deprecated
class StreamSolution extends Solution {

    private Map<Integer, Set<String>> groupByLength;
    private int[] lengths;
    private int maxLength;
    private int minLength;

    private void resetDict(List<String> wordDict) {
        maxLength = 0;
        minLength = Integer.MAX_VALUE;
        Set<Integer> lengths = new TreeSet<>(Comparator.comparingInt(value -> -value));
        groupByLength = new HashMap<>();

        for (String word : wordDict) {
            final int length = word.length();
            lengths.add(length);
            maxLength = Math.max(maxLength, length);
            minLength = Math.min(minLength, length);
            groupByLength.compute(length, (ignore, set) -> {
                if (set == null)
                    return Collections.singleton(word);
                if (set.size() == 1) {
                    set = new HashSet<>(set);
                }
                set.add(word);
                return set;
            });
            this.lengths = new int[lengths.size()];
            int i = 0;
            for (int value : lengths) {
                this.lengths[i++] = value;
            }
        }
    }

    private Stream<String> sss(final String word) {

        final int wordLength = word.length();

        if (word.length() == 0)
            return Stream.of("");

        return Arrays.stream(lengths)
                .parallel()
                .filter(length -> length <= wordLength)
                .mapToObj(length -> {
                    String leftSubstring = word.substring(0, length);
                    if (groupByLength.get(length).contains(leftSubstring)) {
                        return sss(word.substring(length)).parallel();
                    }
                    return Stream.<String>empty().parallel();
                })
                .flatMap(Function.identity());

    }

    public boolean wordBreak(String s, List<String> wordDict) {
        resetDict(wordDict);
        return sss(s).anyMatch(String::isEmpty);
    }
}
