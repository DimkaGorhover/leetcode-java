package org.gd.leetcode.p1472;

import org.gd.leetcode.common.LeetCode;

import java.util.ArrayList;
import java.util.StringJoiner;

/**
 * https://leetcode.com/problems/design-browser-history/
 */
@LeetCode(
        name = "Design Browser History",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = LeetCode.Tags.DESIGN
)
class BrowserHistory {

    private final ArrayList<String> history;

    private int cursor;
    private int size;

    public BrowserHistory(String homepage) {
        history = new ArrayList<>();
        history.add(homepage);
        cursor = 0;
        size = 1;
    }

    public void visit(String url) {
        cursor++;
        if (cursor == history.size()) {
            history.add(url);
        } else {
            history.set(cursor, url);
        }
        size = cursor + 1;
    }

    public String back(int steps) {
        cursor = Math.max(0, cursor - steps);
        return history.get(cursor);
    }

    public String forward(int steps) {
        cursor = Math.min(size - 1, cursor + steps);
        return history.get(cursor);
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < size; i++) {
            String url = history.get(i);
            if (i == cursor) {
                sj.add("(" + url + ")");
            } else {
                sj.add(url);
            }
        }
        return sj.toString();
    }
}
