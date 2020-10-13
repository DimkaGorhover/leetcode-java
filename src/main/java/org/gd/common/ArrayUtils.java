package org.gd.common;

import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.ThreadLocalRandom;

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

    public static void shuffle(byte[] arr) {
        if (arr == null || arr.length <= 1)
            return;

        var rnd = ThreadLocalRandom.current();
        for (int i = 0; i < arr.length; i++) {
            int j = rnd.nextInt(0, arr.length);
            swap(arr, i, j);
        }
    }

    public static void shuffle(short[] arr) {
        if (arr == null || arr.length <= 1)
            return;

        var rnd = ThreadLocalRandom.current();
        for (int i = 0; i < arr.length; i++) {
            int j = rnd.nextInt(0, arr.length);
            swap(arr, i, j);
        }
    }

    public static void shuffle(int[] arr) {
        if (arr == null || arr.length <= 1)
            return;

        var rnd = ThreadLocalRandom.current();
        for (int i = 0; i < arr.length; i++) {
            int j = rnd.nextInt(0, arr.length);
            swap(arr, i, j);
        }
    }

    public static void shuffle(long[] arr) {
        if (arr == null || arr.length <= 1)
            return;

        var rnd = ThreadLocalRandom.current();
        for (int i = 0; i < arr.length; i++) {
            int j = rnd.nextInt(0, arr.length);
            swap(arr, i, j);
        }
    }

    public static void shuffle(float[] arr) {
        if (arr == null || arr.length <= 1)
            return;

        var rnd = ThreadLocalRandom.current();
        for (int i = 0; i < arr.length; i++) {
            int j = rnd.nextInt(0, arr.length);
            swap(arr, i, j);
        }
    }

    public static void shuffle(double[] arr) {
        if (arr == null || arr.length <= 1)
            return;

        var rnd = ThreadLocalRandom.current();
        for (int i = 0; i < arr.length; i++) {
            int j = rnd.nextInt(0, arr.length);
            swap(arr, i, j);
        }
    }

    public static void shuffle(boolean[] arr) {
        if (arr == null || arr.length <= 1)
            return;

        var rnd = ThreadLocalRandom.current();
        for (int i = 0; i < arr.length; i++) {
            int j = rnd.nextInt(0, arr.length);
            swap(arr, i, j);
        }
    }

    public static void shuffle(char[] arr) {
        if (arr == null || arr.length <= 1)
            return;

        var rnd = ThreadLocalRandom.current();
        for (int i = 0; i < arr.length; i++) {
            int j = rnd.nextInt(0, arr.length);
            swap(arr, i, j);
        }
    }

    public static String toString(int[] arr, final int from, final int to) {
        if (arr == null)
            throw new NullPointerException("arr");
        if (from < 0)
            throw new ArrayIndexOutOfBoundsException(from);
        if (to > arr.length)
            throw new ArrayIndexOutOfBoundsException(to);
        if (from >= to)
            throw new ArrayIndexOutOfBoundsException(from + " >= " + to);

        StringBuilder sb = new StringBuilder().append('[').append(arr[from]);
        for (int i = from + 1; i < to; i++) {
            sb.append(',').append(' ').append(arr[i]);
        }
        return sb.append(']').toString();
    }

    private static void swap(byte[] arr, int i, int j) {
        byte tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void swap(short[] arr, int i, int j) {
        short tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void swap(long[] arr, int i, int j) {
        long tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void swap(float[] arr, int i, int j) {
        float tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void swap(double[] arr, int i, int j) {
        double tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void swap(boolean[] arr, int i, int j) {
        boolean tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
