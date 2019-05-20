package leetcode;

/**
 * Created by zhaochaoqun on 2017/6/19.
 */
public class ConstructStringFromBinaryTree {

    public static String tree2str(TreeNode t) {
        if(t == null) return "";
        StringBuffer sb = new StringBuffer(Integer.toString(t.val));
        tree2str(t, sb);
        return sb.toString();
    }

    private static void tree2str(TreeNode t, StringBuffer sb) {
        if(t.left == null) {
            if(t.right == null) {
                return;
            }
            sb.append("(").append(")");
        } else {
            sb.append("(").append(tree2str(t.left)).append(")");
        }
        if(t.right != null)
            sb.append("(").append(tree2str(t.right)).append(")");
    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        System.out.println(tree2str(node1));
        System.out.println("1(2()(4))(3)");
        System.out.println("1(2()(4))(3)".equals(tree2str(node1)));
    }
}
