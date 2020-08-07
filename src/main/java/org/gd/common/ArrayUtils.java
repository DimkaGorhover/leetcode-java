package org.gd.common;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Horkhover Dmytro
 * @since 2019-01-22
 */
public final class ArrayUtils {

    public static final Object[] EMPTY_OBJECTS;

    static {
        //EMPTY_BOOLEAN_ARRAY            EMPTY_BOOLEAN_OBJECT_ARRAY     EMPTY_BYTE_ARRAY               EMPTY_BYTE_OBJECT_ARRAY        EMPTY_CHARACTER_OBJECT_ARRAY
        //EMPTY_CHAR_ARRAY               EMPTY_CLASS_ARRAY              EMPTY_DOUBLE_ARRAY             EMPTY_DOUBLE_OBJECT_ARRAY      EMPTY_FLOAT_ARRAY
        //EMPTY_FLOAT_OBJECT_ARRAY       EMPTY_INTEGER_OBJECT_ARRAY     EMPTY_INT_ARRAY                EMPTY_LONG_ARRAY               EMPTY_LONG_OBJECT_ARRAY
        //EMPTY_OBJECT_ARRAY             EMPTY_SHORT_ARRAY              EMPTY_SHORT_OBJECT_ARRAY       EMPTY_STRING_ARRAY             INDEX_NOT_FOUND


        Object[] emptyObjects = null;
        try {
            final Class<?> ArrayUtilsClass = Class.forName("org.apache.commons.lang3.ArrayUtils");
            emptyObjects = (Object[]) ArrayUtilsClass.getField("EMPTY_OBJECT_ARRAY").get(ArrayUtilsClass);
        } catch (Throwable ignored) {}

        if (emptyObjects == null) emptyObjects = new Object[0];

        EMPTY_OBJECTS = emptyObjects;
    }

    private ArrayUtils() { throw new UnsupportedOperationException(); }

    public static <T> int binarySearch(Object[] a,
                                       int fromIndex,
                                       int toIndex,
                                       T key,
                                       Comparator<T> c) {
        int low = fromIndex, high = toIndex - 1, mid, cmp;
        while (low <= high) {
            T midVal = (T) a[mid = (low + high) >>> 1];
            if ((cmp = c.compare(midVal, key)) < 0)
                low = mid + 1;
            else if (cmp > 0)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -1;
    }

    public static <T> int binarySearchPos(Object[] a,
                                          int fromIndex,
                                          int toIndex,
                                          T key,
                                          Comparator<T> c) {
        int low = fromIndex, high = toIndex - 1, mid, cmp;
        while (low <= high) {
            T midVal = (T) a[mid = (low + high) >>> 1];
            if ((cmp = c.compare(midVal, key)) < 0)
                low = mid + 1;
            else if (cmp > 0)
                high = mid - 1;
            else
                return mid; // key found
        }
        return low;  //return -(low + 1);  // key not found.
    }

    public static char[] copy(char[] arr) {
        return Arrays.copyOf(arr, arr.length);
    }

    public static int[] copy(int[] arr) {
        return Arrays.copyOf(arr, arr.length);
    }

    public static char[][] copy(char[][] matrix) {
        if (matrix == null)
            return null;
        if (matrix.length == 0)
            return new char[0][];
        if (matrix.length == 1)
            return new char[][]{copy(matrix[0])};
        return Arrays.stream(matrix)
                .map(ArrayUtils::copy)
                .toArray(char[][]::new);
    }

    public static int[][] copy(int[][] matrix) {
        if (matrix == null)
            return null;
        if (matrix.length == 0)
            return new int[0][];
        if (matrix.length == 1)
            return new int[][]{copy(matrix[0])};
        return Arrays.stream(matrix)
                .map(ArrayUtils::copy)
                .toArray(int[][]::new);
    }
}
