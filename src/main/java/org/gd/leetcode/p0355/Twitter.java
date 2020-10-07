package org.gd.leetcode.p0355;

import org.gd.leetcode.common.LeetCode;

import java.util.*;

/**
 * https://leetcode.com/problems/design-twitter/
 *
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0023.Solution
 * @since 2020-07-07
 */
@SuppressWarnings({"JavadocReference", "SameParameterValue"})
@LeetCode(
        name = "Design Twitter",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = LeetCode.Tags.DESIGN
)
class Twitter {

    private final Map<Integer, User> users = new HashMap<>();

    /**
     * Initialize your data structure here.
     */
    public Twitter() {}

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        users.computeIfAbsent(userId, User::new).addTweet(tweetId);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users
     * who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        User user = users.get(userId);
        if (user == null)
            return Collections.emptyList();

        return user.getNewsFeed();
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        User followee = users.computeIfAbsent(followeeId, User::new);
        User follower = users.computeIfAbsent(followerId, User::new);
        follower.follow(followee);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        users.computeIfAbsent(followerId, User::new).unfollow(followeeId);
    }

    static class User {

        final int id;
        final LinkedHashMap<Integer, User> following;

        Tweet headTweet;

        User(int id) {
            this.id = id;
            this.following = new LinkedHashMap<>();
        }

        void follow(User followee) {
            if (followee != null && followee.id != id)
                following.put(followee.id, followee);
        }

        void unfollow(int id) {
            following.remove(id);
        }

        void addTweet(int tweetId) {
            headTweet = new Tweet(tweetId, headTweet);
        }

        List<Integer> getNewsFeed() {
            return getNewsFeed(10);
        }

        List<Integer> getNewsFeed(int limit) {

            if (limit <= 0)
                return Collections.emptyList();

            final ArrayList<Integer> newsFeed = new ArrayList<>(limit);

            final int followingSize = following.size();

            // ================================================================
            // 1. if user has no followee
            //
            if (followingSize == 0) {
                Tweet tweet = headTweet;
                while (limit > 0 && tweet != null) {
                    newsFeed.add(tweet.id);
                    tweet = tweet.next;
                    limit--;
                }
                return newsFeed;
            }

            // ================================================================
            // 2. if user has only one followee
            //
            if (followingSize == 1) {

                User followee = following.values().iterator().next();

                Tweet tweet0 = headTweet;
                Tweet tweet1 = followee.headTweet;

                while (tweet0 != null && tweet1 != null && limit > 0) {

                    if (tweet0.compareTo(tweet1) > 0) {
                        newsFeed.add(tweet1.id);
                        tweet1 = tweet1.next;
                    } else {
                        newsFeed.add(tweet0.id);
                        tweet0 = tweet0.next;
                    }

                    limit--;
                }

                while (tweet0 != null && limit > 0) {
                    newsFeed.add(tweet0.id);
                    tweet0 = tweet0.next;
                    limit--;
                }

                while (tweet1 != null && limit > 0) {
                    newsFeed.add(tweet1.id);
                    tweet1 = tweet1.next;
                    limit--;
                }

                return newsFeed;
            }

            // ================================================================
            // 3. user has more than one followee
            //
            PriorityQueue<Tweet> q = new PriorityQueue<>(1 + followingSize);

            // add head tweet of current user
            if (headTweet != null)
                q.add(headTweet);

            // add head tweets of of all following users
            for (Map.Entry<Integer, User> entry : following.entrySet()) {
                Tweet followingHeadTweet = entry.getValue().headTweet;
                if (followingHeadTweet != null)
                    q.add(followingHeadTweet);
            }

            Tweet tweet;

            // pull head from the heap and add tweet id to the list
            while ((tweet = q.poll()) != null && limit > 0) {

                newsFeed.add(tweet.id);
                limit--;

                // put next tweet inside heap, if it exists
                if (tweet.next != null)
                    q.add(tweet.next);

            }

            return newsFeed;
        }
    }

    static class Tweet implements Comparable<Tweet> {

        private static long TIME = Long.MIN_VALUE;

        final int id;
        final long time;
        final Tweet next;

        Tweet(int id, Tweet next) {
            this.id = id;
            this.next = next;
            this.time = TIME++;
        }

        @Override
        public int compareTo(Tweet o) {
            return Long.compare(o.time, time);
        }
    }
}
