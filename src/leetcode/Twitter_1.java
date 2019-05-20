package leetcode;

import java.util.*;

public class Twitter_1 {
    class Message {
        int userId;
        int tweetId;
        Set<Integer> followees = new HashSet<>();

        Message(int userId, int tweetId) {
            this.userId = userId;
            this.tweetId = tweetId;
            if (followMap.containsKey(userId))
                followees.addAll(followMap.get(userId));
            followees.add(userId);
        }
    }

    Map<Integer, Set<Integer>> followMap = new HashMap<>();
    List<Message> list = new LinkedList<>();
    public Twitter_1() {

    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        list.add(0, new Message(userId, tweetId));
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> newsFeed = new ArrayList<>(10);
        int count = 0;
        for (Message message : list) {
            if (message.followees.contains(userId)) {
                newsFeed.add(message.tweetId);
                if (++count == 10)
                    return newsFeed;
            }
        }
        return newsFeed;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        for (Message message : list) {
            if (message.userId == followeeId)
                message.followees.add(followerId);
        }
        if (!followMap.containsKey(followeeId)) {
            followMap.put(followeeId, new HashSet<>());
        }
        followMap.get(followeeId).add(followerId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if(followerId == followeeId)
            return;
        for (Message message : list) {
            if (message.userId == followeeId)
                message.followees.remove(followerId);
        }
        if(followMap.containsKey(followeeId))
            followMap.get(followeeId).remove(followerId);
    }

    public static void main(String[] args) {
        Twitter_1 twitter = new Twitter_1();
        twitter.postTweet(1, 5);
        twitter.unfollow(1, 1);
        System.out.println(twitter.getNewsFeed(1));
    }
}


