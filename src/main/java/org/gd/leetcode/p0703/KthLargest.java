package org.gd.leetcode.p0703;

import org.gd.leetcode.common.LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/
 *
 * @see org.gd.leetcode.p0215.Solution
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Kth Largest Element in a Stream",
        state = LeetCode.State.TODO,
        difficulty = LeetCode.Level.EASY,
        tags = {
                LeetCode.Tags.HEAP,
                LeetCode.Tags.TREE,
                LeetCode.Tags.BINARY_TREE,
                LeetCode.Tags.BINARY_SEARCH_TREE,
                LeetCode.Tags.DESIGN,
                LeetCode.Tags.DATA_STREAM
        }
)
class KthLargest {

    private final PriorityQueue<Integer> q;
    private final int limit;

    public KthLargest(int k, int[] nums) {
        q = new PriorityQueue<>(k, Comparator.reverseOrder());
        limit = k;
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (q.size() < limit) {
            q.add(val);
            return q.peek();
        }

        int largest = q.peek();

        throw new UnsupportedOperationException("not supported yet");
    }
}
