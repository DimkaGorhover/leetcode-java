package org.gd.leetcode.p1146;

import org.gd.leetcode.common.LeetCode;

/**
 * <a href="https://leetcode.com/problems/snapshot-array/">LeetCode #1146: Snapshot Array</a>
 *
 * @author Horkhover Dmytro
 * @since 2022-10-04
 */
@LeetCode(
        name = "Snapshot Array",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.ARRAY,
                LeetCode.Tags.HASH_TABLE,
                LeetCode.Tags.BINARY_SEARCH,
                LeetCode.Tags.DESIGN
        }
)
class SnapshotArray {

    private final Value[] arr;
    private int snapshot = 0;

    public SnapshotArray(int length) {
        arr = new Value[length];
    }

    public void set(int index, int val) {
        Value value = arr[index];
        if (value == null) {
            arr[index] = value = new Value();
        }
        value.set(snapshot, val);
    }

    public int snap() {
        int snapshot = this.snapshot;
        this.snapshot++;
        return snapshot;
    }

    public int get(int index, int snapshot) {
        Value value = arr[index];
        if (value == null) {
            return 0;
        }
        return value.get(snapshot);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder().append('[');
        String sep = "";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                sb.append(sep);
                sb.append(i).append('=');
                arr[i].toString(sb);
                sep = ",";
            }
        }

        return sb.append(']').toString();
    }

    static class Value {
        int[] arr = new int[0];
        int latestSnapshot = 0;

        int get(int snapshot) {

            // no value is present
            if (arr.length == 0) {
                return 0;
            }

            if (snapshot >= latestSnapshot) {
                return arr[latestSnapshot] - 1;
            }

            int value = arr[snapshot];
            if (value > 0) {
                return value - 1;
            }

            // TODO: binary search

            for (int i = snapshot; i >= 0; i--) {
                if ((value = arr[i]) > 0) {
                    return value - 1;
                }
            }

            return 0;
        }

        private int binarySearch(int snapshot) {
            int low = 0;
            int high = arr.length - 1;
            while (low <= high) {
                int mid = (low + high) >>> 1;
                int midVal = arr[mid];
                if (midVal < snapshot) {
                    low = mid + 1;
                } else if (midVal > snapshot) {
                    high = mid - 1;
                } else {
                    return mid;
                }
            }
            return low;
        }

        void set(int snapshot, int value) {
            latestSnapshot = Math.max(latestSnapshot, snapshot);
            growIfNeeded(snapshot + 1);
            arr[snapshot] = value + 1;
        }

        private void growIfNeeded(int minCapacity) {
            if (arr.length > minCapacity) {
                return;
            }
            int oldCapacity = arr.length;
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity + 8;
            }
            // minCapacity is usually close to size, so this is a win:
            arr = java.util.Arrays.copyOf(arr, newCapacity);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            toString(sb);
            return sb.toString();
        }

        void toString(StringBuilder sb) {
            sb.append('(');
            String sep = "";
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > 0) {
                    sb.append(sep).append(i).append('=').append(arr[i] - 1);
                    sep = ",";
                }
            }
            sb.append(')');
        }
    }
}
