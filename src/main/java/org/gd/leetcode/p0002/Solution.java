package org.gd.leetcode.p0002;

import java.math.BigInteger;

class Solution {

    private static BigInteger sum(ListNode l1) {
        BigInteger sum = BigInteger.ZERO;
        int        m   = 0;
        while (l1 != null) {
            final BigInteger pow = BigInteger.TEN.pow(m);
            final BigInteger val = BigInteger.valueOf(l1.val);
            sum = sum.add(val.multiply(pow));
            l1 = l1.next;
            m++;
        }
        return sum;
    }

    private static ListNode swap(ListNode res, int i) {
        ListNode tmp = new ListNode(i);
        res.next = tmp;
        return tmp;
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger sum = sum(l1).add(sum(l2));

        if (sum.compareTo(BigInteger.ZERO) <= 0)
            return new ListNode(sum.intValue());

        ListNode res = null, head = null;
        while (sum.compareTo(BigInteger.ZERO) > 0) {
            final BigInteger mod = BigInteger.TEN;
            int i = sum.mod(mod).intValue();
            if (res == null) {
                res = head = new ListNode(i);
            } else {
                res = swap(res, i);
            }
            sum = sum.subtract(BigInteger.valueOf(i));
            sum = sum.divide(BigInteger.TEN);
        }
        return head;
    }


}
