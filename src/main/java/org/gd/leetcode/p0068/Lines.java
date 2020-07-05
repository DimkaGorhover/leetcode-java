package org.gd.leetcode.p0068;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Horkhover D.
 * @since 2020-07-05.07.2020
 */
class Lines {

    private final int lineCapacity;
    private final ArrayList<Line> lines;

    private Line line = null;

    Lines(int lineCapacity) {
        this.lineCapacity = lineCapacity;
        lines = new ArrayList<>();
    }

    void add(String word) {
        if (line == null)
            lines.add(line = new Line(lineCapacity));

        if (!line.add(word)) {
            line = null;
            add(word);
        }
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
