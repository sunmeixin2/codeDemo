package code.StringTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunmeixin
 * @description Z 字形变换
 * @date 2020-02-17 15:29
 */
public class Ztransformation {

    public String convert(String s, int numRows) {

        if (numRows < 2)
            return s;

        List<StringBuilder> rows = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        int i = 0, flag = -1;
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            if (i == 0 || i == numRows - 1)
                flag = -flag;
            i += flag;
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder c : rows) {
            res.append(c);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Ztransformation obj = new Ztransformation();
        String str = "LEETCODE";
        int numRows = 3;
        String result = obj.convert(str, numRows);
        System.out.println(result);
    }
}
