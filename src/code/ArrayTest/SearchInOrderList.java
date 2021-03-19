package code.ArrayTest;

/**
 * @author sunmeixin
 * @description 在排序数组中查找数字
 * @date 2021-03-10
 */
public class SearchInOrderList {

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0, j = nums.length-1;
        // 查找右边界
        while (i <= j) {
            int mid = (i+j)/2;
            if (nums[mid] <= target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        int right = i;
        i = 0;
        j = nums.length-1;
        // 查找右边界
        while (i <= j) {
            int mid = (i+j)/2;
            if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        int left = j;

        return right - left - 1;

    }
    public int search2(int[] nums, int target) {
        // 由于数组 nums 中元素都为整数，因此可以分别二分查找 target 和 target - 1的右边界，将两结果相减并返回即可
        return helper(nums, target) - helper(nums,target-1);
    }
    public int helper(int[] nums, int target) {
        int i = 0, j = nums.length-1;
        // 查找右边界
        while (i <= j) {
            int mid = (i+j)/2;
            if (nums[mid] <= target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return i;
    }
}
