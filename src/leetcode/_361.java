package leetcode;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author 赵超群
 * @Date: 2021/6/19 10:33 上午
 */
public class _361 {
    public static void main(String[] args) {
        _361 test = new _361();
        System.out.println(test.maxKilledEnemies(new char[][] {{'0','E','0','0'},{'E','0','W','E'},{'0','E','0','0'}}));
    }

    public int maxKilledEnemies(char[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[][] left2right = new int[rows][cols];
        int[][] right2left = new int[rows][cols];
        int[][] up2down = new int[rows][cols];
        int[][] down2up = new int[rows][cols];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (grid[i][j] == 'E') {
                    left2right[i][j] = j == 0 ? 1 : left2right[i][j-1] + 1;
                } else if (grid[i][j] == '0') {
                    left2right[i][j] = j == 0 ? 0: left2right[i][j-1];
                }
            }
            for (int j = cols - 1; j >= 0; --j) {
                if (grid[i][j] == 'E') {
                    right2left[i][j] = j == cols - 1 ? 1 : right2left[i][j+1] + 1;
                } else if (grid[i][j] == '0') {
                    right2left[i][j] = j == cols - 1 ? 0: right2left[i][j+1];
                }
            }
        }

        for (int j = 0; j < cols; ++j) {
            for (int i = 0; i < rows; ++i) {
                if (grid[i][j] == 'E') {
                    up2down[i][j] = i == 0 ? 1 : up2down[i-1][j] + 1;
                } else if (grid[i][j] == '0') {
                    up2down[i][j] = i == 0 ? 0: up2down[i-1][j];
                }
            }
            for (int i = rows - 1; i >= 0; --i) {
                if (grid[i][j] == 'E') {
                    down2up[i][j] = i == rows - 1 ? 1 : down2up[i+1][j] + 1;
                } else if (grid[i][j] == '0') {
                    down2up[i][j] = i == rows - 1 ? 0: down2up[i+1][j];
                }
            }
        }
        int max = 0;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (grid[i][j] == '0') {
                    max = Math.max(max, left2right[i][j] + right2left[i][j] + up2down[i][j] + down2up[i][j]);
                }
            }
        }
        return max;
    }
}
