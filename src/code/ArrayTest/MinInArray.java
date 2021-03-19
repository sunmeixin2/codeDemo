package code.ArrayTest;

/**
 * @author sunmeixin
 * @description 旋转数组的最小数字
 * @date 2021-03-17
 */
public class MinInArray {

    public int minArray(int[] numbers) {
        int right = numbers.length -1;

        int left = 0;

        while (left < right) {
            int mid = (right + left) / 2;
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]){
                right = mid;
            } else {
                int x = left;
                for (int k = left; k < right; k++) {
                    if (numbers[k] < numbers[x]) {
                        x = k;
                    }
                }
                return numbers[x];
            }
        }
        return numbers[left];
    }
}

/**
 * 题目描述：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 *          输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 *          例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 *
 *   注意：num[mid] > num[left] 无法判断出最小值在哪个区间：ed  [1,3,5]
 */
