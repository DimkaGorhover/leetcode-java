package org.gd.leetcode.p0077;

import java.util.*;

import static java.util.Objects.requireNonNull;

/**
 * @see org.gd.leetcode.p0077.Solution
 * @since 2019-09-20
 */
@SuppressWarnings({"DuplicatedCode"})
class Solution1 {

    private static final long[] FACT = {
            1, 1L, 2L, 6L, 24L, 120L, 720L, 5040L, 40320L, 362880L, 3628800L,
            39916800L, 479001600L, 6227020800L, 87178291200L, 1307674368000L,
            20922789888000L, 355687428096000L, 6402373705728000L, 121645100408832000L
    };

    private static Aggregator combine(Aggregator aggregator, int[] heap, int from, int to, int index, int k) {

        if (index == k)
            return aggregator.add(heap);

        for (int i = from; i <= to; i++) {
            heap[index] = i;
            combine(aggregator, heap, i + 1, to, index + 1, k);
        }
        return aggregator;
    }

    public List<List<Integer>> combine(int n, int k) {
        if (n < k)
            return Collections.emptyList();

        final Aggregator aggregator = n < FACT.length
                ? new ArrayAggregator(Math.toIntExact(FACT[n] / FACT[n - k] / FACT[k]))
                : new ListAggregator();

        return combine(aggregator, new int[k], 1, n, 0, k).sum();
    }

    interface Aggregator {

        Aggregator add(int[] arr);

        Aggregator add(Integer[] arr);

        Aggregator add(List<Integer> list);

        List<List<Integer>> sum();
    }

    static class ListAggregator implements Aggregator {

        private final List<List<Integer>> list = new ArrayList<>();

        @Override
        public Aggregator add(int[] arr) {
            if (arr == null)
                return this;
            if (arr.length == 0) {
                list.add(Collections.emptyList());
                return this;
            }
            ArrayList<Integer> list = new ArrayList<>(arr.length);
            for (int i : arr)
                list.add(i);
            this.list.add(list);
            return this;
        }

        @Override
        public Aggregator add(Integer[] arr) {
            if (arr == null)
                return this;
            if (arr.length == 0) {
                list.add(Collections.emptyList());
                return this;
            }
            Integer[] newArr = new Integer[arr.length];
            System.arraycopy(arr, 0, newArr, 0, arr.length);
            list.add(Arrays.asList(newArr));
            return this;
        }

        @Override
        public Aggregator add(List<Integer> list) {
            this.list.add(new ArrayList<>(list));
            return this;
        }

        @Override
        public List<List<Integer>> sum() { return list; }
    }

    static class ArrayAggregator implements Aggregator {

        private final List[] sum;
        private int index = 0;

        ArrayAggregator(int count) { this.sum = new List[count]; }

        @Override
        public Aggregator add(int[] arr) {
            if (arr == null)
                return this;
            if (arr.length == 0) {
                sum[index++] = Collections.emptyList();
                return this;
            }
            sum[index++] = IntList.copyOf(arr);
            return this;
        }

        @Override
        public Aggregator add(Integer[] arr) {
            if (arr == null)
                return this;
            if (arr.length == 0) {
                sum[index++] = Collections.emptyList();
                return this;
            }
            Integer[] newArr = new Integer[arr.length];
            System.arraycopy(arr, 0, newArr, 0, arr.length);
            sum[index++] = Arrays.asList(newArr);
            return this;
        }

        @Override
        public Aggregator add(List<Integer> list) {
            sum[index++] = new ArrayList<>(list);
            return this;
        }

        @SuppressWarnings("unchecked")
        @Override
        public List<List<Integer>> sum() { return Arrays.asList(sum); }
    }

    static class IntList implements List<Integer> {

        private final int[] elementData;
        private final int startIndex;

        private int size = 0;

        IntList(int capacity) {
            this(new int[capacity]);
        }

        IntList(int[] elementData) {
            this(elementData, 0, elementData.length);
        }

        IntList(int[] elementData, int startIndex, int endIndex) {
            this.elementData = elementData;
            this.startIndex = startIndex;
            this.size = endIndex;
        }

        static IntList copyOf(int[] arr) {
            return new IntList(Arrays.copyOf(arr, arr.length));
        }

        @Override
        public int size() { return size; }

        @Override
        public boolean isEmpty() { return size == 0; }

        @Override
        public boolean contains(Object o) {
            return indexOf(o) >= 0;
        }

        @Override
        public Iterator<Integer> iterator() {
            return new Iterator<Integer>() {

                int index = 0;

                @Override
                public boolean hasNext() {
                    return index < size;
                }

                @Override
                public Integer next() {
                    if (!hasNext())
                        throw new NoSuchElementException();
                    return elementData[index++];
                }
            };
        }

        @Override
        public Object[] toArray() {
            throw new UnsupportedOperationException(new String(new char[]{175, 92, 95, 40, 12_484, 41, 95, 47, 175}));
        }

        @Override
        public <T> T[] toArray(T[] a) {
            throw new UnsupportedOperationException(new String(new char[]{175, 92, 95, 40, 12_484, 41, 95, 47, 175}));
        }

        @Override
        public boolean add(Integer integer) {
            requireNonNull(integer, "\"integer\" cannot be null");
            elementData[size++] = integer;
            return true;
        }

        @Override
        public boolean remove(Object o) {
            throw new UnsupportedOperationException(new String(new char[]{175, 92, 95, 40, 12_484, 41, 95, 47, 175}));
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            if (c == null || c.isEmpty())
                return true;
            for (Object o : c)
                if (!contains(o))
                    return false;
            return true;
        }

        @Override
        public boolean addAll(Collection<? extends Integer> c) {
            throw new UnsupportedOperationException(new String(new char[]{175, 92, 95, 40, 12_484, 41, 95, 47, 175}));
        }

        @Override
        public boolean addAll(int index, Collection<? extends Integer> c) {
            throw new UnsupportedOperationException(new String(new char[]{175, 92, 95, 40, 12_484, 41, 95, 47, 175}));
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            if (c == null || c.isEmpty())
                return true;
            int index;
            for (Object o : c) {
                if ((index = indexOf(o)) >= 0)
                    remove(index);
            }
            return true;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            throw new UnsupportedOperationException(new String(new char[]{175, 92, 95, 40, 12_484, 41, 95, 47, 175}));
        }

        @Override
        public void clear() { size = 0; }

        @Override
        public Integer get(int index) { return elementData[index]; }

        @Override
        public Integer set(int index, Integer element) {
            int prev = elementData[index];
            elementData[index] = element;
            return prev;
        }

        @Override
        public void add(int index, Integer element) {
            throw new UnsupportedOperationException(new String(new char[]{175, 92, 95, 40, 12_484, 41, 95, 47, 175}));
        }

        @Override
        public Integer remove(int index) {
            throw new UnsupportedOperationException(new String(new char[]{175, 92, 95, 40, 12_484, 41, 95, 47, 175}));
        }

        @Override
        public int indexOf(Object o) {
            for (int i = 0; i < size; i++)
                if (Objects.equals(o, elementData[i]))
                    return i;
            return -1;
        }

        @Override
        public int lastIndexOf(Object o) {
            for (int i = size - 1; i >= size; i--)
                if (Objects.equals(o, elementData[i]))
                    return i;
            return -1;
        }

        @Override
        public ListIterator<Integer> listIterator() {
            return listIterator(0);
        }

        @Override
        public ListIterator<Integer> listIterator(int index) {
            return new ListIterator<Integer>() {

                int index = 0;

                @Override
                public boolean hasNext() { return index < size;}

                @Override
                public Integer next() {
                    if (!hasNext())
                        throw new NoSuchElementException();
                    return elementData[index++];
                }

                @Override
                public boolean hasPrevious() { return index > 0; }

                @Override
                public Integer previous() {
                    if (!hasPrevious())
                        throw new NoSuchElementException();
                    return elementData[--index];
                }

                @Override
                public int nextIndex() {
                    return index;
                }

                @Override
                public int previousIndex() { return index - 1; }

                @Override
                public void remove() {
                    throw new UnsupportedOperationException(new String(new char[]{175, 92, 95, 40, 12_484, 41, 95, 47, 175}));
                }

                @Override
                public void set(Integer integer) {
                    throw new UnsupportedOperationException(new String(new char[]{175, 92, 95, 40, 12_484, 41, 95, 47, 175}));
                }

                @Override
                public void add(Integer integer) {
                    throw new UnsupportedOperationException(new String(new char[]{175, 92, 95, 40, 12_484, 41, 95, 47, 175}));
                }
            };
        }

        @Override
        public List<Integer> subList(int fromIndex, int toIndex) {
            throw new UnsupportedOperationException(new String(new char[]{175, 92, 95, 40, 12_484, 41, 95, 47, 175}));
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }

            if (!(o instanceof List)) {
                return false;
            }
            return equalsRange((List<?>) o, startIndex, startIndex + size);
        }

        boolean equalsRange(List<?> other, int from, int to) {
            Iterator<?> oit = other.iterator();
            for (; from < to; from++) {
                if (!oit.hasNext() || !Objects.equals(elementData[from], oit.next())) {
                    return false;
                }
            }
            return !oit.hasNext();
        }

        @Override
        public int hashCode() {
            return hashCodeRange(startIndex, startIndex + size);
        }

        int hashCodeRange(int from, int to) {
            int hashCode = 1;
            for (int i = from; i < to; i++)
                hashCode = 31 * hashCode + elementData[i];
            return hashCode;
        }

        @Override
        public String toString() {
            if (size == 0)
                return "[]";
            StringBuilder b = new StringBuilder()
                    .append('[');
            b.append(elementData[0]);
            for (int i = 1; i < size; i++) {
                b.append(',').append(' ').append(elementData[i]);
            }
            return b.toString();
        }
    }
}
