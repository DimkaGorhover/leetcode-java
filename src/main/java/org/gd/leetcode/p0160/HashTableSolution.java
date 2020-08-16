package org.gd.leetcode.p0160;

import org.gd.leetcode.common.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Horkhover Dmytro
 * @see TwoPointersSolution
 * @since 2020-08-16
 * @deprecated uses too much space, use {@link TwoPointersSolution} instead
 */
@Deprecated
class HashTableSolution implements Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null)
            return null;

        Map<ListNode, ListNode> set = new HashMap<>();
        while (headA != null) {
            set.put(headA, headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (set.get(headB) == headB)
                return headB;
            headB = headB.next;
        }

        return null;
    }
}
