package org.gd.leetcode.p0086;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
class ListNode {

    int      val;
    ListNode next;

    ListNode(int x) { val = x; }

    static ListNode of(String values) {
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

    static ListNode of(int... ints) {
        return of(ints, 0, ints.length);
    }

    static ListNode of(int[] ints, int fromIndex, int toIndex) {
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
