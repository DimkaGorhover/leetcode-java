package org.gd.leetcode.p0118;

import org.gd.leetcode.common.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle/
 *
 * @see org.gd.leetcode.p0119.Solution
 */
@SuppressWarnings({"JavadocReference", "unchecked"})
@LeetCode(difficulty = LeetCode.Level.EASY, tags = LeetCode.Tags.ARRAY)
class Solution {

    private static final List<Integer>[] LINES;
    private static final List<List<Integer>>[] CACHE;

    static {

        LINES = new List[]{
                Collections.singletonList(1),
                Arrays.asList(1, 1),
                Arrays.asList(1, 2, 1),
                Arrays.asList(1, 3, 3, 1),
                Arrays.asList(1, 4, 6, 4, 1),
                Arrays.asList(1, 5, 10, 10, 5, 1),
                Arrays.asList(1, 6, 15, 20, 15, 6, 1),
                Arrays.asList(1, 7, 21, 35, 35, 21, 7, 1)
        };

        CACHE = new List[LINES.length];
        CACHE[0] = Collections.singletonList(LINES[0]);
        for (int i = 1; i < CACHE.length; i++) {
            List<List<Integer>> list = new ArrayList<>(CACHE[i - 1].size() + 1);
            list.addAll(CACHE[i - 1]);
            list.add(LINES[i]);
            CACHE[i] = Collections.unmodifiableList(list);
        }
    }

    public List<List<Integer>> generate(int numRows) {
        if ((numRows = Math.max(0, numRows)) == 0) {
            return Collections.emptyList();
        }
        if (numRows < CACHE.length)
            return CACHE[numRows - 1];

        final List<List<Integer>> integers = new ArrayList<>(numRows);
        integers.addAll(CACHE[CACHE.length - 1]);

        int levelLength;
        List<Integer> prevLevel, currentLevel;
        for (int i = CACHE.length; i < numRows; i++) {
            prevLevel = integers.get(i - 1);
            currentLevel = new ArrayList<>(levelLength = i + 1);
            integers.add(currentLevel);
            currentLevel.add(1);
            for (int j = 1; j < levelLength - 1; j++) {
                currentLevel.add(prevLevel.get(j - 1) + prevLevel.get(j));
            }
            currentLevel.add(1);
        }
        return integers;

    }
}
