package org.gd.leetcode.p0729;

/**
 * @author Horkhover Dmytro
 * @since 2020-08-28
 */
class Interval implements Comparable<Interval> {

    private final int start, end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Interval later) {

        if (start > later.start) {
            int compare = later.compareTo(this);
            if (compare == 0)
                return compare;
        }


        System.out.println("asd 2");


        return 0;
    }

    @Override
    public String toString() {
        return String.format("[%d,%d]", start, end);
    }
}
