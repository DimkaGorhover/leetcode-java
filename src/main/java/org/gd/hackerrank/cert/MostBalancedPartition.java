package org.gd.hackerrank.cert;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;


/**
 * The directory structure of a system disk partition is represented as a tree. Its n directories are numbered from 0 to
 * n-1, where the root directory has the number 0. The structure of the tree is defined by a parent array, where
 * parent[i] = j means that the directory i is a direct subdirectory of j. Since the root directory does not have a
 * parent, it will be represented as parent[0] = -1. The value in files_size[i] denotes the sum of the sizes in
 * kilobytes of the files located in directory i, but excluding its subdirectories. The size of the content of a
 * directory is defined as the size of all files contained in this directory, plus the sum of the sizes of all of its
 * subdirectories. Partition the tree into two smaller ones by cutting one branch so that the sizes of the resulting
 * subtrees are as close as possible.
 */
class MostBalancedPartition {

    public static int mostBalancedPartition(List<Integer> parentIndices,
                                            List<Integer> filesSizes) {

        InputIterator inputIterator = new InputIterator(parentIndices, filesSizes);

        TreeNode root = inputIterator.next().node();

        while (inputIterator.hasNext()) {
            InputEntry next = inputIterator.next();
            root.add(next.parentIndex(), next.node());
        }

        System.out.println(root);

        return root.sliceValue();
    }

    interface InputEntry {

        int parentIndex();

        TreeNode node();
    }

    static class InputIterator implements Iterator<InputEntry> {

        private final Iterator<Integer> parentIndices;
        private final Iterator<Integer> filesSizes;
        private int index = 0;

        InputIterator(List<Integer> parentIndices,
                      List<Integer> filesSizes) {
            requireNonNull(parentIndices, "\"parentIndices\" cannot be null");
            requireNonNull(filesSizes, "\"filesSizes\" cannot be null");
            this.parentIndices = parentIndices.iterator();
            this.filesSizes = filesSizes.iterator();
        }

        @Override
        public boolean hasNext() {
            return parentIndices.hasNext() && filesSizes.hasNext();
        }

        @Override
        public InputEntry next() {
            if (!hasNext())
                throw new NoSuchElementException();

            int parentIndex = parentIndices.next();
            int value = filesSizes.next();

            TreeNode node = new TreeNodeImpl(this.index, value);
            this.index++;

            return new InputEntry() {

                @Override
                public int parentIndex() { return parentIndex; }

                @Override
                public TreeNode node() { return node; }
            };
        }
    }

    interface TreeNode {

        static TreeNode root(int value) {
            return new TreeNodeImpl(0, value);
        }

        int sliceValue();

        int size();

        boolean isBinary();

        int sum();

        int value();

        boolean add(int parentIndex, TreeNode node);
    }

    static class TreeNodeImpl implements TreeNode {

        final int index;
        final int value;
        final List<TreeNode> children = new ArrayList<>();

        TreeNodeImpl(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int sliceValue() {
            int leftSum = leftSum();
            int rightSum = rightSum();
            System.out.println("leftSum = " + leftSum);
            System.out.println("rightSum = " + rightSum);

            return Math.abs(Math.abs(leftSum - rightSum) - value);
        }

        @Override
        public int value() {
            return value;
        }

        @Override
        public int size() {
            return 1 + children.stream().mapToInt(TreeNode::size).sum();
        }

        @Override
        public boolean isBinary() {
            boolean result = children.size() <= 2;
            for (int i = 0; result && i < children.size(); i++) {
                result = children.get(i).isBinary();
            }
            return result;
        }

        private void checkIfBinary() {
            if (!isBinary()) {
                throw new IllegalStateException();
            }
        }

        int leftSum() {
            checkIfBinary();
            if (children.size() <= 2) {
                return children.get(0).sum();
            }
            return 0;
        }

        int rightSum() {
            checkIfBinary();
            if (children.size() == 2) {
                return children.get(1).sum();
            }
            return 0;
        }

        @Override
        public int sum() {
            return value + children.stream()
                    .mapToInt(TreeNode::value)
                    .sum();
        }

        @Override
        public boolean add(int parentIndex, TreeNode node) {
            if (index == parentIndex) {
                children.add(node);
                return true;
            }
            for (TreeNode child : children) {
                if (child.add(parentIndex, node)) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public String toString() {
            return toString(0);
        }

        public String toString(int offsetSize) {

            String offset = " ".repeat(offsetSize);

            String childrenString = children.isEmpty() ? "" : children.stream()
                    .map(node -> ((TreeNodeImpl) node).toString(offsetSize + 4))
                    .collect(Collectors.joining(
                            String.format("%n"),
                            String.format("[%n"),
                            String.format("%n%s]", offset)
                    ));

            return String.format("%s{ index: %d ; value: %d } %s", offset, index, value, childrenString);
        }
    }
}
