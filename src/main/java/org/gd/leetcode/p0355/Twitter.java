package org.gd.leetcode.p0355;

import org.gd.leetcode.common.LeetCode;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * https://leetcode.com/problems/design-twitter/
 *
 * @see org.gd.leetcode.p0023.Solution
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
        return Optional.ofNullable(users.get(userId))
                .map(User::getNewsFeed)
                .orElseGet(Collections::emptyList);
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
        final Map<Integer, User> following;
        final Tweets tweets;

        User(int id) {
            this.id = id;
            this.following = new LinkedHashMap<>();
            this.tweets = new Tweets();
        }

        void follow(User followee) {
            if (followee.id != id)
                following.put(followee.id, followee);
        }

        void unfollow(int id) {
            following.remove(id);
        }

        void addTweet(int tweetId) {
            tweets.add(tweetId, id);
        }

        List<Integer> getNewsFeed() {
            return getNewsFeed(10);
        }

        List<Integer> getNewsFeed(int limit) {

            if (limit <= 0)
                return Collections.emptyList();

            PriorityQueue<Tweet> q = new PriorityQueue<>(Tweet::compareTo);
            Map<Integer, Iterator<Tweet>> map = new HashMap<>();
            Iterator<Tweet> iterator = tweets.iterator();

            if (iterator.hasNext()) {
                q.add(iterator.next());
                map.put(id, iterator);
            }

            for (Map.Entry<Integer, User> entry : following.entrySet()) {
                User user = entry.getValue();
                iterator = user.tweets.iterator();
                if (iterator.hasNext()) {
                    q.add(iterator.next());
                    map.put(user.id, iterator);
                }
            }

            List<Integer> newsFeed = new ArrayList<>(limit);
            Tweet tweet;
            while ((tweet = q.poll()) != null && limit > 0) {
                newsFeed.add(tweet.id);
                iterator = map.get(tweet.userId);
                if (iterator.hasNext())
                    q.add(iterator.next());
                limit--;
            }

            return newsFeed;
        }
    }

    static class Tweets implements Iterable<Tweet> {

        private Tweet head;

        void add(int tweetId, int userId) {
            head = new Tweet(tweetId, userId, head);
        }

        @SuppressWarnings("NullableProblems")
        @Override
        public Iterator<Tweet> iterator() {

            if (head == null)
                return Collections.emptyIterator();

            return new TweetsIterator(head);
        }
    }

    static class TweetsIterator implements Iterator<Tweet> {

        private Tweet tweet;

        TweetsIterator(Tweet tweet) {
            this.tweet = tweet;
        }

        @Override
        public boolean hasNext() {
            return tweet != null;
        }

        @Override
        public Tweet next() {

            if (!hasNext())
                throw new NoSuchElementException();

            Tweet tweet = this.tweet;
            this.tweet = tweet.next;
            return tweet;
        }
    }

    static class Tweet implements Comparable<Tweet> {

        private static final AtomicLong TIME = new AtomicLong(Long.MIN_VALUE);

        final int id;
        final int userId;
        final long time;
        final Tweet next;

        Tweet(int id, int userId, Tweet next) {
            this.id = id;
            this.userId = userId;
            this.next = next;
            this.time = TIME.getAndAccumulate(1, Math::addExact);
        }

        @Override
        public int compareTo(Tweet o) {
            return Long.compare(o.time, time);
        }
    }
}
