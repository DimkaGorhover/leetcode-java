package org.gd.leetcode.p0138;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Horkhover Dmytro
 * @since 2020-08-16
 */
class Node {

    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    static Node of(int... arr) {
        if (arr == null || arr.length == 0)
            return null;

        Node head = new Node(arr[0]);
        ArrayList<Node> list = new ArrayList<>();
        Node node = head;
        list.add(node);

        for (int i = 1; i < arr.length; i++) {
            node.next = new Node(arr[i]);
            list.add(node.next);
            node = node.next;
        }

        Collections.shuffle(list, ThreadLocalRandom.current());

        node = head;
        for (int i = 0; i < arr.length; i++) {
            node.random = list.get(i);
            node = node.next;
        }

        return head;
    }

    @Override
    public String toString() {

        String str = String.format("(%d)", val);

        if (random != null)
            str = String.format("(%d [rnd: %d])", val, random.val);

        return str;
    }
}
