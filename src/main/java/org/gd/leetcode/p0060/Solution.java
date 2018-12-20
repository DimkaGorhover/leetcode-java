package org.gd.leetcode.p0060;

import org.gd.leetcode.common.Difficulty;

import java.util.LinkedList;
import java.util.List;

import static org.gd.leetcode.common.Difficulty.Level.MEDIUM;

/**
 * TODO: https://leetcode.com/problems/permutation-sequence/
 *
 * @author Horkhover Dmytro
 * @since 2018-12-20
 */
@Difficulty(MEDIUM)
class Solution {

    public static int fact(int n) {
        int s = 1;
        for (int i = 2; i <= n; i++)
            s = Math.multiplyExact(s, i);
        return s;
    }

    public static void main(String[] args) {

        int n = 4;
        int k = 4;

        int pos = fact(n) / (int) Math.pow(k, 2);

        final List<String> perm = perm(new LinkedList<>(), values(n), "");
        int                i    = 0;
        for (String s : perm) {
            System.out.printf("%2d. [%s]%n", i++, s);
        }

    }

    private static String values(int n) {
        final char[] chars = new char[n];
        for (int i = 0; i < chars.length; i++)
            chars[i] = (char) (i + 49);
        return new String(chars);
    }

    private static List<String> perm(List<String> list, String source, String prefix) {
        if (source.length() == 0) {
            list.add(prefix);
            return list;
        }
        for (int i = 0; i < source.length(); i++) {
            perm(list,
                    source.substring(0, i) + source.substring(i + 1),
                    prefix + source.charAt(i));
        }
        return list;
    }

    public String getPermutation(int n, int k) {


        throw new UnsupportedOperationException();
    }
}
