package leetcode;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;

public class _218 {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        int length = buildings.length;
        // array[i]数组length=3
        // array[i][0]表示index，array[i][1]表示高度，array[i][2]：0表示start、1表示end。
        int[][] array = new int[length << 1][3];
        int i = 0;
        for(int[] building : buildings) {
            array[i++] = new int[] {building[0], building[2], 0};
            array[i++] = new int[] {building[1], building[2], 1};
        }
        Arrays.sort(array, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {    // 若index相同
                    if(o1[2] == o2[2]) {
                        if(o1[2] == 1) {    // 若index相同的end，按照高度排正序
                            return o1[1] - o2[1];
                        } else if(o1[2] == 0) {   // 若index相同的start，按照高度排倒序
                            return o2[1] - o1[1];
                        }
                    }
                    return o1[2] - o2[2];   //index相同，start排在end前
                }
                return o1[0] - o2[0];   // 按照index正序排列
            }
        });
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        priorityQueue.offer(0);
        for(i = 0; i < array.length; i++) {
            if(array[i][2] == 0) {
                if(array[i][1] > priorityQueue.peek()) {
                    List<Integer> item = new ArrayList<>();
                    item.add(array[i][0]);
                    item.add(array[i][1]);
                    result.add(item);
                }
                priorityQueue.offer(array[i][1]);
            } else {
                priorityQueue.remove(array[i][1]);
                if(priorityQueue.peek() < array[i][1]) {
                    List<Integer> item = new ArrayList<>();
                    item.add(array[i][0]);
                    item.add(priorityQueue.peek());
                    result.add(item);
                }
            }
        }
        return result;
    }




    public static void main(String[] args) {
//        _218 test = new _218();
//        int[][] buildings = new int[][]{{0,2,3},{2,5,3}};
////        buildings = new int[][]{ {2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8} };
//        for(List<Integer> item : test.getSkyline(buildings)) {
//            System.out.println(item);
//        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(1);
        priorityQueue.offer(2);
        priorityQueue.offer(1);
        System.out.println(priorityQueue.size());
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(1);
        System.out.println(treeSet.size());
        ConcurrentSkipListSet<Integer> concurrentSkipListSet = new ConcurrentSkipListSet<>();
        concurrentSkipListSet.add(1);
        concurrentSkipListSet.add(2);
        concurrentSkipListSet.add(1);
        System.out.println(concurrentSkipListSet.size());
    }
}
