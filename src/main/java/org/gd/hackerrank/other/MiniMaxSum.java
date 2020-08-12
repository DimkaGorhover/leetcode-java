package org.gd.hackerrank.other;

/**
 * https://www.hackerrank.com/challenges/mini-max-sum/
 *
 * @author Horkhover Dmytro
 * @since 2020-08-12
 */
class MiniMaxSum {

    static void miniMaxSum(int[] arr) {

        long min = arr[0];
        long max = arr[0];
        long sum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
            sum += arr[i];
        }

        System.out.printf("%d %d%n", sum - max, sum - min);
    }
}
