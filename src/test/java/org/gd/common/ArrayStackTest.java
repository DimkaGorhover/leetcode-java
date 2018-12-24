package org.gd.common;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link ArrayStack};
 *
 * @author Horkhover Dmytro
 * @since 2018-12-23
 */
class ArrayStackTest {

    @Test
    @DisplayName("Size")
    void test_Size() {
        final ArrayStack<Integer> stack = new ArrayStack<>();
        stack.add(1);
        assertEquals(1, stack.size());
        stack.add(2);
        assertEquals(2, stack.size());
        stack.pop();
        assertEquals(1, stack.size());
        stack.pop();
        assertEquals(0, stack.size());
        stack.pop();
        assertEquals(0, stack.size());
    }

    @Test
    @DisplayName("IsEmpty")
    void test_IsEmpty() {
        final ArrayStack<Integer> stack = new ArrayStack<>();
        assertTrue(stack.isEmpty());
        stack.add(1);
        assertFalse(stack.isEmpty());
        stack.add(2);
        assertFalse(stack.isEmpty());
        stack.pop();
        assertFalse(stack.isEmpty());
        stack.pop();
        assertTrue(stack.isEmpty());
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    @DisplayName("Contains")
    void test_Contains() {
        final ArrayStack<Integer> stack = new ArrayStack<>();
        stack.add(1);
        assertTrue(stack.contains(1));
        assertEquals(1, (int) stack.pop());
        assertFalse(stack.contains(1));
    }

    @Test
    @DisplayName("Iterator")
    void test_Iterator() {
    }

    @Test
    @DisplayName("ToArray")
    void test_ToArray() {
    }

    @Test
    @DisplayName("ToArray1")
    void test_ToArray1() {
    }

    @Test
    @DisplayName("Add")
    void test_Add() {
        final ArrayStack<Integer> stack = new ArrayStack<>();
        stack.add(1);
        assertTrue(stack.contains(1));
        assertEquals(1, (int) stack.pop());
    }

    @Test
    @DisplayName("Remove")
    void test_Remove() {
        final ArrayStack<Integer> stack = new ArrayStack<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        stack.remove(2);
        assertEquals(List.of(4, 3, 1), stack.toList());
    }

    @Test
    @DisplayName("ContainsAll")
    void test_ContainsAll() {
    }

    @Test
    @DisplayName("AddAll")
    void test_AddAll() {
        final ArrayStack<Integer> stack = new ArrayStack<>();
        stack.addAll(List.of(1, 2, 3));
        stack.addAll(List.of(4, 5, 6));
        assertEquals(List.of(6, 5, 4, 3, 2, 1), stack.toList());
    }

    @Test
    @DisplayName("RemoveAll")
    void test_RemoveAll() {
    }

    @Test
    @DisplayName("RetainAll")
    void test_RetainAll() {
    }

    @Test
    @DisplayName("Clear")
    void test_Clear() {
    }
}