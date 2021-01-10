package code.Other;

/**
 * @author sunmeixin
 * @description 数值的整数次方
 * @date 2020-12-06
 */
public class MathPowDemo {

    public double power(double base, int exponent) {
        if (base == 0) {
            return 0;
        }
        if (exponent < 0) {
            base = 1/base;
        }

        int e = exponent > 0 ? exponent : -exponent;

        double result = 1.0d;

        while (e != 0) {
            result *= base;
            e--;
        }
        return result;
    }

}

/**
 * 题目描述：数值的整数次方：给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。保证base和exponent不同时为0
 *
 */
