package org.gd.common;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link SortedArrayList};
 *
 * @author Horkhover Dmytro
 * @since 2019-01-22
 */
class SortedArrayListTest {

    @Test
    @DisplayName("OfComparable")
    void test_OfComparable() {
        SortedArrayList<Integer> list = SortedArrayList.ofComparable();
        list.add(4);
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(List.of(1, 2, 3, 4), list.toList());
    }

    @Test
    @DisplayName("OfComparator")
    void test_OfComparator() {
    }

    @Test
    @DisplayName("Size")
    void test_Size() {
    }

    @Test
    @DisplayName("Iterator")
    void test_Iterator() {
    }

    @Test
    @DisplayName("ToArray")
    void test_ToArray() {
        var list = SortedArrayList.<Integer>ofComparable();
        list = SortedArrayList.ofComparable();
        list.add(4);
        list.add(1);
        list.add(2);
        list.add(3);
        var array = list.toArray();
        assertEquals(List.of(1, 2, 3, 4), Arrays.asList(array));
    }

    @Test
    @DisplayName("Add")
    void test_Add() {
    }

    @Test
    @DisplayName("Remove")
    void test_Remove() {
    }

    @Test
    @DisplayName("AddAll")
    void test_AddAll() {
    }

    @Test
    @DisplayName("AddAll1")
    void test_AddAll1() {
    }

    @Test
    @DisplayName("Clear")
    void test_Clear() {
    }

    @Test
    @DisplayName("Get")
    void test_Get() {
    }

    @Test
    @DisplayName("Set")
    void test_Set() {
    }

    @Test
    @DisplayName("Add1")
    void test_Add1() {
    }

    @Test
    @DisplayName("Remove1")
    void test_Remove1() {
    }

    @Test
    @DisplayName("IndexOf")
    void test_IndexOf() {
    }

    @Test
    @DisplayName("LastIndexOf")
    void test_LastIndexOf() {
    }

    @Test
    @DisplayName("ListIterator")
    void test_ListIterator() {
    }

    @Test
    @DisplayName("ListIterator1")
    void test_ListIterator1() {
    }

    @Test
    @DisplayName("SubList")
    void test_SubList() {
    }

    @Test
    @DisplayName("RetainAll")
    void test_RetainAll() {
    }

    @Test
    @DisplayName("RemoveAll")
    void test_RemoveAll() {
    }

    @Test
    @DisplayName("ContainsAll")
    void test_ContainsAll() {
    }

    @Test
    @DisplayName("HashCode")
    void test_HashCode() {
        assertEquals(2019, SortedArrayList.ofComparable(4, 1, 2, 3).hashCode());

        SortedArrayList<Integer> list = SortedArrayList.ofComparator((o1, o2) -> Integer.compare(o2, o1));
        list.addAll(List.of(4, 1, 2, 3));
        assertEquals(2946, list.hashCode());
    }
}