package code.ArrayTest;

import java.util.ArrayList;

/**
 * @author sunmeixin
 * @description 和为S的两个数字
 * @date 2020-12-13
 */
public class FindNumbersWithSum {

    public ArrayList<Integer> FindNumbersWithSum_solution(int [] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>(2);
        int p = 0, q = array.length-1;
        while (p < q) {
            if ((array[p] + array[q]) > sum) {
                q--;
            } else if ((array[p] + array[q]) < sum) {
                p++;
            } else {
                break;
            }
        }
        if(p < q) {
            result.add(array[p]);
            result.add(array[q]);
        }
        return result;
    }
}

/**
 * 题目描述：输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 思路：双指针
 */
