package org.gd.leetcode.p0093;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * TODO: https://leetcode.com/problems/restore-ip-addresses/
 *
 * @author Gorkhover D.
 * @since 2018-10-23
 */
class Solution {

    Solution() {}

    private static int v0(String s, int index) { return s.charAt(index) - 48; }

    private static boolean isv(int value) { return 0 <= value && value <= 255;}

    private static int value(String s, int start, int end) {
        switch ((end = Math.min(end, s.length())) - start) {
            case 0: return 0;
            case 1: return v0(s, start);
            case 2: return v0(s, start) * 10 + v0(s, start + 1);
            case 3: return v0(s, start) * 100 + v0(s, start + 1) * 10 + v0(s, start + 2);
        }
        int sum = 0;
        for (int i = start; i < end; i++)
            sum = sum * 10 + v0(s, i);
        return sum;
    }

    private static List<String> restoreIpAddresses(List<String> list,
                                                   String source,
                                                   String prefix,
                                                   int sourcePos,
                                                   int ipPos) {
        int length = source.length(), value = 0;
        if (ipPos == 3) {
            if (isv(value = value(source, sourcePos, length)))
                list.add(prefix + "." + value);
        } else {

            int i = 0,
                    minRemains = 3 - ipPos,
                    maxRemains = minRemains * 3;
            while (i < 3 && ((length - sourcePos) - minRemains >= 4)) {

                if (isv(value = value * 10 + v0(source, sourcePos))) {

                    System.out.println(value);

                }
                sourcePos++;
                i++;
            }

            int remains = length - sourcePos;


        }


        return list;
    }

    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12)
            return Collections.emptyList();
        switch (s.length()) {
            case 12: {
                final int[] ip = new int[4];
                if (isv(ip[0] = value(s, 0, 3)) && isv(ip[1] = value(s, 3, 6)) && isv(ip[2] = value(s, 6, 9)) && isv(ip[3] = value(s, 9, 12)))
                    return Collections.singletonList(ip[0] + "." + ip[1] + "." + ip[2] + "." + ip[3]);
                return Collections.emptyList();
            }
            case 4: {
                final int[] ip = new int[4];
                if (isv(ip[0] = v0(s, 0)) && isv(ip[1] = v0(s, 1)) && isv(ip[2] = v0(s, 2)) && isv(ip[3] = v0(s, 3)))
                    return Collections.singletonList(ip[0] + "." + ip[1] + "." + ip[2] + "." + ip[3]);
                return Collections.emptyList();
            }
        }

        return restoreIpAddresses(new ArrayList<>(), s, "", 0, 0);
    }
}
