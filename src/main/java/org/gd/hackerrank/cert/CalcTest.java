package org.gd.hackerrank.cert;

class CalcTest {

    public static void main(String[] args) {
        Calculator c = new Adder();
        System.out.println("c.add(1, 2)): " + c.add(1, 2));
    }

    interface Calculator {

        int add(int a, int b);
    }

    static class Adder implements Calculator {

        @Override
        public int add(int a, int b) {
            return a + b;
        }
    }
}