package code.ArrayTest;

/**
 * @author sunmeixin
 * @description 圆圈中最后剩下的数字
 * @date 2021-01-29
 */
public class LastRemaining {

    public int lastRemaining(int n, int m){

        int index = 0;

        for (int i = 2; i <= n; i++) {
            index = (index + m) % i;
        }
        return index;
    }


}

/**
 * 题目描述：0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
 *  思路分析： 假设需要最后存活的元素是X,这个元素最终的的下标一定是0 （因为最后只剩这一个元素）。
 *              所以如果我们可以推出上一轮次中这个X的下标index，然后根据上一轮X的下标推断出上上一轮X的下标，
 *              直到推断出元素个数为n的那一轮X的下标，那我们就可以根据这个下标获取到最终的元素了
 *
 */
