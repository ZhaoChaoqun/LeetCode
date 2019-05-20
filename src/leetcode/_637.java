package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _637 {
    public static void main(String[] args) {
        _637 test = new  _637();
        TreeNode node1 = new TreeNode(2147483647);
        TreeNode node2 = new TreeNode(2147483647);
        TreeNode node3 = new TreeNode(2147483647);
//        TreeNode node4 = new TreeNode(15);
//        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
//        node3.left = node4;
//        node3.right = node5;
        System.out.println(test.averageOfLevels(node1));
    }


    void backtracking(TreeNode node, int level, List<double[]> levels) {
        if(node == null)
            return;
        if(levels.size() <= level) {
            levels.add(new double[] {node.val, 1});
        } else {
            double[] array = levels.get(level);
            array[0] += node.val;
            ++array[1];
        }
        backtracking(node.left, level+ 1, levels);
        backtracking(node.right, level+ 1, levels);
    }
    public List<Double> averageOfLevels(TreeNode root) {
        List<double[]> levels = new ArrayList<>();
        backtracking(root, 0, levels);
        List<Double> result = new ArrayList<>(levels.size());
        for(double[] level : levels) {
            result.add(level[0] / level[1]);
        }
        return result;
    }
}
