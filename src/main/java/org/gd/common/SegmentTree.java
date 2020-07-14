package org.gd.common;

import java.util.LinkedList;

/**
 * https://www.geeksforgeeks.org/segment-tree-set-1-sum-of-given-range/
 *
 * @author Ankur Narain Verma
 * @since 2019-09-24
 */
public class SegmentTree {

    /** The array that stores segment tree nodes */
    private final int[] arr;
    private final int[] tree;
    private final int length;

    public SegmentTree(int[] arr) {
        this(arr, 0, arr.length);
    }

    /**
     * Constructor to construct segment tree from given array. This constructor  allocates memory for segment tree and
     * calls {@link #construct(int, int, int)} to  fill the allocated memory
     *
     * @see Commons#log(double, double)
     */
    private SegmentTree(int[] arr, int startIndex, int length) {

        this.arr = arr;
        this.length = Math.min(arr.length, length);

        // Allocate memory for segment tree
        // Height of segment tree
        int treeHeight = (int) (Math.ceil(Math.log(length) / Math.log(2)));

        // Maximum size of segment tree

        //int maxSize = 2 * (int) Math.pow(2, x) - 1;
        int arrayTreeSize = (2 << treeHeight) - 1;

        // Memory allocation
        tree = new int[arrayTreeSize];

        construct(startIndex, startIndex + length - 1, 0);
    }

    /**
     * A utility function to get the middle index from corner indexes.
     */
    private static int getMid(int leftBound, int rightBound) {
        return leftBound + ((rightBound - leftBound) >> 1);
    }

    /**
     * A recursive function that constructs Segment Tree for array[ss..se].
     *
     * @param leftBound  left bound (inclusive)
     * @param rightBound right bound (inclusive)
     * @param treeIndex  is index of current node in segment tree {@link #tree}
     */
    private int construct(int leftBound, int rightBound, int treeIndex) {

        // If there is one element in array, store it in current node of segment tree and return
        if (leftBound == rightBound)
            return tree[treeIndex] = arr[leftBound];

        // If there are more than one elements, then recur for left and
        // right subtrees and store the sum of values in this node
        final int mid = getMid(leftBound, rightBound);

        final int leftSum = construct(leftBound, mid, (treeIndex * 2 + 1));
        final int rightSum = construct((mid + 1), rightBound, (treeIndex * 2 + 2));

        return tree[treeIndex] = leftSum + rightSum;
    }

    /**
     * The function to update a value in input array and segment tree. It uses updateValueUtil() to update the value in
     * segment tree
     */
    public void update(int index, int value) {

        if (index < 0 || index > length - 1)
            throw new IndexOutOfBoundsException();

        // Get the difference between new value and old value
        int diff = value - arr[index];

        // Update the value in array
        arr[index] = value;

        // Update the values of nodes in segment tree
        updateValueUtil(0, length - 1, index, diff, 0);
    }

    /**
     * A recursive function to update the nodes which have the given index in their range. The following are parameters
     *
     * @param leftBound  Starting indexes of the segment represented by current node
     * @param rightBound ending indexes of the segment represented by current node, i.e., st[si]
     * @param index      index of the element to be updated. This index is in input array
     * @param diff       Value to be added to all nodes which have i in range
     * @param treeIndex  Index of current node in the segment tree. Initially 0 is passed as root is always at index 0
     */
    private void updateValueUtil(int leftBound, int rightBound, int index, int diff, int treeIndex) {
        // Base Case: If the input index lies outside the range of
        // this segment
        if (index < leftBound || index > rightBound)
            return;

        // If the input index is in range of this node, then update the
        // value of the node and its children
        tree[treeIndex] = tree[treeIndex] + diff;
        if (rightBound != leftBound) {
            int mid = getMid(leftBound, rightBound);
            updateValueUtil(leftBound, mid, index, diff, 2 * treeIndex + 1);
            updateValueUtil(mid + 1, rightBound, index, diff, 2 * treeIndex + 2);
        }
    }

    /**
     * It mainly uses {@link #getSumUtil(int, int, int, int, int)}
     *
     * @return sum of elements in range from index qs (quey start) to qe (query end).
     */
    public int getSum(int leftBound, int rightBound) {

        if (leftBound < 0 || rightBound > length - 1 || leftBound > rightBound)
            throw new IndexOutOfBoundsException();

        return getSumUtil(0, length - 1, leftBound, rightBound, 0);
    }

    /**
     * A recursive function to get the sum of values in given range of the array.  The following are parameters for this
     * function.
     *
     * @param treeIndex      Index of current node in the segment tree. Initially 0 is passed as root is always at index
     *                       0
     * @param treeLeftBound  Starting indexes of the segment represented by current node
     * @param treeRightBound ending indexes of the segment represented by current node, i.e., st[si]
     * @param leftBound      Starting indexes of query range
     * @param rightBound     ending indexes of query range
     */
    private int getSumUtil(int treeLeftBound, int treeRightBound, int leftBound, int rightBound, int treeIndex) {

        // If segment of this node is a part of given range, then return
        // the sum of the segment
        if (leftBound <= treeLeftBound && rightBound >= treeRightBound)
            return tree[treeIndex];

        // If segment of this node is outside the given range
        if (treeRightBound < leftBound || treeLeftBound > rightBound)
            return 0;

        // If a part of this segment overlaps with the given range
        int mid = getMid(treeLeftBound, treeRightBound);

        int leftSum = getSumUtil(treeLeftBound, mid, leftBound, rightBound, (treeIndex * 2 + 1));
        int rightSum = getSumUtil((mid + 1), treeRightBound, leftBound, rightBound, (treeIndex * 2 + 2));

        return leftSum + rightSum;
    }

    @Override
    public String toString() {

        String format = "%" + Commons.maxDigitsCount(tree) + "d ";

        LinkedList<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 1});
        int[] bounds;
        StringBuilder sb = new StringBuilder();
        while ((bounds = q.poll()) != null) {
            for (int i = bounds[0]; i < Math.min(tree.length, bounds[1]); i++) {
                sb.append(String.format(format, tree[i]));
            }
            sb.append('\n');
            if (bounds[1] < tree.length) {
                q.add(new int[]{bounds[1], (bounds[1] << 1) + 1});
            }
        }
        return sb.toString();
    }
}
