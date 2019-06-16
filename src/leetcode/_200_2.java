package leetcode;

public class _200_2 {


    public static void main(String[] args) {
//        System.out.println(new _200_2().numIslands(new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}}));
//        System.out.println(new _200_2().numIslands(new char[][]{"11000".toCharArray(), "11000".toCharArray(), "00100".toCharArray(), "00011".toCharArray()}));
        System.out.println(new _200_2().numIslands(new char[][]{"10011101100000000000".toCharArray(),"10011001000101010010".toCharArray(),"00011110101100001010".toCharArray(),"00011001000111001001".toCharArray(),"00000001110000000000".toCharArray(),"10000101011000000101".toCharArray(),"00010001010101010101".toCharArray(),"00010100110101101110".toCharArray(),"00001001100001000101".toCharArray(),"00100100000100100010".toCharArray(),"10010000000100101010".toCharArray(),"01000101011011101100".toCharArray(),"11010000100000010001".toCharArray(),"01001110001111101000".toCharArray(),"00111000110001010000".toCharArray(),"10010100001000101011".toCharArray(),"10100000010001010000".toCharArray(),"01100011101010111100".toCharArray(),"01000011001010010011".toCharArray(),"00000011110100011000".toCharArray()}));

    }

    int[] row = new int[]{-1, 1, 0, 0};
    int[] col = new int[]{0, 0, -1, 1};
    void backtracking(int i, int j) {
        if(i < 0 || j < 0 || i == m || j == n || grid[i][j] == '0') return;
        visit[i][j] = count;
        grid[i][j] = '0';
        for(int k = 0; k < 4; k++)
            backtracking(i + row[k], j + col[k]);

    }
    char count = 0;
    int m, n;
    char[][] grid;
    int[][] visit;
    public int numIslands(char[][] grid) {
        m = grid.length;
        if(m == 0) return 0;
        n = grid[0].length;
        this.grid = grid;
        visit = new int[m][n];
        for(int i = 0; i < m; i ++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    ++count;
                    backtracking(i, j);
                }
            }
        }
        return count;
    }
}
