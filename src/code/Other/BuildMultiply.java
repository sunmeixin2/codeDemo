package code.Other;

/**
 * @author sunmeixin
 * @description
 * @date 2020-11-29
 */
public class BuildMultiply {

    public int[] multiply(int[] A) {

        // 边界
        if (A == null || A.length <= 1) {
            return null;
        }
        int[] B = new int[A.length];
        // 计算下三角
        // 初始化第一行
        B[0] = 1;
        for (int i=1; i< A.length; i++) {
            B[i] = B[i-1] * A[i-1];
        }

        // 计算上三角
        // 初始化最后一行
        int temp = 1;
        for (int i= A.length-1; i >=0 ; i++) {
            B[i] = B[i]*temp;
            temp *= A[i];
        }

        return B;
    }
}
