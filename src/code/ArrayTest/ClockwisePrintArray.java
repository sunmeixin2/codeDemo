package code.ArrayTest;

/**
 * @author sunmeixin
 * @description 顺时针打印数组
 * @date 2021-03-30
 */
public class ClockwisePrintArray {

    public int[] spiralOrder(int[][] matrix) {

        if (matrix.length == 0) {
            return new int[0];
        }
        // 左边界
        int l = 0;
        // 右边界
        int r = matrix[0].length - 1;
        // 上边界
        int t = 0;
        // 下边界
        int b = matrix.length - 1;
        int[] res = new int[matrix[0].length * matrix.length];
        int x =0;
        while (true) {
            // 从左往右
            for (int i = l; i <= r; i++) {
                res[x++] = matrix[t][i];
            }
            if (++t > b) break;

            // 从上往下
            for (int i = t; i <= b; i++) {
                res[x++] = matrix[i][r];
            }
            if (l > --r) break;

            // 从右往左
            for (int i = r; i >= l; i--) {
                res[x++] = matrix[b][i];
            }
            if (t > --b) break;

            // 从下往上
            for (int i = b; i >= t; i--) {
                res[x++] = matrix[i][l];
            }
            if (++l > r) break;
        }
        return res;
    }

}
/**
 * 题目描述：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *          输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 *           输出：[1,2,3,6,9,8,7,4,5]
 */
