package leetcode;

public class _200 {


    public static void main(String[] args) {
        System.out.println(new _200().numIslands(new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}}));
        System.out.println(new _200().numIslands(new char[][]{"11000".toCharArray(), "11000".toCharArray(), "00100".toCharArray(), "00011".toCharArray()}));
    }

    void backtracking(int i, int j) {
        if(i < 0 || j < 0 || i == m || j == n || grid[i][j] != '1') return;
        grid[i][j] = count;
        backtracking(i-1, j);
        backtracking(i+1, j);
        backtracking(i, j-1);
        backtracking(i, j+1);

    }
    char count = 0;
    int m, n;
    char[][] grid;
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
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
