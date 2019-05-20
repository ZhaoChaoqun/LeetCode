package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class _621 {
    public static void main(String[] args) {
        System.out.println(new _621().leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
        System.out.println(new _621().leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 1));
        System.out.println(new _621().leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B', 'C'}, 1));
        System.out.println(new _621().leastInterval(new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}, 2));
        System.out.println(new _621().leastInterval(new char[]{'A', 'B', 'A'}, 2));

    }

    private void backtracking(PriorityQueue<Integer> priorityQueue, int interval) {
        if (interval == 0 || priorityQueue.size() == 0) {
            intervals += interval;
            return;
        }
        intervals++;
        int count = priorityQueue.poll();
        backtracking(priorityQueue, interval - 1);
        if (count > 1)
            priorityQueue.offer(count - 1);
    }

    int intervals = 0;

    public int leastInterval(char[] tasks, int n) {
        int[] array = new int[26];
        for (char task : tasks) {
            array[task - 'A']++;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int count : array)
            if (count > 0)
                priorityQueue.add(count);
        while (priorityQueue.size() > 0) {
            if (priorityQueue.peek() == 1)
                return intervals + priorityQueue.size();
            backtracking(priorityQueue, n + 1);
        }
        return intervals;
    }

}
