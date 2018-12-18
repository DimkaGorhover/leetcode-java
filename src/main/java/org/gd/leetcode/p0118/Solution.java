package org.gd.leetcode.p0118;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

/**
 * https://leetcode.com/problems/pascals-triangle/
 */
class Solution {

    private static final List<Integer>
            SINGLE_VALUE_LINE = singletonList(1),
            TWO_VALUE_LINE    = asList(1, 1),
            THREE_VALUE_LINE  = asList(1, 2, 1),
            FOUR_VALUE_LINE   = asList(1, 3, 3, 1);

    private static final List<List<Integer>>
            ZERO  = emptyList(),
            ONE   = singletonList(SINGLE_VALUE_LINE),
            TWO   = asList(SINGLE_VALUE_LINE, TWO_VALUE_LINE),
            THREE = asList(SINGLE_VALUE_LINE, TWO_VALUE_LINE, THREE_VALUE_LINE),
            FOUR  = asList(SINGLE_VALUE_LINE, TWO_VALUE_LINE, THREE_VALUE_LINE, FOUR_VALUE_LINE);

    public List<List<Integer>> generate(int numRows) {
        if (numRows < 0)
            return ZERO;
        switch (numRows) {
            case 0: return ZERO;
            case 1: return ONE;
            case 2: return TWO;
            case 3: return THREE;
            case 4: return FOUR;
        }
        final List<List<Integer>> integers = new ArrayList<>(numRows);
        integers.add(SINGLE_VALUE_LINE);
        integers.add(TWO_VALUE_LINE);
        integers.add(THREE_VALUE_LINE);

        int           levelLength;
        List<Integer> prevLevel, currentLevel;
        for (int i = 3; i < numRows; i++) {
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
