package org.gd.leetcode.p0881;

import java.util.Arrays;

/**
 * @author Horkhover Dmytro
 * @since 2020-08-12
 */
class SortTwoPointersSolution implements Solution {

    public int numRescueBoats(int[] people, int limit) {

        if (people == null || people.length == 0)
            return 0;

        if (people.length == 1)
            return 1;

        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;
        int count = 0;

        while (left <= right) {
            count++;
            if (people[left] + people[right] <= limit)
                left++;
            right--;
        }

        return count;
    }
}
