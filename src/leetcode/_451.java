package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _451 {

    public String frequencySort(String s) {
        char[] c = s.toCharArray();
        int[] frequency = new int[128];
        for(char ch : c) {
            frequency[ch]++;
        }
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        for(int i = 0; i < frequency.length; i++) {
            if(frequency[i] > 0)
                priorityQueue.offer(new int[] {frequency[i], i});
        }
        StringBuilder sb = new StringBuilder();
        for(; !priorityQueue.isEmpty();) {
            int[] item = priorityQueue.poll();
            for(int i = 0; i < item[0]; i++)
                sb.append((char)(item[1]));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        _451 test = new _451();
        System.out.println((int)'0');
//        System.out.println(test.frequencySort("tree"));
//        System.out.println(test.frequencySort("cccaaa"));
//        System.out.println(test.frequencySort("Aabb"));
    }
}
