package org.gd.leetcode.p0151;

class Solution1 {

    public String reverseWords(String s) {

        if (s == null || s.isEmpty())
            return "";

        final StringBuilder sb = new StringBuilder(s.length());
        final char[] buffer = new char[s.length()];
        final int lastIndex = s.length() - 1;

        int bufferIndex = lastIndex;
        boolean firstWord = true;

        for (int i = lastIndex; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ' ') {

                if (bufferIndex < lastIndex) {
                    if (firstWord) {
                        firstWord = false;
                    } else {
                        sb.append(' ');
                    }
                    sb.append(buffer, bufferIndex + 1, lastIndex - bufferIndex);
                    bufferIndex = lastIndex;
                }

            } else {
                buffer[bufferIndex] = c;
                bufferIndex--;
            }
        }

        if (bufferIndex < lastIndex) {
            if (!firstWord)
                sb.append(' ');
            sb.append(buffer, bufferIndex + 1, lastIndex - bufferIndex);
        }

        return sb.toString();
    }
}
