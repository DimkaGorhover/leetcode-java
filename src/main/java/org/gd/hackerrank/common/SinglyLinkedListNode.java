package org.gd.hackerrank.common;

import lombok.EqualsAndHashCode;

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

    @Override
    public String toString() {
        return "(" + data + ")" + (next == null ? "" : ("=>" + next));
    }
}
