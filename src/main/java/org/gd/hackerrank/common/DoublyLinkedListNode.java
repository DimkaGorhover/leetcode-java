package org.gd.hackerrank.common;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Horkhover Dmytro
 * @since 2020-09-04
 */
public class DoublyLinkedListNode {

    public int data;
    public DoublyLinkedListNode next;
    public DoublyLinkedListNode prev;

    public DoublyLinkedListNode(int data) {
        this.data = data;
    }

    public static DoublyLinkedListNode of(int... values) {
        DoublyLinkedListNode head = new DoublyLinkedListNode(0);
        DoublyLinkedListNode prev = head;
        for (int value : values) {
            DoublyLinkedListNode next = new DoublyLinkedListNode(value);
            prev.next = next;
            next.prev = prev;
            prev = next;
        }
        head.next.prev = null;
        return head.next;
    }

    @Deprecated
    public List<Integer> toList() {
        return toList(this);
    }

    @Deprecated
    public static List<Integer> toList(DoublyLinkedListNode node) {
        if (node == null)
            return Collections.emptyList();
        LinkedList<Integer> list = new LinkedList<>();
        while (node != null) {
            list.add(node.data);
            node = node.next;

        }
        return list;
    }

    @Override
    public String toString() {
        String str = "(" + data + ")";
        if (next != null)
            str += "->" + next.toString();
        return str;
    }
}
