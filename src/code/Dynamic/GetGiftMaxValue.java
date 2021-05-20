package code.Dynamic;

/**
 * @author sunmeixin
 * @description 礼物的最大价值
 * @date 2021-04-08
 */
public class GetGiftMaxValue {

    public int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i<m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0) {
                    grid[i][j] += grid[i][j-1];
                }else if (j == 0) {
                    grid[i][j] += grid[i-1][j];
                } else {
                    grid[i][j] += Math.max(grid[i][j-1],grid[i-1][j]);
                }
            }
        }
        return grid[m-1][n-1];
    }
}

/**
 * 题目描述：在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 *          你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 *          给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 *  题解：
 *      状态定义：设动态规划矩阵 dp ，dp(i,j)代表从棋盘的左上角开始，到达单元格 (i,j)时能拿到礼物的最大累计价值。
 *      转移方程：
 *          1.当 i = 0 && j = 0,为其实元素  dp(0,0)
 *          2.当 i = 0 && j != 0，为矩阵第一行元素，只可从左边到达  dp(i,j) = dp(i,j) + dp(i,j-1)
 *          3.当 i != 0 && j = 0，为矩阵第一列元素，只可从上边到达   dp(i,j) = dp(i,j) + dp(i-1,j)
 *          4.当 i != 0 && j != 0，可从左边或上边到达；  dp(i,j) = max[ dp(i,j-1) + dp(i-1,j)]
 *
 */
