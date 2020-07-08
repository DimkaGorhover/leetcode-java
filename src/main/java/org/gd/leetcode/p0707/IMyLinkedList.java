package org.gd.leetcode.p0707;

public interface IMyLinkedList {

    static MyLinkedList of(int... values) {
        MyLinkedList ll = new MyLinkedList();
        for (int value : values)
            ll.addAtTail(value);
        return ll;
    }

    int get(int index);

    void addAtHead(int val);

    void addAtTail(int val);

    void addAtIndex(int index, int val);

    void deleteAtIndex(int index);
}
