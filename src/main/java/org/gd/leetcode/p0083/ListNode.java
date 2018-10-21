package org.gd.leetcode.p0083;

import lombok.EqualsAndHashCode;

/**
 * @author Gorkhover D.
 * @since 2018-10-21
 */
@EqualsAndHashCode(doNotUseGetters = true)
class ListNode {

    int      val;
    ListNode next;

    ListNode(int x) { val = x; }

    @Override
    public String toString() {
        return val + (next == null ? "" : " -> " + next);
    }
}
