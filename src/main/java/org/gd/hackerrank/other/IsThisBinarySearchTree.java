package org.gd.hackerrank.other;

import org.gd.hackerrank.common.HackerRank;

/**
 * https://www.hackerrank.com/challenges/ctci-is-binary-search-tree/
 */
@HackerRank(difficulty = HackerRank.Level.MEDIUM)
class IsThisBinarySearchTree {

    boolean checkBST(Node root) {

        // return checkBST0(root, 0, (int) 10e4);

        java.util.Queue<Object[]> nodesEntries = new java.util.LinkedList<>();
        nodesEntries.add(new Object[]{root, 0, (int) 10e4});

        Object[] nodesEntry;
        while((nodesEntry = nodesEntries.poll()) != null) {

            root = (Node) nodesEntry[0];
            int minValue = (int) nodesEntry[1];
            int maxValue = (int) nodesEntry[2];

            if (root != null) {
                if (minValue > root.data || root.data > maxValue) {
                    return false;
                }
                if (root.left != null) {
                    nodesEntries.offer(new Object[]{root.left, minValue, root.data - 1});
                }
                if (root.right != null) {
                    nodesEntries.offer(new Object[]{root.right, root.data + 1, maxValue});
                }
            }
        }

        return true;        
    }



    boolean checkBST0(Node root, int minValue, int maxValue) {

        if (root == null)
            return true;

        return minValue <= root.data
                && root.data <= maxValue
                && checkBST0(root.left, minValue, root.data - 1)
                && checkBST0(root.right, root.data + 1, maxValue);
    }

    static class Node {
        int data;
        Node left;
        Node right;

        

        Node(int data) {
            this.data = data;
        }

        public static Node of(Integer... values) {
            
            java.util.Objects.requireNonNull(values, "values");
            
            if (values.length < 1)
                throw new IllegalArgumentException("values should contain at least one element");

            final Node head  = new Node(java.util.Objects.requireNonNull(values[0], "first value cannot be NULL"));
            java.util.List<Node> nodes = java.util.List.of(head);
            int            i     = 1;
            Node       tmp;
            while (!nodes.isEmpty()) {
                java.util.List<Node> newNodes = new java.util.ArrayList<>(2);
                for (Node node : nodes) {
                    if (i < values.length && (tmp = of(values[i++])) != null) {
                        newNodes.add(tmp);
                        node.left = tmp;
                    }
                    if (i < values.length && (tmp = of(values[i++])) != null) {
                        newNodes.add(tmp);
                        node.right = tmp;
                    }
                }
                nodes = newNodes;
            }
            return head;
        }

        /*
         * (non-Javadoc)
         * 
         * @see java.lang.Object#toString()
         */

        @Override
        public String toString() {
            return "Node [data=" + data + ", left=" + left + ", right=" + right + "]";
        }
    
    }
}
