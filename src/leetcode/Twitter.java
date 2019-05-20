package leetcode;

import java.util.*;

public class Twitter {
    int id = 0;
    Map<Integer, Set<Integer>> followMap = new HashMap<>();
    Map<Integer, List<int[]>> messageMap = new HashMap<>();
    List<int[]> list = new LinkedList<>();
    public Twitter() {
    }

    public void postTweet(int userId, int tweetId) {
        List<int[]> messages = messageMap.get(userId);
        if(messages == null) {
            messages = new LinkedList<>();
            messageMap.put(userId, messages);
        }
        if(messages.size() == 10)
            messages.remove(9);
        messages.add(0, new int[]{id++, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        if(!followMap.containsKey(userId)) {
            if(!messageMap.containsKey(userId))
                return Collections.emptyList();
            List<int[]> messages = messageMap.get(userId);
            List<Integer> newsFeed = new ArrayList<>(messages.size());
            for(int[] message : messages)
                newsFeed.add(message[1]);
            return newsFeed;
        }

        Set<Integer> followees = followMap.get(userId);
        List<int[]>[] matrix = new List[followees.size() + 1];
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
                int id = matrix[i].get(index[i])[0];
                if (id > maxId) {
                    maxId = id;
                    maxIndex = i;
                }
                hasMessage = true;
            }
            if(!hasMessage)
                return newsFeed;
            newsFeed.add(matrix[maxIndex].get(index[maxIndex])[1]);
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
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        twitter.follow(1, 1);
        System.out.println(twitter.getNewsFeed(1));
    }
}


