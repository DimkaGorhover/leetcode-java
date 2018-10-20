package org.gd.leetcode.p0876;

import java.util.ArrayList;

class Solution {

    public ListNode middleNode(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        final ArrayList<ListNode> listNodes = new ArrayList<>();

        ListNode node = head;
        while (node != null) {
            listNodes.add(node);
            node = node.next;
        }

        return listNodes.get((listNodes.size() / 2));
    }
}
