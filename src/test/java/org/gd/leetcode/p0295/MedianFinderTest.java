package org.gd.leetcode.p0295;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link MedianFinder}
 *
 * @since 2019-09-24
 */
class MedianFinderTest {

    @Test
    @DisplayName("main")
    void test_main() throws Exception {
        MedianFinder medianFinder0 = new MedianFinder();

        medianFinder0.addNum(1);
        medianFinder0.addNum(2);
        assertEquals(1.5d, medianFinder0.findMedian());
        medianFinder0.addNum(3);
        assertEquals(2d, medianFinder0.findMedian());
        medianFinder0.addNum(0);
        medianFinder0.addNum(0);
        assertEquals(1d, medianFinder0.findMedian());

        for (int i = 0; i < 1000; i++) {
            medianFinder0.addNum(ThreadLocalRandom.current().nextInt());
        }
    }

    @Test
    @DisplayName("main_001")
    void test_main_001() throws Exception {

        MedianFinder mf = new MedianFinder();

        mf.addNum(6);
        assertEquals(6d, mf.findMedian());
        mf.addNum(10);
        assertEquals(8d, mf.findMedian());
        mf.addNum(2);
        assertEquals(6d, mf.findMedian());
        mf.addNum(6);
        assertEquals(6d, mf.findMedian());
        mf.addNum(5);
        assertEquals(6d, mf.findMedian());

        /*
        ["addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian"]
        ["5","0","0","0","6","0","3","0","1","0","0","0","0","0"]
        [null,6.0,null,5.5,null,6.0,null,5.5,null,5.0,null,4.0,null,3.0]
        [null,5.80000,null,4.83333,null,5.0,null,4.75000,null,4.33333,null,3.90000,null,3.54545]
         */
    }
}