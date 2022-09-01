package org.gd.leetcode.p0355;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("LeetCode #355: Design Twitter")
class TwitterTest {

    @Test
    @DisplayName("Test #1")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test() {

        Twitter twitter = new Twitter();

        // User 1 posts a new tweet (id = 5).
        twitter.postTweet(1, 5);

        // User 1's news feed should return a list with 1 tweet id -> [5].
        assertEquals(
                java.util.Arrays.asList(5),
                twitter.getNewsFeed(1)
        );

        // User 1 follows user 2.
        twitter.follow(1, 2);

        // User 2 posts a new tweet (id = 6).
        twitter.postTweet(2, 7);
        twitter.postTweet(2, 6);

        // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
        // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        assertEquals(
                java.util.Arrays.asList(6, 7, 5),
                twitter.getNewsFeed(1)
        );

        for (int i = 150; i > 100; i--) {
            twitter.postTweet(2, i);
        }

        assertEquals(
                IntStream.rangeClosed(101, 110).boxed().collect(Collectors.toList()),
                twitter.getNewsFeed(1)
        );

        // User 1 unfollows user 2.
        twitter.unfollow(1, 2);

        // User 1's news feed should return a list with 1 tweet id -> [5],
        // since user 1 is no longer following user 2.
        assertEquals(
                java.util.Arrays.asList(5),
                twitter.getNewsFeed(1)
        );
    }

    @Test
    @DisplayName("Test #2")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_002() {

        Twitter twitter = new Twitter();

        assertTrue(twitter.getNewsFeed(1).isEmpty());

        for (int i = 1; i <= 50; i++) {
            twitter.postTweet(i % 3, 100 + i);
        }

        assertEquals(
                java.util.Arrays.asList(150, 147, 144, 141, 138, 135, 132, 129, 126, 123),
                twitter.getNewsFeed(2));

        twitter.follow(2, 1);

        assertEquals(
                java.util.Arrays.asList(150, 149, 147, 146, 144, 143, 141, 140, 138, 137),
                twitter.getNewsFeed(2));

        twitter.follow(2, 0);

        assertEquals(
                java.util.Arrays.asList(150, 149, 148, 147, 146, 145, 144, 143, 142, 141),
                twitter.getNewsFeed(2));

        twitter.unfollow(2, 1);

        assertEquals(
                java.util.Arrays.asList(150, 148, 147, 145, 144, 142, 141, 139, 138, 136),
                twitter.getNewsFeed(2));

    }
}
