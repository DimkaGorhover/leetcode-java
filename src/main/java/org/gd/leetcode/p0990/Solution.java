package org.gd.leetcode.p0990;

import org.gd.leetcode.common.LeetCode;

import java.util.*;

/**
 * TODO: https://leetcode.com/problems/satisfiability-of-equality-equations/
 */
@LeetCode(difficulty = LeetCode.Level.MEDIUM, tags = {LeetCode.Tags.UNION_FIND, LeetCode.Tags.GRAPH})
class Solution {

    public boolean equationsPossible(String[] equations) {

        ValuesProviders valuesProviders = new ValuesProviders();
        Set<Op> ops = new HashSet<>();

        Op op;
        for (String equation : equations) {
            valuesProviders.add(equation.charAt(0), equation.charAt(3));
            if (!(op = Op.of(equation)).isAlwaysTrue())
                ops.add(op);
        }

        op = new LoggedOp(Op.reduce(ops));

        for (ValuesProvider provider : valuesProviders) {
            if (op.apply(provider))
                return true;
        }

        return false;
    }

    interface ValuesProvider {

        int get(char operand);
    }

    static class ImmutableValuesProvider implements ValuesProvider {

        private final Map<Character, Integer> map;
        private final int[] arr;

        ImmutableValuesProvider(Map<Character, Integer> map, int[] arr) {
            this.map = new TreeMap<>(map);
            this.arr = Arrays.copyOf(arr, arr.length);
        }

        @Override
        public int get(char operand) {
            Integer index = map.get(operand);
            if (index == null)
                throw new IllegalArgumentException();
            return arr[index];
        }

        @Override
        public String toString() {
            StringJoiner sj = new StringJoiner(", ", "[", "]");
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                sj.add("{" + entry.getKey() + '=' + arr[entry.getValue()] + '}');
            }
            return sj.toString();
        }
    }

    static class ValuesProviders implements Iterable<ValuesProvider> {

        private final Map<Character, Integer> map = new HashMap<>();
        private int counter = 0;

        void add(char operand0, char operand1) {
            add(operand0);
            add(operand1);
        }

        void add(char operand) {
            if (!map.containsKey(operand)) {
                map.put(operand, counter);
                counter++;
            }
        }

        @Override
        public Iterator<ValuesProvider> iterator() {

            final int counter = this.counter;
            int[] arr = new int[counter];
            Arrays.fill(arr, 1);

            return new Iterator<ValuesProvider>() {

                private int index = 0;

                @Override
                public boolean hasNext() {
                    return index < counter;
                }

                @Override
                public ValuesProvider next() {
                    if (!hasNext())
                        throw new NoSuchElementException();

                    // FIXME: WRONG PERMUTATION HERE
                    if (index > 0) {
                        for (int i = index; i < counter; i++)
                            arr[i]++;
                    }
                    index++;
                    // FIXME: WRONG PERMUTATION HERE

                    return new ImmutableValuesProvider(map, arr);
                }
            };
        }
    }

    interface Op {

        static Op of(String str) {
            char operand0 = str.charAt(0);
            char operand1 = str.charAt(3);
            switch (str.charAt(1)) {
                case '!': return neq(operand0, operand1);
                case '=': return eq(operand0, operand1);
            }
            throw new UnsupportedOperationException(new String(new char[]{175, 92, 95, 40, 12_484, 41, 95, 47, 175}));
        }

        static Op reduce(Collection<Op> ops) {
            Op reducer = True.INSTANCE;
            if (ops == null || ops.size() == 0)
                return reducer;
            for (Op op : ops) {
                if (op.isAlwaysFalse())
                    return False.INSTANCE;
                reducer = reducer.and(op);
            }
            return reducer;
        }

        static Op eq(char operand0, char operand1) {
            return operand0 == operand1 ? new SameEq(operand0) : new Eq(operand0, operand1);
        }

        static Op neq(char operand0, char operand1) {
            return operand0 == operand1 ? new SameNeq(operand0) : new Neq(operand0, operand1);
        }

        boolean apply(ValuesProvider provider);

        default Op and(Op then) {
            if (equals(then))
                return this;
            return new And(this, then);
        }

        default boolean isAlwaysFalse() { return false; }

        default boolean isAlwaysTrue() { return false; }
    }

    static class LoggedOp implements Op {

        private final Op op;

        LoggedOp(Op op) {
            this.op = op;
        }

        @Override
        public boolean apply(ValuesProvider provider) {
            boolean result = op.apply(provider);
            System.out.printf(" parsed: %s%n values: %s => %s%n%n", op, provider, result);
            return result;
        }

        @Override
        public Op and(Op then) { return op.and(then); }

        @Override
        public boolean isAlwaysFalse() { return op.isAlwaysFalse(); }

        @Override
        public boolean isAlwaysTrue() { return op.isAlwaysTrue(); }

        @Override
        public int hashCode() { return op.hashCode(); }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) return false;
            if (obj instanceof LoggedOp) return equals(((LoggedOp) obj).op);
            return op.equals(obj);
        }

        @Override
        public String toString() { return op.toString(); }
    }

    static class False implements Op {

        public static final False INSTANCE = new False();

        private False() {}

        @Override
        public boolean apply(ValuesProvider provider) { return false; }

        @Override
        public boolean isAlwaysFalse() { return true; }

        @Override
        public Op and(Op then) { return this; }

        @Override
        public String toString() { return "false"; }
    }

    static class True implements Op {

        public static final True INSTANCE = new True();

        private True() {}

        @Override
        public boolean apply(ValuesProvider provider) {
            return true;
        }

        @Override
        public Op and(Op then) { return then; }

        @Override
        public String toString() {return "true";}
    }

    static class SameNeq implements Op {

        private final char operand;

        SameNeq(char operand) { this.operand = operand; }

        @Override
        public boolean apply(ValuesProvider provider) { return false; }

        @Override
        public boolean isAlwaysFalse() { return true; }

        @Override
        public Op and(Op then) { return False.INSTANCE; }

        @Override
        public String toString() {
            return operand + "!=" + operand;
        }
    }

    static class SameEq implements Op {

        private final char operand;

        SameEq(char operand) {
            this.operand = operand;
        }

        @Override
        public boolean apply(ValuesProvider provider) { return true; }

        @Override
        public boolean isAlwaysTrue() { return true; }

        @Override
        public Op and(Op then) { return then; }

        @Override
        public String toString() {
            return operand + "==" + operand;
        }
    }

    static class Eq implements Op {

        private final char operand0;

        private final char operand1;

        Eq(char operand0, char operand1) {
            this.operand0 = operand0;
            this.operand1 = operand1;
        }

        @Override
        public boolean apply(ValuesProvider provider) {
            return provider.get(operand0) == provider.get(operand1);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o instanceof LoggedOp) return o.equals(this);
            if (o == null || getClass() != o.getClass()) return false;
            Eq eq = (Eq) o;
            return (operand0 == eq.operand0 && operand1 == eq.operand1)
                    || (operand0 == eq.operand1 && operand1 == eq.operand0);
        }

        @Override
        public int hashCode() {
            return 17 * Math.min(operand0, operand1) + Math.max(operand0, operand1);
        }

        @Override
        public String toString() {
            return operand0 + "==" + operand1;
        }
    }

    static class Neq implements Op {

        private final char operand0;

        private final char operand1;

        Neq(char operand0, char operand1) {
            this.operand0 = operand0;
            this.operand1 = operand1;
        }

        @Override
        public boolean apply(ValuesProvider provider) {
            return provider.get(operand0) != provider.get(operand1);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o instanceof LoggedOp) return o.equals(this);
            if (o == null || getClass() != o.getClass()) return false;
            Neq neq = (Neq) o;
            return (operand0 == neq.operand0 && operand1 == neq.operand1)
                    || (operand0 == neq.operand1 && operand1 == neq.operand0);
        }

        @Override
        public int hashCode() {
            return 13 * Math.min(operand0, operand1) + Math.max(operand0, operand1);
        }

        @Override
        public String toString() {
            return operand0 + "!=" + operand1;
        }
    }

    static class And implements Op {

        private final Op op0;
        private final Op op1;

        And(Op op0, Op op1) {
            this.op0 = op0;
            this.op1 = op1;
        }

        @Override
        public boolean apply(ValuesProvider provider) {
            return op0.apply(provider) && op1.apply(provider);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            And and = (And) o;
            return Objects.equals(op0, and.op0) &&
                    Objects.equals(op1, and.op1);
        }

        @Override
        public int hashCode() {
            return Objects.hash(op0, op1);
        }

        @Override
        public String toString() {
            return op0 + " && " + op1;
        }
    }
}
