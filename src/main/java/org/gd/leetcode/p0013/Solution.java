package org.gd.leetcode.p0013;


public class Solution {

    public int romanToInt(String s) {
        int length = s.length();
        switch (length) {
            case 0: return 0;
            case 1: return RomanUnit.of(s.charAt(0)).value;
        }

        RomanUnit current;
        int       i   = 0;
        int       before;
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
