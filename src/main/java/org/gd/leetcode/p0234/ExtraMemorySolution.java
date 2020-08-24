package org.gd.leetcode.p0234;

import org.gd.leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.Objects;

/**
 * @author Horkhover Dmytro
 * @since 2020-08-24
 */
class ExtraMemorySolution implements Solution {

    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null)
            return true;

        final ArrayList<Integer> integers = new ArrayList<>();
        for (; head != null; head = head.next)
            integers.add(head.val);

        final int n = integers.size();
        for (int i = 0; i < n / 2; i++)
            if (!Objects.equals(integers.get(i), integers.get(n - i - 1)))
                return false;

        return true;
    }
}
