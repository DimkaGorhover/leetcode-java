package org.gd.leetcode.p0405;

/**
 * @author Horkhover Dmytro
 * @see JavaSolution
 * @since 2020-08-04
 */
@SuppressWarnings("SpellCheckingInspection")
class LoopSolution implements Solution {

    private static final char[] CHARS = "0123456789abcdef".toCharArray();

    public String toHex(int num) {
        if (num == 0) return "0";
        char[] hex = new char[8];
        int i = hex.length;
        while (num != 0) {
            hex[--i] = CHARS[(num & 15)];
            num = num >>> 4;
        }
        return new String(hex, i, hex.length - i);
    }
}
