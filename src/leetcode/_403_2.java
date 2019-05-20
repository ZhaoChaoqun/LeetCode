package leetcode;

public class _403_2 {

    public static void main(String[] args) {
        _403_2 test = new _403_2();
        System.out.println(test.canCross(new int[] {0,1,3,5,6,8,12,17}));
//        System.out.println(test.canCross(new int[] {0,1,3,6,10,15,19,21,24,26,30,33}));
    }

    boolean backtracking(int[] stones, int[][] matrix, int index, int step) {
        if(index == stones.length - 1) return true;
        if(matrix[index][step] != 0) {
            return false;
        }
        int i = index + 1;
        for(; i < stones.length && stones[i] - stones[index] <= step + 1; i++);
        --i;
        for(; i > index; i--) {
            int newStep = stones[i] - stones[index];
            if(newStep == step || newStep + 1 == step || newStep - 1 == step)
                if(backtracking(stones, matrix, i, newStep))
                    return true;
                else
                    matrix[i][newStep] = -1;
        }
        return false;
    }
    public boolean canCross(int[] stones) {
        if(stones[0] != 0 || stones[1] != 1) return false;
        int length = stones.length;
        int[][] matrix = new int[length][length];
        return backtracking(stones, matrix, 1, 1);
    }

}
