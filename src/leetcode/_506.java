package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _506 {



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
        if(!priorityQueue.isEmpty())
            ranks[priorityQueue.poll()[1]] = "Gold Medal";
        if(!priorityQueue.isEmpty())
            ranks[priorityQueue.poll()[1]] = "Silver Medal";
        if(!priorityQueue.isEmpty())
            ranks[priorityQueue.poll()[1]] = "Bronze Medal";
        for(int i = 4; !priorityQueue.isEmpty(); i++)
            ranks[priorityQueue.poll()[1]] = Integer.toString(i);
        return ranks;
    }

    public static void main(String[] args) {
        _506 test = new _506();
//        System.out.println(Arrays.toString(test.findRelativeRanks(new int[] {5,4,3,2,1})));
        test.findRelativeRanks(new int[] {7,2,4,6,8,5});
        test.findRelativeRanks(new int[] {5,4,3,2,1});
    }
}
