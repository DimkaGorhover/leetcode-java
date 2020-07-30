package org.gd.leetcode.p0238;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

/**
 * @author Horkhover Dmytro
 * @since 2020-07-28
 */
class TestUtils {

    private TestUtils() { throw new UnsupportedOperationException(); }

    static int[] randomArray(int length) {

        if (length > (1 << 8))
            return IntStream.range(0, length).parallel()
                    .map(ignore -> ThreadLocalRandom.current().nextInt(0, 100))
                    .toArray();

        int[] array = new int[length];
        for (int i = 0; i < length; i++)
            array[i] = ThreadLocalRandom.current().nextInt(0, 100);

        return array;
    }

    static int prodExceptPos(int[] nums, int pos) {
        int prod = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i == pos) continue;
            if (nums[i] == 0) return 0;
            prod *= nums[i];
        }
        return prod;
    }

    static int[] solution(int[] nums) {
        int[] prods = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            prods[i] = prodExceptPos(nums, i);
        return prods;
    }
}
