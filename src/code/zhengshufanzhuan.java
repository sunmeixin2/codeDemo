package code;

import org.omg.CORBA.INTERNAL;

import java.io.UnsupportedEncodingException;

/**
 * @author sunmeixin
 * @description 整数反转
 * @date 2020-02-16 22:34
 */
public class zhengshufanzhuan {

    public int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            int pop = x % 10;
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }

            ans = ans * 10 + pop;
            x = x / 10;
        }

        return ans;
    }

    public static void f1 (String str) {
        str = "345";
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
//        zhengshufanzhuan obj = new zhengshufanzhuan();
//        int result = obj.reverse(1534236469);
//        System.out.println(result);
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);


    }

}
