package leetcode;

import java.util.*;

public class _126_5 {
    public static void main(String[] args) {
//        String beginWord = "hit";
//        String endWord = "cog";
//        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        String beginWord = "red";
        String endWord = "tax";
        List<String> wordList = Arrays.asList("ted","tex","red","tax","tad","den","rex","pee");
        for(List<String> current : new _126_5().findLadders(beginWord, endWord, wordList)) {
            System.out.println(current);
        }
    }

    boolean isAdjacent(char[] word1, char[] word2) {
        int  count = 0;
        for (int i = 0; count < 2 && i < word1.length; i++)
            if (word1[i] != word2[i])
                ++count;
        return count == 1;
    }

    void addResult(int endIndex, List<Integer>[] path, List<List<String>> result, List<String> current, List<String> wordList, String beginWord) {
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
        Queue<Integer>[] graphics = new Queue[length + 1];
        int[] visit = new int[length];
        List<Integer>[] path = new ArrayList[length];
        for (int i = 0; i <= length; i++) {
            graphics[i] = new LinkedList<>();
        }
        int wordLength = beginWord.length();
        char[][] charMatrix = new char[length + 1][wordLength];
        for(int i = 0; i < length; i++)
            charMatrix[i] = wordList.get(i).toCharArray();
        charMatrix[length] = beginWord.toCharArray();
        for (int i = 0; i < length; i++) {
            if (isAdjacent(charMatrix[length], charMatrix[i])) {
                graphics[length].add(i);
            }
        }
        if (graphics[length].size() == 0) return result;

        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (isAdjacent(charMatrix[i], charMatrix[j])) {
                    graphics[j].add(i);
                    graphics[i].add(j);
                }
            }
        }
        if (graphics[endIndex].size() == 0) return result;
        if (graphics[length].size() == 0 || graphics[endIndex].size() == 0) return result;
        Queue<Integer> queue = new LinkedList<>(graphics[length]);
        while (!queue.isEmpty()) {
            int count = queue.size();
            if (queue.contains(endIndex)) {
                List<String> current = new ArrayList<>();
                addResult(endIndex, path, result, current, wordList, beginWord);
                return result;
            }
            for (Integer index : queue)
                visit[index] = 1;
            for (int i = 0; i < count; i++){
                int index = queue.poll();
                for (Integer neighbor : graphics[index]) {
                    if (visit[neighbor] == 0) {
                        if (path[neighbor] == null) {
                            path[neighbor] = new ArrayList<>();
                        }
                        path[neighbor].add(index);
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return result;
    }
}
