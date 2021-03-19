package code.Other;

/**
 * @author sunmeixin
 * @description 青蛙跳台阶
 * @date 2020-12-05
 */
public class JumpFloorDemo {




    /**
     * 自己向上循环求解，时间复杂度O(n)
     * @param target
     * @return
     */
    public static int jumpFloor2(int target) {
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i<= target; i++) {
            int cur = second;
            second = first + second;
            first = cur;
        }
        return second;
    }


    /**
     * 递推版，时间复杂度O(n^2)
     * @param target
     * @return
     */
    public static int jumpFloor(int target) {
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        return jumpFloor(target-1) + jumpFloor(target-2);
    }

    public static void main(String[] args) {
        System.out.println(jumpFloor2(3));
    }
}

/**
 * 题目描述：一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * 相似类型题：
 *      矩阵覆盖：我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *      比如n=3时，2*3的矩形块有3种覆盖方法
 */
