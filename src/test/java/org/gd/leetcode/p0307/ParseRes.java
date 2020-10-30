package org.gd.leetcode.p0307;

/**
 * @author Horkhover D.
 * @since 2020-07-14
 */
class ParseRes<T> {

    final int nextIndex;
    final T res;

    ParseRes(int nextIndex, T res) {
        this.nextIndex = nextIndex;
        this.res = res;
    }
}
