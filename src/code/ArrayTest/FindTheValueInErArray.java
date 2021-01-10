package code.ArrayTest;

/**
 * @author sunmeixin
 * @description 二位数组,从左到右递增，从上到下递增，输入一个整数，判断数组中是否含有改整数
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
        System.out.println(find(data,4,4,13));
    }
}
