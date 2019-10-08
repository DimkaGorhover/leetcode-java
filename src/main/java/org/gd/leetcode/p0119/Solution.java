package org.gd.leetcode.p0119;

import org.gd.leetcode.common.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle-ii/
 *
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0118.Solution
 * @since 2018-12-21
 */
@SuppressWarnings("JavadocReference")
@LeetCode(difficulty = LeetCode.Level.EASY, tags = LeetCode.Tags.ARRAY)
class Solution {

    private static final List[] CACHE = new List[]{
            Collections.singletonList(1),
            Arrays.asList(1, 1),
            Arrays.asList(1, 2, 1),
            Arrays.asList(1, 3, 3, 1),
            Arrays.asList(1, 4, 6, 4, 1),
            Arrays.asList(1, 5, 10, 10, 5, 1),
            Arrays.asList(1, 6, 15, 20, 15, 6, 1),
            Arrays.asList(1, 7, 21, 35, 35, 21, 7, 1)
    };

    @SuppressWarnings({"Duplicates", "unchecked"})
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex < 0)
            return Collections.emptyList();

        if (rowIndex < CACHE.length)
            return CACHE[rowIndex];

        int levelLength;
        List<Integer> prevLevel = CACHE[CACHE.length - 1], currentLevel = prevLevel;
        for (int i = CACHE.length; i <= rowIndex; i++) {
            currentLevel = new ArrayList<>(levelLength = i + 1);
            currentLevel.add(1);
            for (int j = 1; j < levelLength - 1; j++)
                currentLevel.add(prevLevel.get(j - 1) + prevLevel.get(j));
            currentLevel.add(1);
            prevLevel = currentLevel;
        }
        return currentLevel;
    }
}
