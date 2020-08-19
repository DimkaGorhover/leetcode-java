package org.gd.leetcode.p0824;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/goat-latin/
 *
 * @author Horkhover Dmytro
 * @since 2020-08-19
 */
@LeetCode(
        name = "Goat Latin",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = LeetCode.Tags.STRING
)
class Solution {

    private static final boolean[] VOWEL = new boolean[118];

    private final char[] word = new char[153];

    private StringBuilder sb;
    private int wordStart;
    private int wordLength;
    private int aCount;
    private boolean firstWord;

    static {
        VOWEL[65] = true;
        VOWEL[69] = true;
        VOWEL[73] = true;
        VOWEL[79] = true;
        VOWEL[85] = true;
        VOWEL[97] = true;
        VOWEL[101] = true;
        VOWEL[105] = true;
        VOWEL[111] = true;
        VOWEL[117] = true;
    }

    private static boolean isVowel(char c) {
        return c < VOWEL.length && VOWEL[c];
    }

    private void add(char c) {
        word[wordLength++] = c;
    }

    private void flush() {
        if (wordLength > 0) {

            if (!isVowel(word[0])) {
                wordStart++;
                word[wordLength++] = word[0];
            }
            word[wordLength++] = 'm';
            word[wordLength++] = 'a';

            for (int j = 0; j < aCount; j++)
                word[wordLength++] = 'a';

            if (!firstWord)
                sb.append(' ');

            sb.append(word, wordStart, wordLength - wordStart);

            firstWord = false;
            wordLength = 0;
            wordStart = 0;
            aCount++;
        }
    }

    private void reset() {
        sb = new StringBuilder();
        wordStart = 0;
        wordLength = 0;
        aCount = 1;
        firstWord = true;
    }

    public String toGoatLatin(String text) {
        if (text == null || text.isEmpty())
            return text;

        reset();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == ' ') {
                flush();
            } else {
                add(c);
            }
        }

        flush();

        return sb.toString();
    }
}
