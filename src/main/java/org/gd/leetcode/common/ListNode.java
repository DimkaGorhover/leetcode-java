package org.gd.leetcode.common;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

import static java.util.Objects.requireNonNull;

public class ListNode implements Iterable<ListNode> {

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

    @Deprecated
    public static ListNode copy(ListNode node) {
        return node == null ? null : node.copy();
    }

    @Deprecated
    public ListNode copy() {
        if (hasCycle())
            throw new IllegalStateException("list has cycles");
        ListNode nextOrigin = this.next;
        ListNode headCopy = new ListNode(val);
        ListNode copy = headCopy;
        while (nextOrigin != null) {
            copy.next = new ListNode(nextOrigin.val);
            nextOrigin = nextOrigin.next;
            copy = copy.next;
        }
        return headCopy;
    }

    @Deprecated
    public ListNode copyRecursive() {
        return copyRecursive(this);
    }

    @Deprecated
    public static ListNode copyRecursive(ListNode head) {
        if (head == null)
            return null;

        if (hasCycle(head))
            throw new IllegalStateException("list has cycles");

        ListNode node = new ListNode(head.val);
        node.next = copyRecursive(head.next);
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

    @SuppressWarnings("DeprecatedIsStillUsed")
    @Deprecated
    public boolean hasCycle() {
        return hasCycle(this);
    }

    @SuppressWarnings("DuplicatedCode")
    private static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;

        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null)
                return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListNode current = this;
        ListNode other = (ListNode) o;

        if (current.hasCycle() || other.hasCycle())
            return false;

        while (current != null || other != null) {

            if (current == null || other == null || current.val != other.val)
                return false;

            current = current.next;
            other = other.next;
        }

        return true;
    }

    @Deprecated
    public boolean isSorted() {
        return isAscendSorted() || isDescendSorted();
    }

    @SuppressWarnings("DuplicatedCode")
    @Deprecated
    public boolean isDescendSorted() {
        ListNode left = this;
        ListNode right = this.next;

        while (right != null) {
            if (right.val < left.val)
                return false;
            left = right;
            right = right.next;
        }
        return true;
    }

    @SuppressWarnings("DuplicatedCode")
    @Deprecated
    public boolean isAscendSorted() {
        ListNode left = this;
        ListNode right = this.next;

        while (right != null) {
            if (right.val > left.val)
                return false;
            left = right;
            right = right.next;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        if (next == null)
            return hash;

        ListNode slow = this;
        ListNode fast = slow.next;
        boolean cycleFound = true;

        while (slow != fast) {

            if (fast == null || fast.next == null) {
                cycleFound = false;
                break;
            }

            hash = hash * 13 + slow.val;

            slow = slow.next;
            fast = fast.next.next;
        }

        if (cycleFound) {
            return hash * 19;
        }

        while (slow != null) {
            hash = hash * 13 + slow.val;
            slow = slow.next;
        }
        return hash;
    }

    @Override
    public String toString() {

        ListNode slow = this;
        ListNode fast = slow.next;

        StringBuilder sb = new StringBuilder();
        String prefix = "";
        int i = 1;

        while (slow != fast) {

            if (fast == null || fast.next == null)
                break;

            sb.append(prefix).append('(').append(slow.val).append(')');
            prefix = "=>";
            if (i >= TO_STRING_LIMIT)
                return sb.append("=>...").toString();

            i++;

            slow = slow.next;
            fast = fast.next.next;
        }

        while (slow != null) {
            sb.append("=>(").append(slow.val).append(')');
            slow = slow.next;
        }

        return sb.toString();
    }

    @Override
    public Iterator<ListNode> iterator() {
        if (hasCycle())
            throw new IllegalStateException("list node has cycle");
        return new Itr(this);
    }

    static class Itr implements Iterator<ListNode> {

        private ListNode node;

        Itr(ListNode node) {
            this.node = node;
        }

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public ListNode next() {
            if (!hasNext())
                throw new NoSuchElementException();

            ListNode node = this.node;
            this.node = node.next;
            return node;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException(new String(new char[]{ 175, 92, 95, 40, 12_484, 41, 95, 47, 175 }));
        }

        @Override
        public void forEachRemaining(Consumer<? super ListNode> action) {
            requireNonNull(action, "\"action\" cannot be null");
            while (node != null) {
                action.accept(node);
                node = node.next;
            }
        }
    }
}
