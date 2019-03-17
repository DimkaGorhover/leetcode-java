package org.gd.hackerrank.leverton;

import java.util.*;

/**
 * @author Horkhover Dmytro
 * @since 2019-03-06
 */
class Voting {

    static String electionWinner(String[] votes) {
        ArrayList<SortedSet<String>> list = new ArrayList<>();
        Map<String, Integer>         map  = new HashMap<>();
        SortedSet<String>            level;
        for (String vote : votes) {
            int count = map.compute(vote, (ignore, votesCount) -> (votesCount == null ? 0 : votesCount) + 1);
            if (list.size() < count) {
                list.add(level = new TreeSet<>());
            } else {
                level = list.get(count - 1);
            }
            level.add(vote);
        }
        return list.get(list.size() - 1).last();
    }
}
