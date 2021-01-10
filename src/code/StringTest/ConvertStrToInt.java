package code.StringTest;

import com.sun.deploy.util.StringUtils;

/**
 * @author sunmeixin
 * @description 字符串转换为整数
 * @date 2020-02-18 18:22
 */
public class ConvertStrToInt {

    public int myAtoi(String str) {
        if (str != null) {
            str = str.trim();
        } else {
            return 0;
        }

        int len = str.length();
        char[] strArr = new char[len];
        strArr = str.toCharArray();

        int i = 0;
        if (len > 0) {
//            for (char c : strArr) {
////                if (c == '-' || c)
//            }
        } else {
            return 0;
        }

        return 0;

    }

}
