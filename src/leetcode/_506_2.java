package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _506_2 {

    public String[] findRelativeRanks(int[] nums) {
        String[] ranks = new String[nums.length];
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(nums.length, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });

        for(int i = 0; i < nums.length; i++) {
            priorityQueue.offer(new int[]{nums[i], i});
        }
        int[] head;
        for(int i = 1; !priorityQueue.isEmpty(); i++) {
            head = priorityQueue.poll();
            if(i == 1)
                ranks[head[1]] = "Gold Medal";
            else if(i == 2)
                ranks[head[1]] = "Silver Medal";
            else if(i == 3)
                ranks[head[1]] = "Bronze Medal";
            else
                ranks[head[1]] = Integer.toString(i);
        }
        return ranks;
    }

    public static void main(String[] args) {
        _506_2 test = new _506_2();
        System.out.println(Arrays.toString(test.findRelativeRanks(new int[] {7,2,4,6,8,5})));
        System.out.println(Arrays.toString(test.findRelativeRanks(new int[] {5,4,3,2,1})));
    }
}
