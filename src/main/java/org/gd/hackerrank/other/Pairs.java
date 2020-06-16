package org.gd.hackerrank.other;

import org.gd.hackerrank.common.HackerRank;

import java.util.Arrays;

/**
 * https://www.hackerrank.com/challenges/pairs/problem
 *
 * @since 2019-09-25
 */
@HackerRank(difficulty = HackerRank.Level.MEDIUM)
class Pairs {

    private Pairs() {
        throw new UnsupportedOperationException();
    }

    static int linearSolution(int k, int[] arr) {
        int count = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            int target = k + arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] == target) {
                    count++;
                } else if (arr[j] > target) {
                    break;
                }
            }
        }
        return count;
    }

    static int twoPointersSolution(int k, int[] arr) {
        Arrays.sort(arr);
        int i = 0, j = 1, count = 0, target;
        while (j < arr.length) {
            if ((target = arr[j] - arr[i]) == k) {
                j++;
                count++;
            } else if (target > k) {
                i++;
            } else if (target < k) {
                j++;
            }
        }
        return count;
    }

    static int pairs(int k, int[] arr) {
        return linearSolution(k, arr);
    }
}
