package code.ArrayTest;

/**
 * @author sunmeixin
 * @description  二维数组中的查找
 */
public class FindTheValueInErArray {

    static Boolean find(int[][] data,int rows,int cols,int val){
        if (data == null || rows < 1 || cols < 1 ){
            return false;
        }
        int i = 0;
        int j = cols-1;

        while (i < rows && j >= 0) {
            if (data[i][j]  == val) {
                return true;
            } else if (data[i][j] > val) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int[][] data = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(data.length);
        System.out.println(find(data,4,4,13));
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null ||  matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int i = 0;
        int j = columns - 1;
        while (i < rows && j >= 0) {
            if (matrix[i][j] > target) {
                j--;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }
}

/**
 * 题目描述：二位数组,从左到右递增，从上到下递增，输入一个整数，判断数组中是否含有改整数
 *
 * 思路分析：从右上角/左下角开始判断
 *      选左上角，往右走和往下走都增大，不能选
 *
 *      选右下角，往上走和往左走都减小，不能选
 *
 *      选左下角，往右走增大，往上走减小，可选
 *
 *      选右上角，往下走增大，往左走减小，可选
 *
 */
