package org.gd.leetcode.p1352;

import org.gd.leetcode.common.LeetCode;

import java.util.ArrayList;

/**
 * https://leetcode.com/problems/product-of-the-last-k-numbers/
 */
@LeetCode(
        name = "Product of the Last K Numbers",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.ARRAY,
                LeetCode.Tags.DESIGN
        }
)
class ProductOfNumbers {

    private ArrayList<Integer> list;

    public ProductOfNumbers() { reset(); }

    private void reset() {
        list = new ArrayList<>();
        list.add(1);
    }

    public void add(int num) {
        if (num > 0) {
            int prev = list.get(list.size() - 1);
            list.add(prev * num);
        } else {
            reset();
        }
    }

    public int getProduct(int k) {
        int size = list.size();
        return k < size ? list.get(size - 1) / list.get(size - k - 1) : 0;
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
