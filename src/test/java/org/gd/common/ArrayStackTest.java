package org.gd.common;

import org.junit.jupiter.api.*;

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
    }

    @Test
    @DisplayName("IsEmpty")
    void test_IsEmpty() {
    }

    @Test
    @DisplayName("Contains")
    void test_Contains() {
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
        //@formatter:off
        assertFalse(stack.isEmpty()); assertEquals(4, (int) stack.pop());
        assertFalse(stack.isEmpty()); assertEquals(3, (int) stack.pop());
        assertFalse(stack.isEmpty()); assertEquals(1, (int) stack.pop());
        assertTrue (stack.isEmpty());
        //@formatter:on
    }

    @Test
    @DisplayName("ContainsAll")
    void test_ContainsAll() {
    }

    @Test
    @DisplayName("AddAll")
    void test_AddAll() {
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