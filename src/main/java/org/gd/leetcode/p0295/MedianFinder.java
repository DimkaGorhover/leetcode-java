package org.gd.leetcode.p0295;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/find-median-from-data-stream/
 *
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So
 * the median is the mean of the two middle value.
 *
 * For example, [2,3,4], the median is 3
 *
 * [2,3], the median is (2 + 3) / 2 = 2.5
 *
 * Design a data structure that supports the following two operations:
 *
 * void addNum(int num) - Add a integer number from the data stream to the data structure. double findMedian() - Return
 * the median of all elements so far.
 *
 * Follow up:
 *
 * If all integer numbers from the stream are between 0 and 100, how would you optimize it? If 99% of all integer
 * numbers from the stream are between 0 and 100, how would you optimize it?
 *
 * @since 2019-09-10
 */
@LeetCode(difficulty = LeetCode.Level.HARD, tags = {LeetCode.Tags.HEAP, LeetCode.Tags.DESIGN})
class MedianFinder {

    private int[] elementData = new int[0];
    private int size = 0;

    public MedianFinder() {}

    private int binarySearchPos(int key) {
        int low = 0, high = size - 1, mid, cmp;
        while (low <= high) {
            int midVal = elementData[mid = (low + high) >>> 1];
            if ((cmp = Integer.compare(midVal, key)) < 0)
                low = mid + 1;
            else if (cmp > 0)
                high = mid - 1;
            else
                return mid;
        }
        return low;
    }

    public void addNum(int num) {
        if (size == elementData.length) {
            int[] newElementData = new int[elementData.length + 10];
            System.arraycopy(elementData, 0, newElementData, 0, elementData.length);
            elementData = newElementData;
        }
        int i = binarySearchPos(num);
        System.arraycopy(elementData, i, elementData, i + 1, size - i);
        elementData[i] = num;
        this.size = size + 1;
    }

    public double findMedian() {
        if (size == 0)
            return 0;

        if (size % 2 == 0) {
            int i = size >> 1;
            return (elementData[i] + elementData[i - 1]) * 0.5;
        }
        return elementData[size >> 1];
    }
}
