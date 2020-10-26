package org.gd.leetcode.p0307;

import org.gd.common.Repeat;
import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/range-sum-query-mutable/
 *
 * https://www.geeksforgeeks.org/segment-tree-set-1-sum-of-given-range/
 *
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 *
 * The {@link #update(int, int)} function modifies nums by updating the element at index i to val.
 *
 * Note:
 *
 * The array is only modifiable by the update function. You may assume the number of calls to {@link #update(int, int)}
 * and {@link #sumRange(int, int)} function is distributed evenly.
 *
 * @see org.gd.common.SegmentTree
 * @see org.gd.leetcode.p0303.NumArray
 * @see org.gd.leetcode.p0304.NumMatrix
 * @see org.gd.leetcode.p0308.NumMatrix
 * @since 2019-09-18
 */
@Repeat("SEGMENT_TREE")
@SuppressWarnings({"JavadocReference", "DuplicatedCode"})
@LeetCode(
        name = "range sum query mutable",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.BINARY_INDEXED_TREE,
                LeetCode.Tags.SEGMENT_TREE
        })
class NumArray {

    private final Solution solution;

    public NumArray(int[] nums) {
        if (nums.length > 0) {
            solution = new SegmentTreeSolution(nums);
        } else {
            solution = EmptySolution.INSTANCE;
        }
    }

    public void update(int index, int value) {
        solution.update(index, value);
    }

    public int sumRange(int leftBound, int rightBound) {
        return solution.sumRange(leftBound, rightBound);
    }

    @Override
    public String toString() {
        return solution.toString();
    }

    interface Solution {

        void update(int index, int value);

        int sumRange(int leftBound, int rightBound);
    }

    static class EmptySolution implements Solution {

        public static final EmptySolution INSTANCE = new EmptySolution();

        private EmptySolution() {}

        @Override
        public void update(int index, int value) {
            throw new IndexOutOfBoundsException();
        }

        @Override
        public int sumRange(int leftBound, int rightBound) {
            throw new IndexOutOfBoundsException();
        }

        @Override
        public String toString() { return "Empty"; }
    }

    static class SegmentTreeSolution implements Solution {

        private final int[] arr;
        private final int[] tree;

        SegmentTreeSolution(int[] nums) {
            this.arr = nums;
            int treeHeight = (int) (Math.ceil(Math.log(nums.length) / Math.log(2)));
            int arrayTreeSize = (2 << treeHeight) - 1;
            tree = new int[arrayTreeSize];
            construct(0, nums.length - 1, 0);
        }

        static int getMid(int leftBound, int rightBound) {
            return leftBound + ((rightBound - leftBound) >> 1);
        }

        private int construct(int leftBound, int rightBound, int treeIndex) {

            if (leftBound == rightBound)
                return tree[treeIndex] = arr[leftBound];

            final int mid = getMid(leftBound, rightBound);

            final int leftSum = construct(leftBound, mid, (treeIndex * 2 + 1));
            final int rightSum = construct((mid + 1), rightBound, (treeIndex * 2 + 2));

            return tree[treeIndex] = leftSum + rightSum;
        }

        @Override
        public void update(int index, int value) {
            if (index < 0 || index > arr.length - 1)
                throw new IndexOutOfBoundsException();

            new Update(index, value).update();
        }

        @Override
        public int sumRange(int leftBound, int rightBound) {
            if (leftBound < 0 || rightBound > arr.length - 1 || leftBound > rightBound)
                throw new IndexOutOfBoundsException();

            return new Query(leftBound, rightBound).sum();
        }

        class Update {

            private final int diff;
            private final int index;

            Update(int index, int value) {
                this.index = index;
                diff = value - arr[index];
                arr[index] = value;
            }

            void update() {
                update(0, arr.length - 1, 0);
            }

            void update(int left, int right, int treeIndex) {
                if (index < left || index > right)
                    return;

                tree[treeIndex] += diff;

                if (left != right) {
                    int mid = getMid(left, right);
                    update(left, mid, (2 * treeIndex) + 1);
                    update(mid + 1, right, (2 * treeIndex) + 2);
                }
            }
        }

        class Query {

            private final int leftBound;
            private final int rightBound;

            Query(int leftBound, int rightBound) {
                this.leftBound = leftBound;
                this.rightBound = rightBound;
            }

            int sum() {
                return sum(0, arr.length - 1, 0);
            }

            private int sum(int left, int right, int treeIndex) {

                if (leftBound <= left && right <= rightBound)
                    return tree[treeIndex];

                if (right < leftBound || rightBound < left)
                    return 0;

                int mid = getMid(left, right);

                int leftSum = sum(left, mid, (treeIndex * 2 + 1));
                int rightSum = sum((mid + 1), right, (treeIndex * 2 + 2));

                return leftSum + rightSum;
            }
        }
    }
}
