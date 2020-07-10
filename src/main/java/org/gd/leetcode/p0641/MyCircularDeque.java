package org.gd.leetcode.p0641;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/design-circular-deque/
 *
 * @see org.gd.leetcode.p0622.MyCircularQueue
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Design Circular Deque",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.DESIGN,
                LeetCode.Tags.QUEUE
        }
)
interface MyCircularDeque {

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    boolean insertFront(int value);

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    boolean insertLast(int value);

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    boolean deleteFront();

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    boolean deleteLast();

    /**
     * Get the front item from the deque.
     */
    int getFront();

    /**
     * Get the last item from the deque.
     */
    int getRear();

    /**
     * Checks whether the circular deque is empty or not.
     */
    boolean isEmpty();

    /**
     * Checks whether the circular deque is full or not.
     */
    boolean isFull();
}
