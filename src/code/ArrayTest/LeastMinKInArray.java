package code.ArrayTest;

import java.util.Arrays;

/**
 * @author sunmeixin
 * @description 最小的K个数
 * @date 2021-03-18
 */
public class LeastMinKInArray {


    /**
     * 方法2：堆
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers2(int[] arr, int k) {

        return null;
    }


    /**
     * 方法1：快排变形
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length == 0 || k <= 0) {
            return new int[0];
        } else if (arr.length <= k) {
            return arr;
        }

        partionArray(arr,0,arr.length-1,k);
        int[] res = new int[k];
        for (int i = 0; i < k ; i++) {
            res[i] = arr[i];
        }

        return res;

    }

    public void partionArray(int[] arr, int left, int right, int k) {
        int m = partion(arr,left,right);
        if ( m == k) {
            return;
        } else if ( k < m) {
            partionArray(arr, left,m-1,k);
        } else {
            partionArray(arr,m+1,right,k);
        }

    }

    public int partion(int[] arr, int left, int right) {
        int i = left;
        int j = right;
        int key = arr[i];

        while (i < j) {
            while (i < j && arr[j] >= key) {
                j--;
            }
            if (i < j) {
                arr[i] = arr[j];
            }
            while (i < j && arr[i] <= key) {
                i++;
            }
            if (i < j) {
                arr[j] = arr[i];
            }
        }
        arr[i] = key;
        return i;
    }

    public static void main(String[] args) {
        LeastMinKInArray obj = new LeastMinKInArray();
        int[] arr = {3,2,1};
        obj.getLeastNumbers(arr,2);
    }
}

/**
 * 题目描述：输入整数数组 arr ，找出其中最小的 k 个数。
 *          例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 *   方法1：快速选择（快排变形）
 *   方法2：大根堆(前 K 小) / 小根堆（前 K 大),Java中有现成的 PriorityQueue，实现起来最简单：
 */
