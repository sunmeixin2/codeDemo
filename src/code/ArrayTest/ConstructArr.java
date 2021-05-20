package code.ArrayTest;

/**
 * @author sunmeixin
 * @description 构建乘积数组
 * @date 2021-04-13
 */
public class ConstructArr {

    public int[] constructArr(int[] a) {
        if (a == null || a.length == 0) {
            return new int[0];
        }
        int[] b = new int[a.length];
        b[0] = 1;
        int temp = 1;
        // 计算 B[i] 的 下三角 各元素的乘积，直接乘入 B[i]；
        for (int i =1; i<a.length; i++) {
            b[i] = b[i-1] * a[i-1];
        }
        // 计算 B[i] 的 上三角 各元素的乘积，记为 tmp，并乘入 B[i]；
        for (int i = a.length-2; i>=0; i--) {
            temp *= a[i+1];
            b[i] *= temp;
        }
        return b;
    }

}
/**
 *  题目描述：
 *      给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积,
 *      即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 *
 * 思路：根据表格的主对角线（全为 11 ），可将表格分为 上三角 和 下三角 两部分。分别迭代计算下三角和上三角两部分的乘积，即可 不使用除法 就获得结果。
 */