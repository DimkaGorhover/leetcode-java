package org.gd.leetcode.p0119;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @see MySolution
 */
class ReferenceSolution implements Solution {

    public List<Integer> getRow(int rowIndex) {

        if (rowIndex < 0)
            return Collections.emptyList();

        if (rowIndex == 0)
            return Collections.singletonList(1);

        List<Integer> res = new ArrayList<>(rowIndex + 1);
        res.add(1);

        for (int i = 1; i <= rowIndex; i++) {
            long num = (res.get(i - 1) * (rowIndex - i + 1L)) / i;
            res.add(Math.toIntExact(num));
        }

        return res;
    }
}
