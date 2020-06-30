package org.gd.hackerrank.common;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SinglyLinkedListNode that = (SinglyLinkedListNode) o;
        return data == that.data &&
                Objects.equals(next, that.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, next);
    }
}
