package org.gd.leetcode.p0430;

import org.gd.leetcode.common.LeetCode;

import java.util.LinkedList;

@LeetCode(
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.TODO,
        tags = {
                LeetCode.Tags.LINKED_LIST,
                LeetCode.Tags.DEPTH_FIRST_SEARCH
        }
)
class Solution {

    static Node connect(Node prev, Node next) {
        prev.next = next;
        next.prev = prev;
        return next;
    }

    public Node flatten(Node head) {
        if (head == null)
            return null;

        Stack stack = new Stack().push(head);
        Node next, prev = head = new Node();
        while ((next = stack.pop()) != null) {
            connect(prev, next);
            stack.push(next.next).push(next.child);
            next.child = null;
            prev = next;
        }

        prev.next = null;
        head.next.prev = null;

        return head.next;
    }

    static class Stack {

        private final LinkedList<Node> list = new LinkedList<>();

        Node pop() { return list.poll(); }

        Stack push(Node node) {
            if (node != null)
                list.push(node);
            return this;
        }
    }
}
