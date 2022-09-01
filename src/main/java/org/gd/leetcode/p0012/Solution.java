package org.gd.leetcode.p0012;

import org.gd.leetcode.common.LeetCode;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/integer-to-roman/
 *
 * @see org.gd.leetcode.p0013.Solution
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Integer to Roman",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.TODO,
        tags = {
                LeetCode.Tags.MATH,
                LeetCode.Tags.STRING
        }
)
class Solution {

    private static final List<Map<Character, Integer>> LIST = Arrays.asList(
            ofEntries(
                    entry('I', 1),
                    entry('V', 5),
                    entry('X', 10)),
            ofEntries(
                    entry('X', 10),
                    entry('L', 50),
                    entry('C', 100)),
            ofEntries(
                    entry('C', 100),
                    entry('D', 500),
                    entry('M', 1000))
    );

    private static final Map<Character, Integer> map = ofEntries(
            entry('I', 1),
            entry('V', 5),
            entry('X', 10),
            entry('L', 50),
            entry('C', 100),
            entry('D', 500),
            entry('M', 1000)
    );

    private static <K, V> Map<K, V> ofEntries(Map.Entry<K, V> ... entries) {
        Map<K, V> map = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : entries) {
            map.put(entry.getKey(), entry.getValue());
        }
        return map;
    }

    private static <K, V> Map.Entry<K, V> entry(K key, V value) {
        return new AbstractMap.SimpleImmutableEntry<>(key, value);
    }

    public String intToRoman(int num) {
        while (num > 0) {
            int next = num % 10;


            num /= 10;
        }

        throw new UnsupportedOperationException(new String(new char[]{ 175, 92, 95, 40, 12_484, 41, 95, 47, 175 }));
    }
}
