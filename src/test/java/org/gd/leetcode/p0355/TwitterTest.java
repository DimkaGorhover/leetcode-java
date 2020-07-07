package org.gd.leetcode.p0355;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TwitterTest {

    @Test
    void test() {

        Twitter twitter = new Twitter();

        // User 1 posts a new tweet (id = 5).
        twitter.postTweet(1, 5);

        // User 1's news feed should return a list with 1 tweet id -> [5].
        assertEquals(
                List.of(5),
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
                List.of(6, 7, 5),
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
                List.of(5),
                twitter.getNewsFeed(1)
        );
    }

    @Test
    void test_002() {
        Twitter twitter = new Twitter();
        twitter.getNewsFeed(1);
    }
}