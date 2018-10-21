package org.gd.leetcode.p0024;

import lombok.EqualsAndHashCode;

import static java.util.Objects.requireNonNull;

/**
 * @author Gorkhover D.
 * @since 2018-10-18
 */
@EqualsAndHashCode(doNotUseGetters = true)
class ListNode {
    int      val;
    ListNode next;

    ListNode(int x) { val = x; }

    static ListNode of(int... values) {
        requireNonNull(values, "values");
        ListNode root = new ListNode(values[0]), node = root, tmp;
        for (int i = 1; i < values.length; i++) {
            tmp = new ListNode(values[i]);
            node.next = tmp;
            node = tmp;
        }
        return root;

    }

    @Override
    public String toString() {
        return "{" + val + "}";
    }

    public String toPrettyString() {
        return "{" + val + "}" + (next == null ? "" : (" -> " + next.toPrettyString()));
    }
}
