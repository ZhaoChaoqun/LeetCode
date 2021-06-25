package leetcode;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author 赵超群
 * @Date: 2021/6/19 10:33 上午
 */
public class _361_2 {
    public static void main(String[] args) {
        _361_2 test = new _361_2();
        System.out.println(test.maxKilledEnemies(new char[][] {{'0','E','0','0'},{'E','0','W','E'},{'0','E','0','0'}}));
    }

    public int maxKilledEnemies(char[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[][] left2right = new int[rows][cols+1];
        int[][] right2left = new int[rows][cols+1];
        int[][] up2down = new int[rows+1][cols];
        int[][] down2up = new int[rows+1][cols];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (grid[i][j] == 'E') {
                    left2right[i][j+1] = left2right[i][j] + 1;
                } else if (grid[i][j] == '0') {
                    left2right[i][j+1] = left2right[i][j];
                }
            }
            for (int j = cols; j > 0; --j) {
                if (grid[i][j-1] == 'E') {
                    right2left[i][j-1] = right2left[i][j] + 1;
                } else if (grid[i][j-1] == '0') {
                    right2left[i][j-1] = right2left[i][j];
                }
            }
        }

        for (int j = 0; j < cols; ++j) {
            for (int i = 0; i < rows; ++i) {
                if (grid[i][j] == 'E') {
                    up2down[i+1][j] = up2down[i][j] + 1;
                } else if (grid[i][j] == '0') {
                    up2down[i+1][j] = up2down[i][j];
                }
            }
            for (int i = rows; i > 0; --i) {
                if (grid[i-1][j] == 'E') {
                    down2up[i-1][j] = down2up[i][j] + 1;
                } else if (grid[i-1][j] == '0') {
                    down2up[i-1][j] = down2up[i][j];
                }
            }
        }
        int max = 0;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (grid[i][j] == '0') {
                    max = Math.max(max, left2right[i][j+1] + right2left[i][j] + up2down[i+1][j] + down2up[i][j]);
                }
            }
        }
        return max;
    }
}
