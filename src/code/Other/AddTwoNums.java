package code.Other;

/**
 * @author sunmeixin
 * @description
 * @date 2020-11-29
 */
public class AddTwoNums {

    public static int add(int num1, int num2){

        int result = 0;
        int carry = 0;

        do {
            result = num1^num2;
            carry = (num1 & num2) << 1;
            num1 = result;
            num2 = carry;
        } while (carry != 0);

        return result;

    }

    public static void main(String[] args) {
        add(5,3);
    }
}

/**
 * 题目描述：写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号
 * 讨论：num1 + num2 = 无进位 + 进位左移一位 = 异或 + 与
 */
