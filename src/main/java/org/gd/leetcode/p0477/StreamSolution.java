package org.gd.leetcode.p0477;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author Horkhover Dmytro
 * @see Solution
 * @since 2020-07-23
 */
class StreamSolution {

    public int totalHammingDistance(int[] nums) {
        return IntStream.range(0, Integer.SIZE)
                .map(shift -> Arrays.stream(nums).parallel()
                        .map(num -> (num >> shift) & 1)
                        .sum())
                .map(bitCount -> bitCount * (nums.length - bitCount))
                .sum();
    }
}
