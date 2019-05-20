package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class _126 {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        for(List<String> current : new _126().findLadders(beginWord, endWord, wordList)) {
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

    void backtracking(List<String> current, int index) {
        if(index == wordList.size())
            current.add(beginWord);
        else
            current.add(wordList.get(index));
        if(index == endIndex) {
            List<String> last = new ArrayList<>(current.size());
            last.addAll(current);
            result.add(last);
        } else {
            for (int i : graphics[index]) {
                if (visit[i] == 0) {
                    visit[i] = 1;
                    backtracking(current, i);
                    visit[i] = 0;
                }
            }
        }
        current.remove(current.size() - 1);
    }
    List<List<String>> result = new ArrayList<>();
    List<Integer>[] graphics;
    int[] visit;
    int endIndex;
    String beginWord;
    List<String> wordList;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        endIndex = wordList.indexOf(endWord);
        if(endIndex == -1) return result;
        this.wordList = wordList;
        this.beginWord = beginWord;
        int length = wordList.size();
        graphics = new List[length + 1];
        visit = new int[length];
        for (int i = 0; i <= length; i++)
            graphics[i] = new ArrayList<>();

        for (int i = 0; i < length; i++)
            if (isAdjacent(beginWord, wordList.get(i)))
                graphics[length].add(i);
        if (graphics[length].size() == 0) return result;

        for (int i = 0; i < length - 1; i++)
            for (int j = i + 1; j < length; j++)
                if (isAdjacent(wordList.get(i), wordList.get(j))) {
                    graphics[j].add(i);
                    graphics[i].add(j);
                }
        if (graphics[endIndex].size() == 0) return result;
//        wordList.add(beginWord);
        backtracking(new ArrayList<>(), length);
        int min = Integer.MAX_VALUE;
        for(List<String> item : result)
            min = Math.min(item.size(), min);
        for(Iterator<List<String>> iterator = result.iterator(); iterator.hasNext();) {
            List<String> next = iterator.next();
            if(next.size() > min)
                iterator.remove();
        }
        return result;
    }
}
