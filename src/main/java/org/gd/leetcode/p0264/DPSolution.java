package org.gd.leetcode.p0264;

class DPSolution implements Solution {

    private static int min(int v0, int v1, int v2) {
        return Math.min(v0, Math.min(v1, v2));
    }

    public int nthUglyNumber(int n) {
        if (n < 1) return 0;
        if (n < 7) return n;

        int[] ints = new int[n];
        ints[0] = 1;

        int i2 = 0, i3 = 0, i5 = 0;
        int v2 = 2, v3 = 3, v5 = 5;
        int i = 1;
        while (i < n) {
            int value = min(v2, v3, v5);
            if (ints[i - 1] != value)
                ints[i++] = value;

            if (value == v2) {
                v2 = ints[++i2] * 2;
            } else if (value == v3) {
                v3 = ints[++i3] * 3;
            } else if (value == v5) {
                v5 = ints[++i5] * 5;
            }
        }

        return ints[n - 1];
    }

}
