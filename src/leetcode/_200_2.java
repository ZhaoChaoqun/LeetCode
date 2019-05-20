package leetcode;

public class _200_2 {


    public static void main(String[] args) {
        System.out.println(new _200_2().numIslands(new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}}));
        System.out.println(new _200_2().numIslands(new char[][]{"11000".toCharArray(), "11000".toCharArray(), "00100".toCharArray(), "00011".toCharArray()}));
    }

    void backtracking(int i, int j) {
        if(i < 0 || j < 0 || i == m || j == n || grid[i][j] == '0') return;
        visit[i][j] = count;
        grid[i][j] = '0';
        backtracking(i-1, j);
        backtracking(i+1, j);
        backtracking(i, j-1);
        backtracking(i, j+1);

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
