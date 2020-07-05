package org.gd.leetcode.p0068;

import org.gd.leetcode.common.LeetCode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * https://leetcode.com/problems/text-justification/
 *
 * @author Horkhover D.
 * @since 2020-07-05.07.2020
 */
@LeetCode(
        name = "Text Justification",
        difficulty = LeetCode.Level.HARD,
        state = LeetCode.State.DONE,
        tags = LeetCode.Tags.STRING
)
class Solution {

    public List<String> fullJustify(String[] words, int maxWidth) {
        return Lines.ofLineCapacity(maxWidth).addAll(words).toListStrings();
    }

    static class Lines {

        private final int lineCapacity;
        private final ArrayList<Line> lines;

        private Line line = null;

        private Lines(int lineCapacity) {
            this.lineCapacity = lineCapacity;
            lines = new ArrayList<>();
        }

        static Lines ofLineCapacity(int lineCapacity) {
            return new Lines(lineCapacity);
        }

        Lines addAll(String... words) {
            if (words == null || words.length == 0)
                return this;

            for (String word : words)
                add(word);

            return this;
        }

        Lines add(String word) {
            if (line == null)
                lines.add(line = new Line(lineCapacity));

            if (!line.add(word)) {
                line = null;
                return add(word);
            }
            return this;
        }

        List<String> toListStrings() {
            final int linesCount = lines.size();
            final ArrayList<String> justifyList = new ArrayList<>(linesCount);
            int index = 0;
            for (Line value : lines) {
                justifyList.add(value.toJustifyString(index == linesCount - 1));
                index++;
            }
            return justifyList;
        }
    }

    static class Line {

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
            int spacesOverall = capacity - length;
            int extraSpaces = spacesOverall % spaceCount;
            int spaceLength = spacesOverall / spaceCount;

            Iterator<String> iterator = words.iterator();
            StringBuilder sb = new StringBuilder(capacity);
            sb.append(iterator.next());
            while (iterator.hasNext()) {
                writeSpaces(sb, spaceLength + (extraSpaces > 0 ? 1 : 0));
                extraSpaces--;
                sb.append(iterator.next());
            }
            return sb.toString();
        }
    }
}
