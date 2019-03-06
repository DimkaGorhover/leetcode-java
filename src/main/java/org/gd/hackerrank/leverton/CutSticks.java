package org.gd.hackerrank.leverton;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Horkhover Dmytro
 * @since 2019-03-06
 */
class CutSticks {

    private CutSticks() { throw new UnsupportedOperationException(); }

    static List<Integer> cutSticks(List<Integer> list) {

        final ArrayList<Integer> newLengths = new ArrayList<>(list.size() - 1);
        final Iterator<Integer>  iterator   = list.iterator();

        if (iterator.hasNext())
            iterator.next(); // first element > /dev/null

        int min = Integer.MAX_VALUE;
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            min = Math.min(min, i);
            newLengths.add(i);
        }

        list = newLengths;
        int len = list.size(), v, nextMin = Integer.MAX_VALUE;
        List<Integer> result = new ArrayList<>(), current = new ArrayList<>();

        while (len > 0) {
            result.add(len);
            for (Integer i : list)
                if ((v = i - min) > 0) {
                    current.add(v);
                    nextMin = Math.min(nextMin, v);
                }
            len = current.size();
            if (len > 0) {
                list = current;
                current = new ArrayList<>();
                min = nextMin;
                nextMin = Integer.MAX_VALUE;
            }
        }
        return result;
    }
}
