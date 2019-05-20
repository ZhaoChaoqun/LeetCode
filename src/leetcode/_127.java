package leetcode;

import java.util.*;

public class _127 {

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
//        String beginWord = "hit";
//        String endWord = "cog";
//        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log");

//        String beginWord = "a";
//        String endWord = "c";
//        List<String> wordList = Arrays.asList("a","b","c");
        System.out.println(new _127().ladderLength(beginWord, endWord, wordList));
    }

    class Graphic {
        Queue<Integer> list = new LinkedList<>();
        boolean visit;
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
        Graphic[] graphics = new Graphic[length + 1];
        for (int i = 0; i <= length; i++)
            graphics[i] = new Graphic();

        for (int i = 0; i < length; i++) {
            if (isAdjacent(beginWord, wordList.get(i))) {
                graphics[length].list.add(i);
            }
        }
        if (graphics[length].list.size() == 0) return 0;

        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (isAdjacent(wordList.get(i), wordList.get(j))) {
                    graphics[j].list.add(i);
                    graphics[i].list.add(j);
                }
            }
        }
        if (graphics[endIndex].list.size() == 0) return 0;

        Queue<Integer> queue = graphics[length].list;
        for (Integer neighbor : graphics[length].list)
            graphics[neighbor].visit = true;
        int step = 1;
        while (!queue.isEmpty()) {
            step++;
            Queue<Integer> newList = new LinkedList<>();
            for (Integer index : queue) {
                if (index == endIndex)
                    return step;
                for (Integer neighbor : graphics[index].list) {
                    if (!graphics[neighbor].visit) {
                        graphics[neighbor].visit = true;
                        newList.add(neighbor);
                    }
                }
            }
            queue = newList;
        }
        return 0;
    }

}
