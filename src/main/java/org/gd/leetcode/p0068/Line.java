package org.gd.leetcode.p0068;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Horkhover D.
 * @since 2020-07-05.07.2020
 */
@SuppressWarnings("StringRepeatCanBeUsed")
class Line {

    private final int capacity;
    private final ArrayList<String> words;

    private int length;
    private int minLength = 0;

    Line(int capacity) {
        this.capacity = capacity;
        words = new ArrayList<>();
    }

    boolean add(String word) {
        if (words.isEmpty()) {

            if (word.length() > capacity)
                throw new IllegalArgumentException();

            words.add(word);
            length = minLength = word.length();
            return true;
        }

        final int newMinLength = minLength + 1 + word.length();
        if (newMinLength > capacity)
            return false;

        words.add(word);
        length += word.length();
        minLength = newMinLength;
        return true;
    }

    private static void writeSpaces(StringBuilder sb, int count) {
        for (int i = 0; i < count; i++)
            sb.append(' ');
    }

    private String singleWordToString() {
        String word = words.get(0);
        StringBuilder sb = new StringBuilder();
        sb.append(word);
        writeSpaces(sb, capacity - word.length());
        return sb.toString();
    }

    private String evenSpaces(int spaces) {
        Iterator<String> iterator = words.iterator();

        StringBuilder sb = new StringBuilder(capacity)
                .append(iterator.next());
        while (iterator.hasNext()) {
            writeSpaces(sb, spaces);
            sb.append(iterator.next());
        }

        return sb.toString();
    }

    private String lastLine() {
        StringBuilder sb = new StringBuilder(capacity);
        Iterator<String> iterator = words.iterator();
        String next = iterator.next();
        int length = next.length();
        sb.append(next);
        while (iterator.hasNext()) {
            next = iterator.next();
            sb.append(' ').append(next);
            length += 1 + next.length();
        }
        writeSpaces(sb, capacity - length);
        return sb.toString();
    }

    String toJustifyString(boolean isLast) {

        if (words.size() == 1)
            return singleWordToString();

        if (isLast)
            return lastLine();

        int spaceCount = words.size() - 1;
        int space = capacity - length;
        int extraSpaces = space % spaceCount;
        int spaceLength = space / spaceCount;

        if (extraSpaces == 0)
            return evenSpaces(spaceLength);

        Iterator<String> iterator = words.iterator();
        StringBuilder sb = new StringBuilder(capacity);
        sb.append(iterator.next());
        while (iterator.hasNext()) {
            writeSpaces(sb, spaceLength + (extraSpaces > 0 ? 1 : 0));
            spaceLength--;
            sb.append(iterator.next());
        }
        return sb.toString();
    }
}
