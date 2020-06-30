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
            op = Op.of(equation);
            if (op.isAlwaysFalse()) {
                return false;
            }
            if (!op.isAlwaysTrue()) {
                ops.add(op);
                valuesProviders.add(equation.charAt(0), equation.charAt(3));
            }
        }

        op = Op.reduce(ops);
        op = LoggedOp.of(op);

        return false;
    }

    interface ValuesProvider {

        int get(char operand);
    }

    static class ImmutableValuesProvider implements ValuesProvider {

        private final int[] map;
        private final int[] values;

        private ImmutableValuesProvider(int[] map, int[] values) {
            this.map = map;
            this.values = values;
        }

        static ImmutableValuesProvider copyOf(int[] arr, int[] values) {
            return new ImmutableValuesProvider(
                    Arrays.copyOf(arr, arr.length),
                    Arrays.copyOf(values, values.length));
        }

        @Override
        public int get(char operand) {
            int value = map[operand - 'a'];
            if (value < 1)
                throw new IllegalArgumentException();
            return value;
        }

        @Override
        public String toString() {
            StringJoiner sj = new StringJoiner(", ", "[", "]");
            for (int i = 0; i < map.length; i++) {
                if (map[i] > 0) {
                    char c = (char) (i + 'a');
                    int v = values[map[i] - 1];
                    sj.add("{" + c + '=' + v + '}');
                }
            }
            return sj.toString();
        }
    }

    static class ValuesProviders {

        private final int[] map = new int['z' - 'a' + 1];

        private int counter = 0;

        void add(char operand0, char operand1) {
            add(operand0);
            add(operand1);
        }

        void add(char operand) {
            map[operand - 'a'] = ++counter;
        }

        boolean apply(Op op) {
            if (op.isAlwaysFalse())
                return false;
            if (op.isAlwaysTrue())
                return true;

            int[] values = new int[counter];
            return apply(op, values, 0);
        }

        boolean apply(Op op, int[] values, int start) {
            for (int i = start; i < counter; i++) {
                for (int j = 0; j < i; j++) {
                    values[i] = j;
                }
            }
            return false;
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
            return equals(then) ? this : new And(this, then);
        }

        default boolean isAlwaysFalse() { return false; }

        default boolean isAlwaysTrue() { return false; }
    }

    static class LoggedOp implements Op {

        private final Op op;

        private LoggedOp(Op op) {
            this.op = op;
        }

        static LoggedOp of(Op op) {
            return op instanceof LoggedOp ? (LoggedOp) op : new LoggedOp(op);
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
        public boolean apply(ValuesProvider provider) { return true; }

        @Override
        public Op and(Op then) { return then; }

        @Override
        public String toString() { return "true"; }
    }

    static class SameNeq extends False {

        private final char operand;

        SameNeq(char operand) { this.operand = operand; }

        @Override
        public String toString() { return operand + "!=" + operand; }
    }

    static class SameEq extends True {

        private final char operand;

        SameEq(char operand) { this.operand = operand; }

        @Override
        public String toString() { return operand + "==" + operand; }
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
