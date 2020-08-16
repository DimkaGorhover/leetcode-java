package org.gd.leetcode.p0138;

import org.gd.leetcode.common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 *
 * @author Horkhover Dmytro
 * @since 2020-08-16
 */
@LeetCode(
        name = "Copy List with Random Pointer",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.HASH_TABLE,
                LeetCode.Tags.LINKED_LIST
        }
)
class Solution {

    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        Map<Node, Node> map = new HashMap<>();

        Node node = head;

        Node newHead = new Node(0);
        Node newNode = newHead;

        while (node != null) {

            newNode.next = new Node(node.val);
            map.put(node, newNode.next);

            newNode = newNode.next;
            node = node.next;
        }

        newHead = newHead.next;
        newNode = newHead;

        node = head;

        while (node != null && newNode != null) {

            if (node.random != null)
                newNode.random = map.get(node.random);

            node = node.next;
            newNode = newNode.next;
        }

        return newHead;
    }

}
