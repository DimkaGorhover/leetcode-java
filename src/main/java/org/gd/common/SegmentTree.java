package org.gd.common;

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

    SegmentTree(int[] arr) {
        this(arr, 0, arr.length);
    }

    /**
     * Constructor to construct segment tree from given array. This constructor  allocates memory for segment tree and
     * calls {@link #constructSTUtil(int[], int, int, int)} to  fill the allocated memory
     *
     * @see Commons#log(double, double)
     */
    private SegmentTree(int[] arr, int startIndex, int length) {

        this.arr = arr;
        this.length = Math.min(arr.length, length);

        // Allocate memory for segment tree
        // Height of segment tree
        int x = (int) (Math.ceil(Math.log(length) / Math.log(2)));

        // Maximum size of segment tree
        int maxSize = 2 * (int) Math.pow(2, x) - 1;

        // Memory allocation
        tree = new int[maxSize];

        constructSTUtil(arr, 0, length - 1, 0);
    }

    /**
     * A recursive function that constructs Segment Tree for array[ss..se].
     *
     * @param input      input array
     * @param leftBound  left bound (inclusive)
     * @param rightBound right bound (inclusive)
     * @param inputIndex is index of current node in segment tree {@link #tree}
     */
    private int constructSTUtil(int[] input, int leftBound, int rightBound, int inputIndex) {

        // If there is one element in array, store it in current node of segment tree and return
        if (leftBound == rightBound)
            return tree[inputIndex] = input[leftBound];

        // If there are more than one elements, then recur for left and
        // right subtrees and store the sum of values in this node
        int mid = getMid(leftBound, rightBound);

        tree[inputIndex] = constructSTUtil(input, leftBound, mid, (inputIndex * 2 + 1))
                + constructSTUtil(input, (mid + 1), rightBound, (inputIndex * 2 + 2));

        return tree[inputIndex];
    }

    /**
     * A utility function to get the middle index from corner indexes.
     */
    private static int getMid(int leftBound, int rightBound) {
        return leftBound + ((rightBound - leftBound) >> 1);
    }

    /*
        A recursive function to get the sum of values in given range
        of the array.  The following are parameters for this function.

      st    --> Pointer to segment tree
      si    --> Index of current node in the segment tree. Initially
                0 is passed as root is always at index 0
      leftBound & rightBound  --> Starting and ending indexes of the segment represented
                    by current node, i.e., st[si]
      qs & qe  --> Starting and ending indexes of query range

     */

    private int getSumUtil(int leftBound, int rightBound, int qs, int qe, int si) {
        // If segment of this node is a part of given range, then return
        // the sum of the segment
        if (qs <= leftBound && qe >= rightBound)
            return tree[si];

        // If segment of this node is outside the given range
        if (rightBound < qs || leftBound > qe)
            return 0;

        // If a part of this segment overlaps with the given range
        int mid = getMid(leftBound, rightBound);
        return getSumUtil(leftBound, mid, qs, qe, (2 * si + 1)) +
                getSumUtil((mid + 1), rightBound, qs, qe, (2 * si + 2));
    }

    /*
    A recursive function to update the nodes which have the given
       index in their range. The following are parameters
        st, si, ss and se are same as getSumUtil()
        i    --> index of the element to be updated. This index is in
                 input array.
       diff --> Value to be added to all nodes which have i in range
    */
    private void updateValueUtil(int leftBound, int rightBound, int i, int diff, int si) {
        // Base Case: If the input index lies outside the range of
        // this segment
        if (i < leftBound || i > rightBound)
            return;

        // If the input index is in range of this node, then update the
        // value of the node and its children
        tree[si] = tree[si] + diff;
        if (rightBound != leftBound) {
            int mid = getMid(leftBound, rightBound);
            updateValueUtil(leftBound, mid, i, diff, 2 * si + 1);
            updateValueUtil(mid + 1, rightBound, i, diff, 2 * si + 2);
        }
    }

    /**
     * The function to update a value in input array and segment tree. It uses updateValueUtil() to update the value in
     * segment tree
     */
    void updateValue(int index, int value) {

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
     * It mainly uses {@link #getSumUtil(int, int, int, int, int)}
     *
     * @return sum of elements in range from index qs (quey start) to qe (query end).
     */
    int getSum(int qs, int qe) {
        // Check for erroneous input values
        if (qs < 0 || qe > length - 1 || qs > qe) {
            System.out.println("Invalid Input");
            return -1;
        }
        return getSumUtil(0, length - 1, qs, qe, 0);
    }
}
