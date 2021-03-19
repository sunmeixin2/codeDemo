package code.StringTest;

/**
 * @author sunmeixin
 * @description 左旋转字符串
 * @date 2021-03-12
 */
public class ReverseLeftWords {

    public String reverseLeftWords1(String s, int n) {
        return s.substring(n,s.length()) + s.substring(0,n);
    }

    public String reverseLeftWords2(String s, int n) {
        StringBuilder res = new StringBuilder("");
        for (int i = n; i < s.length(); i++) {
            res.append(s.charAt(i));
        }

        for (int i = 0; i < n; i++) {
            res.append(s.charAt(i));
        }
        return res.toString();
    }

}

/**
 * 题目描述：字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 *      请定义一个函数实现字符串左旋转操作的功能。
 *      比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"
 *
 * 思路分析：1)   substring()
 *          2)  先遍历 n~len   再遍历0~n
 *
 */
