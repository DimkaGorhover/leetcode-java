package org.gd.leetcode.p0707;

import org.gd.leetcode.common.LeetCode;

import java.util.*;

@LeetCode(
        name = "Design Linked List",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.DESIGN,
                LeetCode.Tags.LINKED_LIST
        }
)
class MyLinkedList implements Iterable<Integer>, IMyLinkedList {

    private Node head, tail;
    private int size = 0;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {}

    private Node getNode(int index) {
        int size = this.size;
        if (index == 0) return head;
        if (index == size - 1) return tail;
        if (index >= size) return null; // throw new IndexOutOfBoundsException();

        Node node;
        if (index < (size >> 1)) {
            node = head;
            while (index-- > 0)
                node = node.right;
        } else {
            node = tail;
            index = size - index - 1;
            while (index-- > 0)
                node = node.left;
        }
        return node;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    @Override
    public int get(int index) {
        Node node = getNode(index);
        return node == null ? -1 : node.value;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be
     * the first node of the linked list.
     */
    @Override
    public void addAtHead(int val) {
        int size = this.size;
        if (head == null) {
            head = tail = new Node(val);
            this.size = size + 1;
            return;
        }
        head = new Node(val).insertBefore(head);
        this.size = size + 1;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    @Override
    public void addAtTail(int val) {
        int size = this.size;
        if (tail == null) {
            head = tail = new Node(val);
            this.size = size + 1;
            return;
        }
        tail = new Node(val).insertAfter(tail);
        this.size = size + 1;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked
     * list, the node will be appended to the end of linked list. If index is greater than the length, the node will not
     * be inserted.
     */
    @Override
    public void addAtIndex(int index, int val) {
        int size = this.size;
        if (index < 0 || index > size)
            return; // throw new IndexOutOfBoundsException();

        if (index == 0) {
            addAtHead(val);
        } else if (index == size) {
            addAtTail(val);
        } else {
            new Node(val).insertBefore(getNode(index));
            this.size = size + 1;
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    @SuppressWarnings("ConstantConditions")
    @Override
    public void deleteAtIndex(int index) {
        int size = this.size;
        if (index < 0 || size == 0 || index >= size)
            return; // throw new IndexOutOfBoundsException();

        if (size == 1) {
            head = tail = null;
            this.size = 0;
            return;
        }
        Node node = getNode(index);

        if (node == head) head = node.right;
        if (node == tail) tail = node.left;

        node.unlink();
        this.size = size - 1;
    }

    public int size() { return size; }

    @Override
    public int hashCode() {
        int hash = 1;
        if (head == null)
            return hash;
        Node node = head;
        while (node != null) {
            hash = hash * 31 + node.hashCode();
            node = node.right;
        }
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (obj instanceof Collection) {
            if (size() != ((Collection) obj).size())
                return false;
        }
        if (obj instanceof Iterable) {
            Iterator<Integer> itr0 = iterator();
            Iterator<Object> itr1 = ((Iterable) obj).iterator();
            while (itr0.hasNext() && itr1.hasNext()) {
                if (!Objects.equals(itr0.next(), itr1.next()))
                    return false;
            }
            return itr0.hasNext() == itr1.hasNext();
        }
        return false;
    }

    @Override
    public String toString() {
        if (size == 0)
            return "[]";
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        Node node = head;
        while (node != null) {
            sj.add(node.toString());
            node = node.right;
        }
        return sj.toString();
    }

    @Override
    public Iterator<Integer> iterator() {
        return head == null ? Collections.emptyIterator() : new Itr(head);
    }
}
