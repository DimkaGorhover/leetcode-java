package org.gd.leetcode.p0622;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/design-circular-queue/
 */
@LeetCode(
        name = "Design Circular Queue",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.DESIGN,
                LeetCode.Tags.QUEUE
        }
)
interface MyCircularQueue {

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    boolean enQueue(int value);

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    boolean deQueue();

    /**
     * Get the front item from the queue.
     */
    int Front();

    /**
     * Get the last item from the queue.
     */
    int Rear();

    /**
     * Checks whether the circular queue is empty or not.
     */
    boolean isEmpty();

    /**
     * Checks whether the circular queue is full or not.
     */
    boolean isFull();
}
