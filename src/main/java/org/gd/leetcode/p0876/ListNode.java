package org.gd.leetcode.p0876;

class ListNode {

    int      val;
    ListNode next;

    ListNode(int x) { val = x; }

    static ListNode of(int... ints) {
        final ListNode root = new ListNode(ints[0]);
        ListNode node = root, tmp;
        for (int i = 1; i < ints.length; i++) {
            tmp = new ListNode(ints[i]);
            node.next = tmp;
            node = tmp;
        }
        return root;
    }

    @Override
    public String toString() {
        return "{" + val + "}" + (next == null ? "" : (" -> " + next));
    }
}
