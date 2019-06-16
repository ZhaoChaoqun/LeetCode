package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class _433_2 {
    public static void main(String[] args) {
        _433_2 test = new _433_2();
        System.out.println(test.minMutation("AACCGGTT","AACCGGTA", new String[]{"AACCGGTA"}));
        System.out.println(test.minMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"}));
        System.out.println(test.minMutation("AAAAACCC", "AACCCCCC", new String[]{"AAAACCCC", "AAACCCCC", "AACCCCCC"}));
    }

    public int minMutation(String start, String end, String[] bank) {
        int endIndex = 0;
        for(; endIndex < bank.length; endIndex++)
            if(end.equals(bank[endIndex]))
                break;
        if(endIndex == bank.length) return -1;
        char[] c = start.toCharArray();
        char[][] matrix = new char[bank.length][bank[0].length()];
        List<Integer>[] graph = new List[bank.length];
        for(int i = 0; i < bank.length; i++) {
            matrix[i] = bank[i].toCharArray();
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < bank.length - 1; i++) {
            for(int j = i + 1; j < bank.length; j++) {
                if(isNeighbor(matrix[i], matrix[j])) {
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }
        int[] visited = new int[bank.length];
        visited[endIndex] = 1;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(endIndex);
        int step = 0;
        for(; !queue.isEmpty();) {
            step++;
            for(int j = 0, length = queue.size(); j < length; j++) {
                int index = queue.poll();
                if(isNeighbor(c, matrix[index]))
                    return step;
                for(int i = 0; i < graph[index].size(); i++) {
                    if(visited[graph[index].get(i)] == 0) {
                        visited[graph[index].get(i)] = 1;
                        queue.offer(graph[index].get(i));
                    }
                }
            }

        }
        return -1;
    }

    private boolean isNeighbor(char[] ac, char[] bc) {
        int diff = 0;
        for(int i = 0; i < ac.length; i++) {
            if(ac[i] != bc[i]) {
                if(++diff == 2) {
                    return false;
                }
            }
        }
        return true;
    }
}
