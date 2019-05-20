package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _127_3 {

    public static void main(String[] args) {
//        String beginWord = "hit";
//        String endWord = "cog";
//        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
//        String beginWord = "hit";
//        String endWord = "cog";
//        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log");

        String beginWord = "a";
        String endWord = "c";
        List<String> wordList = Arrays.asList("a","b","c");
        System.out.println(new _127_3().ladderLength(beginWord, endWord, wordList));
    }

    boolean isAdjacent(String word1, String word2) {
        int  count = 0;
        for (int i = 0; count < 2 && i < word1.length(); i++)
            if (word1.charAt(i) != word2.charAt(i))
                ++count;
        return count == 1;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int endIndex = wordList.indexOf(endWord);
        if(endIndex == -1) return 0;
        int length = wordList.size();
        List<Integer>[] graphics = new List[length + 1];
        int[] visit = new int[length];
        for (int i = 0; i <= length; i++)
            graphics[i] = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            if (isAdjacent(beginWord, wordList.get(i))) {
                graphics[length].add(i);
                visit[i] = 1;
            }
            if (isAdjacent(endWord, wordList.get(i))) {
                graphics[endIndex].add(i);
            }
        }
        if (graphics[length].size() == 0 || graphics[endIndex].size() == 0) return 0;
        List<Integer> queue = graphics[length];
        int step = 1;
        while (!queue.isEmpty()) {
            step++;
            List<Integer> newList = new ArrayList<>();
            if(queue.indexOf(endIndex) != -1) return step;
            for (Integer index : queue) {
                for (int i = 0; i < length; i++) {
                    if(visit[i] == 0 && isAdjacent(wordList.get(i), wordList.get(index))) {
                        visit[i] = 1;
                        newList.add(i);
                    }
                }
            }
            queue = newList;
        }
        return 0;
    }

}
