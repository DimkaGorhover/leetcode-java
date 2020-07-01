package org.gd.leetcode.common;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) { val = x; }

    public static ListNode of(String values) {
        String[] strings = values.split("(->)|;|,|\\|");
        int[]    ints    = new int[strings.length];
        int      cursor  = 0;
        for (String string : strings) {
            try {
                int value = Integer.parseInt(string.trim());
                ints[cursor++] = value;
            } catch (NumberFormatException ignore) {}
        }
        return of(ints, 0, cursor);
    }

    public static ListNode of(int val) {
        return new ListNode(val);
    }

    public static ListNode of(int... ints) {
        return of(ints, 0, ints.length);
    }

    public static ListNode of(int[] ints, int fromIndex, int toIndex) {
        final ListNode root = new ListNode(ints[fromIndex]);
        ListNode node = root, tmp;
        for (int i = fromIndex + 1; i < Math.min(ints.length, toIndex); i++) {
            tmp = new ListNode(ints[i]);
            node.next = tmp;
            node = tmp;
        }
        return root;
    }

    /**
     * @throws StackOverflowError if list has cycles
     */
    @Deprecated
    public ListNode copy() {
        return copy(this);
    }

    private static ListNode copy(ListNode head) {
        if (head == null)
            return null;
        ListNode node = new ListNode(head.val);
        node.next = copy(head.next);
        return node;
    }

    @Deprecated
    public int sum() {
        return sum(this);
    }

    private static int sum(ListNode node) {
        return node == null ? 0 : node.val + sum(node.next);
    }

    @Deprecated
    public int count() {
        return count(this);
    }

    private static int count(ListNode node) {
        return node == null ? 0 : 1 + count(node.next);
    }

    @Override
    public String toString() {
        return "(" + val + ")" + (next == null ? "" : ("=>" + next));
    }
}
