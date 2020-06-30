package org.gd.leetcode.p0338;

import org.gd.common.Repeat;

class DPSolution implements ISolution {

    @Override
    public int[] countBits(int num) {
        if (num < 0)
            throw new IllegalArgumentException();

        int[] countBits = new int[num + 1];
        for (int i = 1; i <= num; i++)
            countBits[i] = countBits[i >> 1] + (i & 1);

        return countBits;
    }
}
