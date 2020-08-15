package org.gd.leetcode.p0542;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Horkhover Dmytro
 * @since 2020-08-15
 */
class MatrixList extends ArrayList<List<Integer>> {

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int size = size();
        for (int i = 0; i < size; i++) {
            var col = get(i);
            sb.append('[').append(col.get(0));
            for (int j = 1; j < col.size(); j++) {
                sb.append(", ").append(col.get(j));
            }
            sb.append("]\n");
        }
        return sb.toString();
    }
}
