package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _684 {

    public static void main(String[] args) {
        _684 test = new _684();
        System.out.println(Arrays.toString(test.findRedundantConnection(new int[][]{{1,2}, {1,3}, {2,3}})));
        System.out.println(Arrays.toString(test.findRedundantConnection(new int[][]{{1,2}, {2,3}, {3,4}, {1,4}, {1,5}})));
        System.out.println(Arrays.toString(test.findRedundantConnection(new int[][]{{1,2},{2,3},{1,5},{3,4},{1,4}})));


    }
    List<Integer> list;
    public int[] findRedundantConnection(int[][] edges) {
        list = new ArrayList<>();
        list.add(0);
        for(int[] edge : edges) {
            int left = getParent(edge[0]);
            int right = getParent(edge[1]);
            if(left != right) {
                setParent(edge[1], left);
            } else {
                return edge;
            }
        }
        return null;
    }

    private void setParent(int i, int parent) {
        while(i != list.get(i)) {
            int temp = list.get(i);
            list.set(i, parent);
            i = temp;
        }
        list.set(i, parent);

    }
    private int getParent(int i) {
        for(int j = list.size(); j <= i; j++)
            list.add(j);
        for(; i != list.get(i); i = list.get(i));
        return i;
    }

}
