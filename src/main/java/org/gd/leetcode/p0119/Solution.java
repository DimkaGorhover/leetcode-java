package org.gd.leetcode.p0119;

import org.gd.leetcode.common.Difficulty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.gd.leetcode.common.Difficulty.Level.EASY;

/**
 * https://leetcode.com/problems/pascals-triangle-ii/
 *
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0118.Solution
 * @since 2018-12-21
 */
@Difficulty(EASY)
class Solution {

    private static final List<Integer>
            V_0 = Collections.singletonList(1),
            V_1 = Arrays.asList(1, 1),
            V_2 = Arrays.asList(1, 2, 1),
            V_3 = Arrays.asList(1, 3, 3, 1),
            V_4 = Arrays.asList(1, 4, 6, 4, 1),
            V_5 = Arrays.asList(1, 5, 10, 10, 5, 1);

    @SuppressWarnings("Duplicates")
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex < 0) return Collections.emptyList();
        switch (rowIndex) {
            case 0: return V_0;
            case 1: return V_1;
            case 2: return V_2;
            case 3: return V_3;
            case 4: return V_4;
            case 5: return V_5;
        }
        int           levelLength;
        List<Integer> prevLevel = V_5, currentLevel = prevLevel;
        for (int i = 6; i <= rowIndex; i++) {
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
