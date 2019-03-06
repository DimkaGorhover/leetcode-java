package org.gd.hackerrank.leverton;

/**
 * @author Horkhover Dmytro
 * @since 2019-03-06
 */
class MergeStrings {

    private MergeStrings() { throw new UnsupportedOperationException(); }

    static String mergeStrings(String a, String b) {
        final int    l1    = a.length(), l2 = b.length();
        final char[] chars = new char[l1 + l2];
        int          i     = 0, i1 = 0, i2 = 0;
        while (i1 < l1 || i2 < l2) {
            if (i1 < l1) chars[i++] = a.charAt(i1++);
            if (i2 < l2) chars[i++] = b.charAt(i2++);
        }
        return new String(chars);
    }
}
