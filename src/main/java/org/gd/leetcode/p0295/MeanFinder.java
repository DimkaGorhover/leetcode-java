package org.gd.leetcode.p0295;

@SuppressWarnings("WeakerAccess")
class MeanFinder {

    private Entry prev = Entry.ZERO;

    MeanFinder() {}

    void addNum(int num) { addNum((double) num); }

    void addNum(double num) { prev = prev.next(num); }

    double findMedian() { return prev.median; }

    static class Entry {

        static final Entry ZERO = new Entry(0, 0, 0);

        final double sum;
        final int count;
        final double median;

        Entry(double sum, int count) {
            this(sum, count, sum / count);
        }

        private Entry(double sum, int count, double median) {
            this.sum = sum;
            this.count = count;
            this.median = median;
        }

        Entry next(double num) {
            return new Entry(sum + num, count + 1);
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "sum=" + sum +
                    ", count=" + count +
                    ", median=" + median +
                    '}';
        }
    }
}
