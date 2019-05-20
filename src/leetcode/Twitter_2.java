package leetcode;

import java.util.*;

public class Twitter_2 {
    int id = 0;
    class Message {
        int id;
        int tweetId;

        Message(int id, int tweetId) {
            this.id = id;
            this.tweetId = tweetId;
        }
    }

    Map<Integer, Set<Integer>> followMap = new HashMap<>();
    Map<Integer, List<Message>> messageMap = new HashMap<>();
    List<Message> list = new LinkedList<>();
    public Twitter_2() {
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        List<Message> messages = messageMap.get(userId);
        if(messages == null) {
            messages = new LinkedList<>();
            messageMap.put(userId, messages);
        }
        if(messages.size() == 10)
            messages.remove(9);
        messages.add(0, new Message(id++, tweetId));
    }

    public List<Integer> getNewsFeed(int userId) {
        if(!followMap.containsKey(userId)) {
            if(!messageMap.containsKey(userId))
                return Collections.emptyList();
            List<Message> messages = messageMap.get(userId);
            List<Integer> newsFeed = new ArrayList<>(messages.size());
            for(Message message : messages)
                newsFeed.add(message.tweetId);
            return newsFeed;
        }

        Set<Integer> followees = followMap.get(userId);
        List<Message>[] matrix = new List[followees.size() + 1];
        int length = 0;
        for(Integer followee : followees) {
            if(messageMap.containsKey(followee))
                matrix[length++] = messageMap.get(followee);
        }
        if(messageMap.containsKey(userId))
            matrix[length++] = messageMap.get(userId);
        if(length == 0)
            return Collections.emptyList();
        int[] index = new int[length];
        List<Integer> newsFeed = new ArrayList<>(10);
        for (int count = 0; count < 10; count++) {
            int maxId = -1, maxIndex = 0;
            boolean hasMessage = false;
            for (int i = 0; i < length; i++) {
                if(index[i] == matrix[i].size())
                    continue;
                int id = matrix[i].get(index[i]).id;
                if (id > maxId) {
                    maxId = id;
                    maxIndex = i;
                }
                hasMessage = true;
            }
            if(!hasMessage)
                return newsFeed;
            newsFeed.add(matrix[maxIndex].get(index[maxIndex]).tweetId);
            index[maxIndex]++;
        }
        return newsFeed;
    }

    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId)
            return;
        if (!followMap.containsKey(followerId)) {
            followMap.put(followerId, new HashSet<>());
        }
        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if(followerId == followeeId)
            return;
        if(followMap.containsKey(followerId))
            followMap.get(followerId).remove(followeeId);
    }

    public static void main(String[] args) {
        Twitter_2 twitter = new Twitter_2();
        twitter.postTweet(1, 5);
        twitter.follow(1, 1);
        System.out.println(twitter.getNewsFeed(1));
    }
}


