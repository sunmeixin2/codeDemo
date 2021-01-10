package code.ArrayTest;

import java.util.Arrays;

/**
 * @author sunmeixin
 * @description 数字在升序数组中出现的次数
 * @date 2020-12-12
 */
public class GetNumsOfKInArray {

    public int GetNumberOfK(int [] array , int k) {
        int index = Arrays.binarySearch(array,k);
        if (index < 0) {
            return 0;
        }
        int count = 1;
        int i = index-1;
        while (index >= 0 && array[i--] == k ) {
            count++;
        }
        i = index+1;
        while (index < array.length && array[i++] == k) {
            count++;
        }
        return count;
    }
}

/**
 * 统计一个数字在升序数组中出现的次数
 */


