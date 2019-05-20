package leetcode;

public class _789 {

    public static void main(String[] args) {
        _789 test = new _789();
//        System.out.println(test.escapeGhosts(new int[][]{{1, 0}, {0, 3}}, new int[]{0, 1}));
//        System.out.println(test.escapeGhosts(new int[][]{{1, 0}}, new int[]{2, 0}));
//        System.out.println(test.escapeGhosts(new int[][]{{2, 0}}, new int[]{1, 0}));
        System.out.println(test.escapeGhosts(new int[][]{{1, 9}, {2, -5}, {3, 8}, {9, 8}, {-1, 3}}, new int[]{8, -10}));
    }

    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int distance = Math.abs(target[0]) + Math.abs(target[1]);
        for (int i = 0; i < ghosts.length; i++) {
            if (Math.abs(ghosts[i][0] - target[0]) + Math.abs(ghosts[i][1] - target[1]) <= distance) {
                return false;
            }
        }
        return true;
    }
}
