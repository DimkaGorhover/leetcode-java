package org.gd.apptopia;

import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Horkhover Dmytro
 * @since 2020-08-20
 */
public class Heap {

    private final PriorityQueue<Entry> heap;

    public Heap(List<Entry> entries) {
        heap = new PriorityQueue<>(entries);
    }

    public void add(Entry entry) {
        if (entry != null)
            heap.add(entry);
    }

    public Entry poll() {
        Entry entry = heap.poll();
        if (entry != null)
            add(entry.next());
        return entry;
    }
}
