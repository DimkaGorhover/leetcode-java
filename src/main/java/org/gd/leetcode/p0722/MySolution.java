package org.gd.leetcode.p0722;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Horkhover Dmytro
 * @since 2022-01-25
 */
class MySolution implements Solution {

    @Override
    public List<String> removeComments(String[] source) {

        if (source == null) {
            return null;
        }

        if (source.length == 0) {
            return Collections.emptyList();
        }

        StringBuilder sb = new StringBuilder().append(source[0]);
        int maxLengthLine = source[0].length();
        for (int i = 1; i < source.length; i++) {
            String line = source[i];
            maxLengthLine = Math.max(maxLengthLine, line.length());
            sb.append('\n').append(line);
        }

        String text = replaceComments(joinLines(source));

        return toLinesList(text, maxLengthLine, source.length);
    }

    private static String joinLines(String[] source) {
        StringBuilder sb = new StringBuilder()
                .append(source[0]);
        for (int i = 1; i < source.length; i++) {
            sb.append('\n').append(source[i]);
        }
        return sb.toString();
    }

    private static List<String> toLinesList(String text, int linesCount, int length) {
        ArrayList<String> list = new ArrayList<>(linesCount);
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == '\n') {
                list.add(sb.toString());
                sb.setLength(0);
                continue;
            }
            sb.append(c);
        }
        return list;
    }

    private static String replaceComments(String text) {

        if (text == null) {
            return null;
        }

        final int length = text.length();
        if (length == 0) {
            return "";
        }

        char[] sb = new char[length];
        int sbCursor = 0;

        char quot = 0;
        boolean comment = false;
        for (int i = 0; i < length; i++) {

            char currentChar = text.charAt(i);
            char prevChar = i > 0 ? text.charAt(i - 1) : 0;

            // remove whole line if it starts with "//" or "--"
            if (isComment(prevChar, currentChar)) {
                while (i < length && text.charAt(i) != '\n') i++;
                sbCursor = Math.max(0, sbCursor - 1);
                continue;
            }

            if (!comment && isQuot(currentChar)) {
                if (quot == 0) {
                    quot = currentChar;
                } else {
                    if (quot == currentChar) {
                        quot = 0;
                    }
                }
            }

            if (quot == 0 && prevChar == '/' && currentChar == '*') {
                comment = true;
                sbCursor--;
                continue;
            }

            if (quot == 0 && prevChar == '*' && currentChar == '/') {
                comment = false;
                continue;
            }

            if (!comment) {
                if (currentChar == '\n') {
                    while ((sbCursor - 1) >= 0 && sb[sbCursor - 1] == ' ') {
                        sbCursor--;
                    }
                }
                sb[sbCursor++] = currentChar;
            }
        }

        return new String(sb, 0, sbCursor);
    }

    private static boolean isComment(char prev, char next) {
        return (prev == '-' && next == '-') || (prev == '/' && next == '/');
    }

    private static boolean isQuot(char c) {
        return c == '\'' || c == '"';
    }
}
