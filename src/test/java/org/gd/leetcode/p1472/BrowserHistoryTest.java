package org.gd.leetcode.p1472;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link BrowserHistory}
 */
@DisplayName("LeetCode #1472: Design Browser History")
class BrowserHistoryTest {

    @Test
    void test_001() {

        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");

        browserHistory.visit("google.com");
        browserHistory.visit("facebook.com");
        browserHistory.visit("youtube.com");

        assertEquals("facebook.com", browserHistory.back(1));
        assertEquals("google.com", browserHistory.back(1));
        assertEquals("facebook.com", browserHistory.forward(1));

        browserHistory.visit("linkedin.com");

        assertEquals("linkedin.com", browserHistory.forward(2));

        assertEquals("google.com", browserHistory.back(2));
        assertEquals("leetcode.com", browserHistory.back(7));
    }
}