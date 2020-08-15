package org.gd.leetcode.p0542;

import org.gd.common.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Horkhover Dmytro
 * @since 2020-08-15
 */
class Matrix extends ArrayList<List<Integer>> {

    static Matrix of(int[][] matrix) {
        Matrix lists = new Matrix();
        for (int[] col : matrix)
            lists.add(CollectionUtils.listOf(col));
        return lists;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int size = size();
        for (int row = 0; row < size; row++) {
            var line = get(row);
            sb.append('[').append(line.get(0));
            for (int j = 1; j < line.size(); j++) {
                sb.append(", ").append(line.get(j));
            }
            sb.append(']').append('\n');
        }
        return sb.toString();
    }
}
