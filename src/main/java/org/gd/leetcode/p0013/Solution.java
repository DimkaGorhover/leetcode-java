package org.gd.leetcode.p0013;


import org.gd.leetcode.common.LeetCode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/roman-to-integer/
 *
 * @see org.gd.leetcode.p0012.Solution
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Roman to Integer",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.MATH,
                LeetCode.Tags.STRING
        }
)
class Solution {

    private static final byte  OFFSET = 67;
    private static final int[] VALUES;
    private static final int[] PAIR;

    static {
        final int length = 88 - OFFSET + 1;

        VALUES = new int[length];
        VALUES['I' - OFFSET] = 1;
        VALUES['V' - OFFSET] = 5;
        VALUES['X' - OFFSET] = 10;
        VALUES['L' - OFFSET] = 50;
        VALUES['C' - OFFSET] = 100;
        VALUES['D' - OFFSET] = 500;
        VALUES['M' - OFFSET] = 1000;

        PAIR = new int[length];
        Arrays.fill(PAIR, -1);
        PAIR['V' - OFFSET] = 'I' - OFFSET;
        PAIR['X' - OFFSET] = 'I' - OFFSET;
        PAIR['L' - OFFSET] = 'X' - OFFSET;
        PAIR['C' - OFFSET] = 'X' - OFFSET;
        PAIR['D' - OFFSET] = 'C' - OFFSET;
        PAIR['M' - OFFSET] = 'C' - OFFSET;
    }

    private static int value(int c) {
        return (c -= OFFSET) < 0 || c >= VALUES.length ? 0 : VALUES[c];
    }

    private static boolean isPair(int c1, int c2) {
        return PAIR[c2 - OFFSET] == c1 - OFFSET;
    }

    public int romanToInt(String s) {
        final int length = s.length();
        switch (length) {
            case 0: return 0;
            case 1: return value(s.charAt(0));
            case 2: {
                final char c1 = s.charAt(0), c2 = s.charAt(1);
                return isPair(c1, c2) ? (value(c2) - value(c1)) : (value(c2) + value(c1));
            }
        }
        int i   = 0;
        int sum = 0;
        int c1, c2;
        while (i < length - 1) {
            if (isPair(c1 = s.charAt(i), c2 = s.charAt(i + 1))) {
                sum += (value(c2) - value(c1));
                i += 2;
            } else {
                sum += value(c1);
                i++;
            }
        }
        if (i < length)
            sum += value(s.charAt(i));
        return sum;
    }
}

/*
class Solution {
    public int romanToInt(String s) {
        int before, length = s.length();
        switch (length) {
            case 0: return 0;
            case 1: return RomanUnit.of(s.charAt(0)).value;
            case 2:
                final RomanUnit r1 = RomanUnit.of(s.charAt(0));
                final RomanUnit r2 = RomanUnit.of(s.charAt(1));
                return ((before = r1.before(r2)) > 0) ? before : r1.value + r2.value;
        }

        RomanUnit current;
        int       i   = 0;
        long      sum = 0;
        while (i < length - 1) {
            if ((before = (current = RomanUnit.of(s.charAt(i))).before(RomanUnit.of(s.charAt(i + 1)))) > 0) {
                sum += before;
                i += 2;
            } else {
                sum += current.value;
                i++;
            }
        }
        if (i < length) sum += RomanUnit.of(s.charAt(i)).value;

        return Math.toIntExact(sum);
    }

    enum RomanUnit {
        ONE('I', 1) {
            @Override
            int before(RomanUnit u) {
                switch (u) {
                    case FIVE: return (FIVE.value - value);
                    case TEN: return (TEN.value - value);
                }
                return 0;
            }
        },
        FIVE('V', 5),
        TEN('X', 10) {
            @Override
            int before(RomanUnit u) {
                switch (u) {
                    case FIFTY: return (FIFTY.value - value);
                    case ONE_HUNDRED: return (ONE_HUNDRED.value - value);
                }
                return 0;
            }
        },
        FIFTY('L', 50),
        ONE_HUNDRED('C', 100) {
            @Override
            int before(RomanUnit u) {
                switch (u) {
                    case D: return (D.value - value);
                    case M: return (M.value - value);
                }
                return 0;
            }
        },
        D('D', 500),
        M('M', 1000),

        ZERO(' ', 0);

        final char literal;
        final int  value;

        RomanUnit(char literal, int value) {
            this.literal = literal;
            this.value = value;
        }

        static RomanUnit of(char c) {
            switch (c) {
                case 'I': return ONE;
                case 'V': return FIVE;
                case 'X': return TEN;
                case 'L': return FIFTY;
                case 'C': return ONE_HUNDRED;
                case 'D': return D;
                case 'M': return M;
            }
            return ZERO;
        }

        int before(RomanUnit u) { return -1; }
    }
}
 */
