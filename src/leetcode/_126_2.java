package leetcode;

import java.util.*;

public class _126_2 {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        for(List<String> current : new _126_2().findLadders(beginWord, endWord, wordList)) {
            System.out.println(current);
        }
    }

    boolean isAdjacent(String word1, String word2) {
        int  count = 0;
        for (int i = 0; count < 2 && i < word1.length(); i++)
            if (word1.charAt(i) != word2.charAt(i))
                ++count;
        return count == 1;
    }

    void addResult(int endIndex, Set<Integer>[] path, List<List<String>> result, List<String> current, List<String> wordList, String beginWord) {
        if(path[endIndex] == null) {
            List<String> newList = new ArrayList<>(current.size() + 1);
            newList.add(beginWord);
            newList.add(wordList.get(endIndex));
            newList.addAll(current);
            result.add(newList);
        } else {
            current.add(0, wordList.get(endIndex));
            for(int i : path[endIndex]) {
                addResult(i, path, result, current, wordList, beginWord);
            }
            current.remove(0);
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        int endIndex = wordList.indexOf(endWord);
        if(endIndex == -1) return result;
        int length = wordList.size();
        List<Integer>[] graphics = new List[length + 1];
        int[] visit = new int[length];
        Set<Integer>[] path = new Set[length];
        for (int i = 0; i <= length; i++) {
            graphics[i] = new ArrayList<>();
        }

        for (int i = 0; i < length; i++) {
            if (isAdjacent(beginWord, wordList.get(i))) {
                graphics[length].add(i);
//                if(path[i] == null) {
//                    path[i] = new ArrayList<>();
//                }
//                path[i].add(length);
//                visit[i] = 1;
            }
            if (isAdjacent(endWord, wordList.get(i))) {
                graphics[endIndex].add(i);
            }
        }
        if (graphics[length].size() == 0 || graphics[endIndex].size() == 0) return result;
        List<Integer> queue = graphics[length];
        while (!queue.isEmpty()) {
            List<Integer> newList = new ArrayList<>();
            if(queue.indexOf(endIndex) != -1) {
                List<String> current = new ArrayList<>();
                addResult(endIndex, path, result, current, wordList, beginWord);
                return result;
            }
            for (Integer index : queue)
                visit[index] = 1;
            for (Integer index : queue) {
                for (int i = 0; i < length; i++) {
                    if(visit[i] == 0 && isAdjacent(wordList.get(i), wordList.get(index))) {
                        if(path[i] == null) {
                            path[i] = new HashSet<>();
                        }
                        path[i].add(index);
                        newList.add(i);
                    }
                }
            }
            queue = newList;
        }
        return result;
    }
}
