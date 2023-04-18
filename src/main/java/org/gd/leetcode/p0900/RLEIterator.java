package org.gd.leetcode.p0900;

import org.gd.leetcode.common.LeetCode;

/**
 * <a href="https://leetcode.com/problems/rle-iterator/">LeetCode #900: RLE Iterator</a>
 *
 * @author Horkhover Dmytro
 * @since 2023-04-18
 */
@LeetCode(
        name = "RLE Iterator",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.TODO,
        tags = {
                LeetCode.Tags.DESIGN,
                LeetCode.Tags.ARRAY,
                LeetCode.Tags.COUNTING,
                LeetCode.Tags.ITERATOR,
        }
)
class RLEIterator {

    private final int[] encoding;
    private int cursor = 0;

    public RLEIterator(int[] encoding) {
        this.encoding = encoding;
    }

    public int next(int n) {
        while (cursor < encoding.length) {

            if (n > encoding[cursor]) {
                n -= encoding[cursor];
                cursor += 2;
                continue;
            }

            if (n == encoding[cursor]) {
                cursor += 2;
                return encoding[cursor - 1];
            }

            encoding[cursor] -= n;
            return encoding[cursor + 1];
        }

        return -1;
    }
}
