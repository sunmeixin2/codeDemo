package code.ArrayTest;

import java.util.TreeSet;

/**
 * @author sunmeixin
 * @description 扑克牌顺子
 * @date 2020-12-20
 */
public class isContinuous {

    public boolean isContinuous_solution(int [] numbers) {

        if (numbers.length < 5) {
            return false;
        }

        int zero_count = 0;
        TreeSet<Integer> setNums = new TreeSet<>();
        for (int i= 0; i < numbers.length; i++) {
            if (numbers[i] ==0) {
                zero_count++;
                continue;
            }
            setNums.add(numbers[i]);
        }
        if ((setNums.size() + zero_count) < 5) {
            return false;
        }
        if ((setNums.last() - setNums.first()) < 5){
            return true;
        }
        return false;
    }
}

/**
 * 题目描述：LL买了一副扑克，抽了5张“红心A,黑桃3,小王,大王,方片5”,决定大\小王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
 *  上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4), 如果牌能组成顺子就输出true，否则就输出false。
 *  为了方便起见,你可以认为大小王是0。
 *
 *  思路：就是要是5个数字，最大和最小差值在5以内，并且没有重复数值，则是顺子。
 *      用一个set来填充数据，0不要放进去。set的大小加上0的个数必须为5个。此外set中数值差值在5以内。
 */
