package code.ArrayTest;

/**
 * @author sunmeixin
 * @description 移动零
 * @date 2021-02-07
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int len = nums.length,p = 0, q = 0;
        while (p < len) {
            if (nums[p] != 0) {
                int temp = nums[p];
                nums[p] = nums[q];
                nums[q] = temp;
                q++;
            }
            p++;
        }
    }
}
