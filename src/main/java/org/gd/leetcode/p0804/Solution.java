package org.gd.leetcode.p0804;

import org.gd.leetcode.common.Difficulty;

import java.util.HashSet;

/**
 * https://leetcode.com/problems/unique-morse-code-words/
 *
 * @author Horkhover Dmytro
 * @since 2018-12-28
 */
@Difficulty(Difficulty.Level.EASY)
class Solution {

    private static final String[] MORSE = {
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
            ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
            "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."
    };

    public int uniqueMorseRepresentations(String[] words) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            final StringBuilder sb = new StringBuilder(word.length() * 4);
            for (int j = 0; j < word.length(); j++)
                sb.append(MORSE[word.charAt(j) - 'a']);
            set.add(sb.toString());
        }
        return set.size();
    }
}
