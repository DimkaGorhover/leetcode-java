package org.gd.leetcode.common;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class ListNode {

    public int      val;
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

    public static ListNode of(int... ints) {
        return of(ints, 0, ints.length);
    }

    public static ListNode of(int[] ints, int fromIndex, int toIndex) {
        final ListNode root = new ListNode(ints[fromIndex]);
        ListNode       node = root, tmp;
        for (int i = fromIndex + 1; i < Math.min(ints.length, toIndex); i++) {
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
