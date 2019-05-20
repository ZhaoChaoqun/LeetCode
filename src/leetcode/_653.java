package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _653 {

    public static void main(String[] args) {

    }
    List<Integer> list = new ArrayList<>();

    private void recursive(TreeNode node) {
        if(node != null) {
            recursive(node.left);
            list.add(node.val);
            recursive(node.right);
        }
    }
    public boolean findTarget(TreeNode root, int k) {
        if(root == null)
            return false;
        recursive(root);
        for(int i = 0, j = list.size() - 1; i < j;) {
            if(list.get(i) + list.get(j) > k) {
                j--;
            } else if(list.get(i) + list.get(j) < k) {
                i++;
            } else
                return true;
        }
        return false;
    }
}
