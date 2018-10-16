package org.gd.leetcode.p0002;

import java.util.Objects;

class ListNode {

    int      val;
    ListNode next;

    ListNode(int x) { val = x; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListNode)) return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val && Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        int result = val;
        result = 31 * result + (next != null ? next.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return val + (next == null ? "" : (", " + next));
    }
}
