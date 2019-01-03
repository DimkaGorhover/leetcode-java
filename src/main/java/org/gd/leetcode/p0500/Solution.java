package org.gd.leetcode.p0500;

import org.gd.leetcode.common.LeetCode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/keyboard-row/
 *
 * @author Horkhover Dmytro
 * @since 2018-12-28
 */
@LeetCode(difficulty = LeetCode.Level.EASY)
class Solution {

    private static final int[] KEYBOARD;

    static {
        // @formatter:off
        int[] kb = new int[1 << 7];
        kb['q'] = 1; kb['Q'] = 1; kb['a']  = 2; kb['A'] = 2; kb['z'] = 3; kb['Z'] = 3;
        kb['w'] = 1; kb['W'] = 1; kb['s']  = 2; kb['S'] = 2; kb['x'] = 3; kb['X'] = 3;
        kb['e'] = 1; kb['E'] = 1; kb['d']  = 2; kb['D'] = 2; kb['c'] = 3; kb['C'] = 3;
        kb['r'] = 1; kb['R'] = 1; kb['f']  = 2; kb['F'] = 2; kb['v'] = 3; kb['V'] = 3;
        kb['t'] = 1; kb['T'] = 1; kb['g']  = 2; kb['G'] = 2; kb['b'] = 3; kb['B'] = 3;
        kb['y'] = 1; kb['Y'] = 1; kb['h']  = 2; kb['H'] = 2; kb['n'] = 3; kb['N'] = 3;
        kb['u'] = 1; kb['U'] = 1; kb['j']  = 2; kb['J'] = 2; kb['m'] = 3; kb['M'] = 3;
        kb['i'] = 1; kb['I'] = 1; kb['k']  = 2; kb['K'] = 2; kb[','] = 3;
        kb['o'] = 1; kb['O'] = 1; kb['l']  = 2; kb['L'] = 2; kb['<'] = 3;
        kb['p'] = 1; kb['P'] = 1; kb[';']  = 2;              kb['.'] = 3;
        kb['{'] = 1;              kb[':']  = 2;              kb['>'] = 3;
        kb['['] = 1;              kb['\''] = 2;              kb['/'] = 3;
        kb['}'] = 1;              kb['"']  = 2;              kb['?'] = 3;
        kb[']'] = 1;
        KEYBOARD = kb;
        // @formatter:on

    }

    private static String find(String word) {
        final int line = KEYBOARD[word.charAt(0)];
        for (int i = 1; i < word.length(); i++)
            if (line != KEYBOARD[word.charAt(i)])
                return null;
        return word;
    }

    public String[] findWords(String[] words) {
        int    cursor = 0;
        String word;
        for (int i = 0; i < words.length; i++)
            if ((word = find(words[i])) != null)
                words[cursor++] = word;
        return cursor == 0
                ? new String[0]
                : (cursor != words.length ? Arrays.copyOf(words, cursor) : words);
    }
}
