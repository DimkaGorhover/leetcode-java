package org.gd.common;

import org.junit.jupiter.api.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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
        // @formatter:off
        stack.add(1); assertEquals(1, stack.size());
        stack.add(2); assertEquals(2, stack.size());
        stack.pop();  assertEquals(1, stack.size());
        stack.pop();  assertEquals(0, stack.size());
        stack.pop();  assertEquals(0, stack.size());
        // @formatter:on

    }

    @Test
    @DisplayName("IsEmpty")
    void test_IsEmpty() {
        final ArrayStack<Integer> stack = new ArrayStack<>();
        // @formatter:off
        stack.add(1); assertFalse(stack.isEmpty());
        stack.add(2); assertFalse(stack.isEmpty());
        stack.pop();  assertFalse(stack.isEmpty());
        stack.pop();  assertTrue (stack.isEmpty());
        stack.pop();  assertTrue (stack.isEmpty());
        // @formatter:on
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
        final Iterator<Integer> iterator = ArrayStack.of(1, 2, 3).iterator();
        // @formatter:off
        assertTrue (iterator.hasNext()); assertEquals(3, (int) iterator.next());
        assertTrue (iterator.hasNext()); assertEquals(2, (int) iterator.next());
        assertTrue (iterator.hasNext()); assertEquals(1, (int) iterator.next());
        assertFalse(iterator.hasNext());
        // @formatter:on
    }

    @Test
    @DisplayName("ToArray")
    void test_ToArray() {
        assertArrayEquals(new Object[]{3, 2, 1}, ArrayStack.of(1, 2, 3).toArray());
    }

    @Test
    @DisplayName("ToArray1")
    void test_ToArray1() {
        assertArrayEquals(new Integer[]{3, 2, 1}, ArrayStack.of(1, 2, 3).toArray(new Integer[]{}));
        assertArrayEquals(new Integer[]{3, 2, 1}, ArrayStack.of(1, 2, 3).toArray(new Integer[3]));
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
        final ArrayStack<Integer> stack = ArrayStack.of(1, 2, 3, 4);
        // @formatter:off
        stack.remove(2); assertEquals(List.of(4, 3, 1), stack.toList());
        stack.remove(4); assertEquals(List.of(3, 1), stack.toList());
        stack.remove(2); assertEquals(List.of(3, 1), stack.toList());
        // @formatter:on

    }

    @Test
    @DisplayName("ContainsAll")
    void test_ContainsAll() {
        final ArrayStack<Integer> stack = ArrayStack.of(1, 2, 3, 4);
        assertTrue(stack.containsAll(List.of(1, 3)));
        assertFalse(stack.containsAll(List.of(1, 5)));
        assertTrue(stack.containsAll(List.of(4, 2, 3, 1)));
    }

    @Test
    @DisplayName("AddAll")
    void test_AddAll() {
        var stack = new ArrayStack<>();
        stack.addAll(List.of(1, 2, 3));
        stack.addAll(List.of(4, 5, 6));
        assertEquals(List.of(6, 5, 4, 3, 2, 1), stack.toList());

        stack = ArrayStack.of(1, 2, 3);
        stack.addAll(ArrayStack.of(6, 5, 4));
        assertEquals(List.of(6, 5, 4, 3, 2, 1), stack.toList());

        stack = ArrayStack.of(1, 2, 3);
        stack.addAll(new LinkedList<>(List.of(4, 5, 6)));
        assertEquals(List.of(6, 5, 4, 3, 2, 1), stack.toList());
    }

    @Test
    @DisplayName("RemoveAll")
    void test_RemoveAll() {
        var stack = ArrayStack.of(1, 2, 3, 4);
        assertEquals(List.of(4, 3, 2, 1), stack.toList());
        assertTrue(stack.removeAll(List.of(1, 3)));
        assertEquals(List.of(4, 2), stack.toList());
        assertFalse(stack.removeAll(List.of(3, 3)));
        assertEquals(List.of(4, 2), stack.toList());
        assertTrue(stack.removeAll(List.of(4, 2)));
        assertTrue(stack.isEmpty());
    }

    @Test
    @DisplayName("RetainAll")
    void test_RetainAll() {
        var stack = ArrayStack.of(1, 2, 3, 4);
        assertTrue(stack.retainAll(List.of(2, 3, 5)));
        assertEquals(List.of(3, 2), stack.toList());
        assertFalse(stack.retainAll(List.of(3, 2)));
        assertEquals(List.of(3, 2), stack.toList());
        assertTrue(stack.retainAll(List.of(4)));
        assertTrue(stack.isEmpty());
    }

    @Test
    @DisplayName("Clear")
    void test_Clear() {
        var stack = ArrayStack.of(1, 2, 3, 4);
        assertEquals(List.of(4, 3, 2, 1), stack.toList());
        stack.clear();
        assertEquals(List.of(), stack.toList());
    }

    @Test
    @DisplayName("RemoveIf")
    void test_RemoveIf() {
        var stack = ArrayStack.of(1, 2, 3, 4);
        stack.removeIf(v -> v % 2 == 0);
        assertEquals(List.of(3, 1), stack.toList());
    }

    @Test
    @DisplayName("equals")
    void test_equals() {
        var stack = ArrayStack.of(1, 2, 3, 4);
        for (int i = 0; i < 1 << 20; i++)
            stack.push(i);
        stack.clear();
        stack.addAll(List.of(1, 2, 3, 4));
        assertEquals(ArrayStack.of(1, 2, 3, 4), stack);
    }

    @Test
    @DisplayName("hashCode")
    void test_hashCode() {
        var stack = ArrayStack.of(1, 2, 3, 4);
        for (int i = 0; i < 1 << 20; i++)
            stack.push(i);
        stack.clear();
        stack.addAll(List.of(1, 2, 3, 4));
        assertEquals(
                ArrayStack.of(1, 2, 3, 4).hashCode(),
                stack.hashCode());
    }

    @SuppressWarnings("SimplifyStreamApiCallChains")
    @Test
    @DisplayName("spliterator")
    void test_spliterator() {
        assertEquals(
                List.of(4, 3, 2, 1),
                StreamSupport.stream(ArrayStack.of(1, 2, 3, 4).spliterator(), false)
                        .collect(Collectors.toList())
        );
    }

    @SuppressWarnings("SimplifyStreamApiCallChains")
    @Test
    @DisplayName("stream")
    void test_stream() {
        assertEquals(
                List.of(4, 3, 2, 1),
                ArrayStack.of(1, 2, 3, 4).stream().collect(Collectors.toList())
        );
    }

    @Test
    @DisplayName("parallelStream")
    void test_parallelStream() {
        assertEquals(10, ArrayStack.of(1, 2, 3, 4).stream().mapToInt(v -> v).sum());
    }
}