package org.gd.leetcode.common;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Horkhover Dmytro
 * @since 2018-12-20
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface LeetCode {

    String name() default "";

    Level difficulty();

    State state() default State.UNKNOWN;

    Tags[] tags() default {};

    enum State {TODO, FIXME, DONE, PAID, UNKNOWN}

    enum Level {EASY, MEDIUM, HARD}

    enum Tags {

        ARRAY("Array"),
        CONCURRENCY("Concurrency"),
        DYNAMIC_PROGRAMMING("Dynamic Programming"),
        STRING("String"),
        MATH("Math"),
        TREE("Tree"),
        HASH_TABLE("Hash Table"),
        HASH_FUNCTION("Hash Function"),
        DEPTH_FIRST_SEARCH("Depth-first Search"),
        BINARY_SEARCH("Binary Search"),
        TWO_POINTERS("Two Pointers"),
        BREADTH_FIRST_SEARCH("Breadth-first Search"),
        GREEDY("Greedy"),
        STACK("Stack"),
        MONOTONIC_STACK("Monotonic Stack"),
        BACKTRACKING("Backtracking"),
        DESIGN("Design"),
        LINKED_LIST("Linked List"),
        BIT_MANIPULATION("Bit Manipulation"),
        HEAP("Heap"),
        GRAPH("Graph"),
        SORT("Sort"),
        UNION_FIND("Union Find"),
        DIVIDE_AND_CONQUER("Divide and Conquer"),
        BINARY_SEARCH_TREE("Binary Search Tree"),
        BINARY_TREE("Binary Tree"),
        TRIE("Trie"),
        RECURSION("Recursion"),
        QUEUE("Queue"),
        /**
         * https://www.geeksforgeeks.org/segment-tree-set-1-sum-of-given-range/
         *
         * @see org.gd.common.SegmentTree
         */
        SEGMENT_TREE("Segment Tree"),
        RANDOM("Random"),
        BINARY_INDEXED_TREE("Binary Indexed Tree"),
        MINIMAX("Minimax"),
        TOPOLOGICAL_SORT("Topological Sort"),
        BRAINTEASER("Brainteaser"),
        GEOMETRY("Geometry"),
        MAP("Map"),
        SLIDING_WINDOW("Sliding Window"),
        REJECTION_SAMPLING("Rejection Sampling"),
        RESERVOIR_SAMPLING("Reservoir Sampling"),
        MEMOIZATION("Memoization"),
        ENUMERATION("Enumeration"),

        QUICK_SELECT("Quick Select"),
        DATA_STREAM("Data Stream"),
        SIMULATION("Simulation");

        public final String name;

        Tags(String name) { this.name = name; }

        String getName() { return name; }
    }
}
