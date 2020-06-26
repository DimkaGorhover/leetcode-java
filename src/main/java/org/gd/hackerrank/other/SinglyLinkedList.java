package org.gd.hackerrank.other;

import org.gd.hackerrank.common.HackerRank;

import java.util.Objects;

@HackerRank(difficulty = HackerRank.Level.EASY)
class SinglyLinkedList {

    static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {

        if (position == 0) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(data);
            node.next = head;
            return node;
        }

        SinglyLinkedListNode node = head;
        SinglyLinkedListNode next = head.next;
        while (position > 1 && next != null) {
            node = next;
            next = next.next;
            position--;
        }

        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        node.next = newNode;
        newNode.next = next;

        return head;

    }

    static class SinglyLinkedListNode {

        final int data;

        SinglyLinkedListNode next;

        public SinglyLinkedListNode(int data) {
            this.data = data;
        }

        static SinglyLinkedListNode of(int... values) {

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
            var sb = new StringBuilder()
                    .append('(').append(data).append(')');
            if (next != null) {
                sb.append("=>").append(next);
            }
            return sb.toString();
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
}
