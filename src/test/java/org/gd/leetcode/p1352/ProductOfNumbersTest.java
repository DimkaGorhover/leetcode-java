package org.gd.leetcode.p1352;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductOfNumbersTest {

    @Test
    void test_001() {
        ProductOfNumbers pon = new ProductOfNumbers();
        pon.add(3);        // [3]
        pon.add(0);        // [3,0]
        pon.add(2);        // [3,0,2]
        pon.add(5);        // [3,0,2,5]
        pon.add(4);        // [3,0,2,5,4]
        assertEquals(0, pon.getProduct(5)); // return 20. The product of the last 2 numbers is 5 * 4 = 20
        assertEquals(0, pon.getProduct(4)); // return 20. The product of the last 2 numbers is 5 * 4 = 20
        assertEquals(20, pon.getProduct(2)); // return 20. The product of the last 2 numbers is 5 * 4 = 20
        pon.getProduct(3); // return 40. The product of the last 3 numbers is 2 * 5 * 4 = 40
        pon.getProduct(4); // return 0. The product of the last 4 numbers is 0 * 2 * 5 * 4 = 0
        pon.add(8);        // [3,0,2,5,4,8]
        pon.getProduct(2); // return 32. The product of the last 2 numbers is 4 * 8 = 32
    }

    @Test
    void test_002() {
        ProductOfNumbers pon = new ProductOfNumbers();
        for (int i = 0; i < 5; i++) {
            pon.add(i + 1);
        }

        System.out.println(pon);
    }
}