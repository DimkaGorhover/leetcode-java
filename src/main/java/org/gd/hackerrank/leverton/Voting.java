package org.gd.hackerrank.leverton;

import java.util.*;

/**
 * @author Horkhover Dmytro
 * @since 2019-03-06
 */
class Voting {

    static String electionWinner(String[] votes) {
        List<SortedSet<String>> list = new ArrayList<>();
        Map<String, Integer>    map  = new HashMap<>();
        for (int i = 0; i < votes.length; i++) {
            int count = map.compute(votes[i], (s, c) -> (c == null ? 0 : c) + 1);
            if (list.size() < count) list.add(new TreeSet<>());
            list.get(count - 1).add(votes[i]);
        }
        return list.get(list.size() - 1).last();
    }
}
