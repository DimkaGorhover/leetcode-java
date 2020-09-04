package org.gd.hackerrank.common;

import lombok.EqualsAndHashCode;

import static java.util.Objects.requireNonNull;

/**
 * @see org.gd.leetcode.common.ListNode
 */
@EqualsAndHashCode(doNotUseGetters = true)
public class SinglyLinkedListNode {
    
    public final int data;
    
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode(int data) {
        this.data = data;
    }

    public static SinglyLinkedListNode of(int... values) {

        if (values == null || values.length == 0)
            return null;

        var head = new SinglyLinkedListNode(values[0]);
        var node = head;
        for (int i = 1; i < values.length; i++) {
            var newNode = new SinglyLinkedListNode(values[i]);
            node.next = newNode;
            node = newNode;
        }
        return head;
    }

    public static SinglyLinkedListNode concat(SinglyLinkedListNode head, SinglyLinkedListNode tail) {
        if (head == null)
            return tail;
        if (tail == null)
            return head;

        SinglyLinkedListNode last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = tail;
        return head;
    }

    public SinglyLinkedListNode concat(SinglyLinkedListNode tail) {
        return concat(this, tail);
    }

    @Override
    public String toString() {
        return "(" + data + ")" + (next == null ? "" : ("=>" + next));
    }
}
