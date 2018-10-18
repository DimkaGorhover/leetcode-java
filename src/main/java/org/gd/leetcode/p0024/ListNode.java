package org.gd.leetcode.p0024;

import lombok.EqualsAndHashCode;

/**
 * @author Gorkhover D.
 * @since 2018-10-18
 */
@EqualsAndHashCode(doNotUseGetters = true)
class ListNode {
    int      val;
    ListNode next;

    ListNode(int x) { val = x; }

    @Override
    public String toString() {
        return "{" + val + "}";
    }

    public String toPrettyString() {
        return "{" + val + "}" + (next == null ? "" : (" -> " + next.toPrettyString()));
    }
}
