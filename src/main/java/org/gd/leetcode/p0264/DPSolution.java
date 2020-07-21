package org.gd.leetcode.p0264;

class DPSolution implements Solution {

    public int nthUglyNumber(int n) {
        if (n < 1) return 0;
        if (n < 7) return n;

        int i = 1;
        int[] ints = new int[n + 1];
        ints[0] = 1;

        int i2 = 0, i3 = 0, i5 = 0;

        while (i < n) {

            int v2 = ints[i2] * 2;
            int v3 = ints[i3] * 3;
            int v5 = ints[i5] * 5;

            final int value;

            if (v2 < v3) {
                if (v2 < v5) {
                    value = v2;
                    i2++;
                } else {
                    value = v5;
                    i5++;
                }
            } else {
                if (v3 < v5) {
                    value = v3;
                    i3++;
                } else {
                    value = v5;
                    i5++;
                }
            }

            if (ints[i - 1] != value)
                ints[i++] = value;
        }

        return ints[n - 1];
    }

    static class Entry implements Comparable<Entry> {

        private final int[] arr;
        private final int multiplier;
        private int index = 0;

        Entry(int[] arr, int multiplier) {
            this.arr = arr;
            this.multiplier = multiplier;
        }

        int peek() {
            return arr[index] * multiplier;
        }

        int next() {
            int value = peek();
            index++;
            return value;
        }

        @Override
        public int compareTo(Entry o) {
            return Integer.compare(peek(), o.peek());
        }
    }
}
