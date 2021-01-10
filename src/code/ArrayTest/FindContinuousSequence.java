package code.ArrayTest;

import java.util.ArrayList;


/**
 * @author sunmeixin
 * @description 和为S的连续正数序列
 * @date 2020-12-13
 */
public class FindContinuousSequence {

    public ArrayList<ArrayList<Integer> > FindContinuousSequence_solution(int sum) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        int r = 1;
        int temp = 0;

        for (int l = 1; l <= sum/2; l++ ) {
            // l 为左边界   r为右边界

            // while循环找右边界
            while (temp < sum) {
                temp += r;
                r++;
            }
            if (temp == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = l; i <= r; i++) {
                    list.add(i);
                }
                result.add(list);
            }
            // temp == sum  和 temp > sum  都需要减掉l
            temp -= l;
        }
        return result;
    }

    public static void main(String[] args) {
        FindContinuousSequence findContinuousSequence = new FindContinuousSequence();
        findContinuousSequence.FindContinuousSequence_solution(9);
    }
}



/**
 * 题目描述：输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 * 思路：滑动窗口，左边界和右边界
 */
