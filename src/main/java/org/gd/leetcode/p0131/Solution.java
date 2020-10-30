package org.gd.leetcode.p0131;

import org.gd.leetcode.common.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Horkhover D.
 * @since 2020-07-13
 */
@LeetCode(
        name = "Palindrome Partitioning",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.BACKTRACKING
        }
)
class Solution {

    private List<List<String>> result;

    private static boolean isPalindrome(String word) {
        final int length = word.length();
        if (length == 0)
            return false;
        if (length == 1)
            return true;
        int mid = length >> 1;
        for (int i = 0; i <= mid; i++) {
            int j = length - 1 - i;
            if (word.charAt(i) != word.charAt(j))
                return false;
        }
        return true;
    }

    private static List<String> add(List<String> list, String word) {
        if (list == null || list.isEmpty())
            return Collections.singletonList(word);

        if (list.size() == 1)
            return Arrays.asList(list.get(0), word);

        ArrayList<String> newList = new ArrayList<>(list.size() + 1);
        newList.addAll(list);
        newList.add(word);
        return Collections.unmodifiableList(newList);
    }

    private void partition(final List<String> list,
                           final String word) {

        final int wordLength = word.length();
        if (wordLength == 0) {
            result.add(list);
            return;
        }
        if (wordLength == 1) {
            result.add(add(list, word));
            return;
        }

        for (int i = 1; i <= wordLength; i++) {
            String ss = word.substring(0, i);
            if (isPalindrome(ss))
                partition(add(list, ss), word.substring(i, wordLength));
        }
    }

    public List<List<String>> partition(String word) {
        result = new ArrayList<>();
        partition(Collections.emptyList(), word);
        return result;
    }
}
