package code.ArrayTest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sunmeixin
 * @description 数组中只出现一次的数字
 * @date 2020-12-13
 */
public class FindNumsAppearOnceINArray {

    /**
     * 思路1：使用HashMap
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce_solution(int [] array,int num1[] , int num2[]) {

        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0; i<array.length; i++) {
            if (map.containsKey(array[i])) {
                map.put(array[i],2);
            } else {
                map.put(array[i],1);
            }
        }

        int count = 0;
        for (int i=0; i<array.length; i++) {
            if (map.get(array[i]) == 1) {
                if (count == 0) {
                    num1[0] = array[i];
                    count++;
                } else {
                    num2[0] = array[i];
                }
            }
        }

    }

    /**
     * 思路2：使用异或，再根据异或结果将两个不相同的数组分组，然后重新异或
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce_solution2(int [] array,int num1[] , int num2[]) {
        int bitResult = 0;
        // 计算每个元素异或结果,最终bitResult为不相同元素的异或结果（相同的两个数异或为0）
        for (int i=0; i<array.length; i++) {
            bitResult ^=array[i];
        }
        int index = 0;

//        while(((bitResult & 1) == 0) && index < 32){   可替换掉下面的 index--
        // 找到最后一位为1的位数
        while (bitResult != 0 && index < 32) {
            bitResult = bitResult >> 1;
            index++;
        }
        index--; // 多加了一次

        for (int i=0; i<array.length; i++) {
            if (isBit1(array[i],index)) {
                num1[0] ^=array[i];
            } else {
                num2[0] ^=array[i];
            }
        }
    }

    public boolean isBit1(int target, int index) {
        return ((target >> index) & 1) == 1;
    }

    public static void main(String[] args) {
        FindNumsAppearOnceINArray obj = new FindNumsAppearOnceINArray();
        int[] array = {2,4,3,6,3,2,5,5};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        obj.FindNumsAppearOnce_solution(array,num1,num2);
    }
}

/**
 * 题目描述：一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * 思路1：HashMap
 * 思路2：异或（两数相同异或结果为0，不同异或结果为1），先数组中所有元素异或，得到的结果为不相同的两个数的异或结果ret（相同的异或都为0），
 *      再根据ret二进制中为1的位置i（因为1一定是由0,1异或而来，因此要求得两个数中，一定有一个数的二进制中的第i个位置为1， 一个为0），重新分组（这样两个不同的数会在不同的组中）并异或。
 */
