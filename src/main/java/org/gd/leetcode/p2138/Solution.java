package org.gd.leetcode.p2138;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/divide-a-string-into-groups-of-size-k/
 *
 * @author Horkhover Dmytro
 * @since 2022-01-20
 */
@LeetCode(
        name = "Divide a String Into Groups of Size k",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.STRING,
                LeetCode.Tags.SIMULATION
        }
)
class Solution {

    public String[] divideString(String s, int k, char fill) {
        if (s == null) {
            s = "";
        }

        int stringLength = s.length();
        int length = (stringLength / k) + (stringLength % k > 0 ? 1 : 0);

        String[] strings = new String[length];
        char[] chars = new char[k];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < k; j++) {
                int pos = i * k + j;
                char c = pos < stringLength ? s.charAt(pos) : fill;
                chars[j] = c;
            }
            strings[i] = new String(chars);
        }

        return strings;
    }
}
