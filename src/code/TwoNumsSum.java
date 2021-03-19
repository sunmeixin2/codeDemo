package code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author sunmeixin
 * @description 两数之和
 */
public class TwoNumsSum {

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.get(diff) != null) {
                res[0] = map.get(diff);
                res[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return res;
    }

    public static void main(String[] args) {
        TwoNumsSum twoNumsSum = new TwoNumsSum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoNumsSum.twoSum(nums, target);
        System.out.println(result[1]);
    }
}
