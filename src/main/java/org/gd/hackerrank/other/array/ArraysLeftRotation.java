package org.gd.hackerrank.other.array;

import org.gd.hackerrank.common.HackerRank;

/**
 * https://www.hackerrank.com/challenges/ctci-array-left-rotation/
 */
@HackerRank(difficulty = HackerRank.Level.EASY)
class ArraysLeftRotation {

    private ArraysLeftRotation() { throw new UnsupportedOperationException(); }

    static int[] rotLeft(int[] array, int rotationCount) {

        if (array == null || array.length <= 1 || rotationCount == 0 || (rotationCount %= array.length) == 0)
            return array;

        if (array.length == 2)
            return new int[]{array[1], array[0]};

        return systemArrayCopy(array, rotationCount);
    }

    private static int[] systemArrayCopy(int[] arr, int rotationCount) {

        int[] newArr = new int[arr.length];

        System.arraycopy(arr, rotationCount, newArr, 0, arr.length - rotationCount);
        System.arraycopy(arr, 0, newArr, arr.length - rotationCount, rotationCount);

        return newArr;
    }
}
