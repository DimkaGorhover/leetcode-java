package org.gd.leetcode.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;

import static java.util.Objects.requireNonNull;

/**
 * Definition for singly-linked list.
 *
 * @author LeetCode
 */
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

    public static ListNode concat(ListNode... listNodes) {
        if (listNodes == null || listNodes.length == 0)
            return null;

        ListNode head = listNodes[0];
        ListNode node = head;
        for (int i = 1; i < listNodes.length; i++)
            node = concat(node, listNodes[i]);

        return head;
    }

    public static ListNode concat(ListNode l1) { return l1; }

    public static ListNode concat(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        ListNode tail = l1;
        while (tail.next != null)
            tail = tail.next;

        tail.next = l2;
        return l1;
    }

    @Deprecated
    public ListNode reverse() {
        return reverse(copy());
    }

    @Deprecated
    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode prev = null;
        ListNode current = head;
        ListNode next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    @Deprecated
    public static int length(ListNode node) {
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    @Deprecated
    public static int[] values(ListNode node) {
        if (node == null)
            return new int[0];

        int[] ints = new int[length(node)];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = node.val;
            node = node.next;
        }

        return ints;
    }

    @Deprecated
    public static List<Integer> listValues(ListNode node) {
        if (node == null)
            return Collections.emptyList();

        int length = length(node);
        ArrayList<Integer> ints = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            ints.add(node.val);
            node = node.next;
        }

        return ints;
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

    /**
     * Alias to {@link #count()}
     */
    @Deprecated
    public int size() {
        return count();
    }

    /**
     * Alias to {@link #count(ListNode)}
     */
    @Deprecated
    public static int size(ListNode node) {
        return count(node);
    }

    /**
     * Alias to {@link #count()}
     */
    @Deprecated
    public int length() {
        return count();
    }

    @Deprecated
    public int count() {
        return count(this);
    }

    /**
     * Alias to {@link #length(ListNode)}
     */
    @Deprecated
    public static int count(ListNode node) {
        return length(node);
    }

    @Deprecated
    public boolean hasCycle() {
        return hasCycle(this);
    }

    @Deprecated
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

        while (slow != null && slow != fast) {
            hash = hash * 13 + slow.val;
            slow = slow.next;
        }
        return hash;
    }

    public String unsafeToString() {
        StringBuilder sb = new StringBuilder();
        Iterator<ListNode> iterator = iterator();
        ListNode node;
        if (iterator.hasNext()) {
            node = iterator.next();
            sb.append('(').append(node.val).append(')');
            while (iterator.hasNext()) {
                node = iterator.next();
                sb.append("=>(").append(node.val).append(')');
            }
        }
        return sb.toString();
    }

    @Override
    public String toString() {

        ListNode slow = this;
        ListNode fast = slow.next;

        StringBuilder sb = new StringBuilder();
        String prefix = "";
        int i = 1;

        while (slow != fast) {

            if (fast == null || fast.next == null) {
                // cycle not found

                while (slow != null) {
                    sb.append(prefix).append("(").append(slow.val).append(')');
                    slow = slow.next;
                    prefix = "=>";
                }

                return sb.toString();
            }

            sb.append(prefix).append('(').append(slow.val).append(')');
            prefix = "=>";
            if (i >= TO_STRING_LIMIT)
                return sb.append("=>...").toString();

            i++;

            slow = slow.next;
            fast = fast.next.next;
        }

        if (slow != null)
            sb.append("=>...");

        return sb.toString();
    }

    @Override
    public Spliterator<ListNode> spliterator() {
        return Spliterators.spliterator(iterator(), length(), 0);
    }

    @Override
    public void forEach(Consumer<? super ListNode> action) {
        requireNonNull(action, "\"action\" cannot be null");
        ListNode node = this;
        while (node != null) {
            action.accept(node);
            node = node.next;
        }
    }

    @Override
    public Iterator<ListNode> iterator() {
        if (hasCycle())
            throw new IllegalStateException("list node has cycle");
        return new Itr(this);
    }

    static class Itr implements Iterator<ListNode> {

        private ListNode parent;
        private ListNode node;

        Itr(ListNode node) {
            this.node = node;
            this.parent = null;
        }

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public ListNode next() {
            if (!hasNext())
                throw new NoSuchElementException();

            parent = this.node;
            this.node = node.next;
            return parent;
        }

        @Override
        public void remove() {
            if (!hasNext())
                throw new NoSuchElementException();

            if (parent == null)
                throw new IllegalStateException("You cannot remove first node, because you'll lose link to the head of the list");

            parent.next = node.next;
            node = parent.next;
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
