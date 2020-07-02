package org.gd.leetcode.common;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class ListNode {

    private static final int TO_STRING_LIMIT = 1 << 5;

    public int val;
    public ListNode next;

    public ListNode(int x) { val = x; }

    public static ListNode of(String values) {
        String[] strings = values.split("(->)|;|,|\\|");
        int[] ints = new int[strings.length];
        int cursor = 0;
        for (String string : strings) {
            try {
                int value = Integer.parseInt(string.trim());
                ints[cursor++] = value;
            } catch (NumberFormatException ignore) {}
        }
        return of(ints, 0, cursor);
    }

    public static ListNode rangeClosed(int start, int end) {
        if (start == end)
            return new ListNode(start);

        ListNode head = new ListNode(-1);
        ListNode node = head;
        if (start < end) {
            for (int i = start; i <= end; i++)
                node = node.addNext(i);
        } else {
            for (int i = start; i >= end; i--)
                node = node.addNext(i);
        }
        return head.next;
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

    public ListNode addNext(int val) {
        ListNode node = new ListNode(val);
        this.next = node;
        return node;
    }

    @Deprecated
    public int sum() {
        ListNode node = this;
        int sum = val;
        while ((node = node.next) != null)
            sum += node.val;
        return sum;
    }

    @Deprecated
    public int count() {
        ListNode node = this;
        int count = 1;
        while ((node = node.next) != null)
            count++;
        return count;
    }

    @Override
    public String toString() {
        ListNode node = this;
        StringBuilder sb = new StringBuilder();
        sb.append('(').append(node.val).append(')');
        int i = 1;
        while ((node = node.next) != null) {
            sb.append("=>(").append(node.val).append(')');
            if (i >= TO_STRING_LIMIT) {
                sb.append("=>...");
                break;
            }
            i++;
        }
        return sb.toString();
    }
}
