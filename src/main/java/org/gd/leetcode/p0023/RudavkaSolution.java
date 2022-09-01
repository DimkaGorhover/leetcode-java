package org.gd.leetcode.p0023;

import org.gd.leetcode.common.ListNode;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class RudavkaSolution implements Solution {

    public static void main(String[] args) {
        System.out.println(
                new RudavkaSolution().mergeKLists(new ListNode[]{
                        ListNode.of(1, 2, 3, 4, 5),
                        ListNode.of(1, 2, 3, 4, 5),
                        ListNode.of(1, 2, 3, 4, 5)
                })
        );
    }

    @Override
    public ListNode mergeKLists(ListNode[] lists) {

        Queue<ListNode> queue = new PriorityQueue<>(lists.length, Comparator.comparingInt(node -> node.val));
        Collections.addAll(queue, lists);

        ListNode tmp = new ListNode(0), head = tmp, listNode;
        while ((listNode = queue.poll()) != null) {
            head.next = new ListNode(listNode.val);
            head = head.next;
            listNode = listNode.next;
            if (listNode != null) {
                queue.add(listNode);
            }
        }
        return tmp.next;
    }
}
