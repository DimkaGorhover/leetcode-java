package org.gd.leetcode.common;

import lombok.RequiredArgsConstructor;

import java.lang.annotation.*;

/**
 * @author Horkhover Dmytro
 * @since 2018-12-20
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface LeetCode {

    Level difficulty();

    Tags[] tags() default {};

    @RequiredArgsConstructor
    enum Level {EASY, MEDIUM, HARD}

    @RequiredArgsConstructor
    enum Tags {

        ARRAY("Array"),
        DYNAMIC_PROGRAMMING("Dynamic Programming"),
        STRING("String"),
        MATH("Math"),
        TREE("Tree"),
        HASH_TABLE("Hash Table"),
        DEPTH_FIRST_SEARCH("Depth-first Search"),
        BINARY_SEARCH("Binary Search"),
        TWO_POINTERS("Two Pointers"),
        BREADTH_FIRST_SEARCH("Breadth-first Search"),
        GREEDY("Greedy"),
        STACK("Stack"),
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
        TRIE("Trie"),
        RECURSION("Recursion"),
        QUEUE("Queue"),
        SEGMENT_TREE("Segment Tree"),
        RANDOM("Random"),
        BINARY_INDEXED_TREE("Binary Indexed Tree"),
        MINIMAX("Minimax"),
        TOPOLOGICAL_SORT("Topological Sort"),
        BRAINTEASER("Brainteaser"),
        GEOMETRY("Geometry"),
        MAP("Map"),
        REJECTION_SAMPLING("Rejection Sampling"),
        RESERVOIR_SAMPLING("Reservoir Sampling"),
        MEMOIZATION("Memoization");

        public final String name;
    }
}
