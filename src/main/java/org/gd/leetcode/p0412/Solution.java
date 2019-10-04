package org.gd.leetcode.p0412;

import org.gd.leetcode.common.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/fizz-buzz/
 *
 * @see org.gd.leetcode.p1195.FizzBuzz
 * @since 2019-10-04
 */
@SuppressWarnings("JavadocReference")
@LeetCode(difficulty = LeetCode.Level.EASY)
class Solution {

    public List<String> fizzBuzz(int n) {
        if (n <= 0)
            return Collections.emptyList();
        switch (n) {
            case 1: return Collections.singletonList("1");
            case 2: return Arrays.asList("1", "2");
        }
        final List<String> list = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0) {
                list.add((i % 5 == 0) ? "FizzBuzz" : "Fizz");
            } else {
                list.add((i % 5 == 0) ? "Buzz" : ("" + i));
            }
        }
        return list;
    }
}
