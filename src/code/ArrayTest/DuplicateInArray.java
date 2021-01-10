package code.ArrayTest;

/**
 * @author sunmeixin
 * @description 找出数组中重复数字
 */
public class DuplicateInArray {

    /**
     * 思路1
     * 长度为n的数组里的所有数字都在0~n-1范围内
     * 时间：O(n)
     * 空间：O(1)
     * @param nums
     * @param len
     * @return
     */
    int getDuplicate1(int[] nums,int len){

        if (nums == null || len < 1){
            return -1;
        }

        for (int i = 0; i < len ; i++) {
            while(nums[i] != i) {
                if (nums[nums[i]] == nums[i]) {
                    return nums[i];
                }

                //swap
                int temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
        }

        return -1;
    }

    // 不修改数组
    int getDuplicate2(int[] nums, int len){
        if (nums == null || len < 1){
            return -1;
        }

        int start = 1;
        int end = len -1;

        while (start <= end) {
            int mid = ((end - start) / 2) + start;
            int count = countRange(start,mid,nums,len);
            if (start == end) {
                if (count > 1){
                    return start;
                } else {
                    break;
                }
            }

            if (count > (mid - start + 1)) {
                end = mid;
            }else {
                start = mid + 1;
            }
        }
        return -1;
    }

    int countRange(int start, int end, int[] nums, int len) {

        int count = 0;
        for (int i = 0; i < len; i++){
            if (nums[i] <= end && nums[i] >= start){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        DuplicateInArray obj = new DuplicateInArray();
        /**
         * 长度为n的数组里的所有数字都在0~n-1范围内
         * 时间：O(n)
         * 空间：O(1)
         */
//        int[] nums = {2,3,0,2,5,3};
//        int  duplicate = obj.getDuplicate1(nums,nums.length);
//        System.out.println(duplicate);


        /**
         * 长度为n的数组里的所有数字都在0~n-1范围内
         * 时间：O(nlogn)
         * 空间： O(1)
         */
        int[] nums = {2,3,5,4,3,2,6,7};
        int  duplicate = obj.getDuplicate2(nums,nums.length);
        System.out.println(duplicate);


    }

}
/**
 * 题目描述：在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 *  数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中第一个重复的数字。
 *  例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 *
 *  思路1：如果数组中无任何重复的数字，则数组从小到大排序后理应满足第i个位置对应的元素值是i。
 *      利用此特性当前位置i如果 num[i] != i, 则nums[i] 与 nums[nums[i]]交换，直到nums[i] == i
 *
 *  思路2：不修改数组的前提
 *      emmmmm......忘记了？？？反正就是分组统计好像
 *
 */
