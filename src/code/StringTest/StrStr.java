package code.StringTest;

/**
 * @author sunmeixin
 * @description 实现Strstr()  即匹配字符串
 * @date 2021-04-20
 */
public class StrStr {

    public  static int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }


        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j = 0;
            while (j < needle.length() && haystack.charAt(i+j) == needle.charAt(j)){
                j++;
            }
            if (j == needle.length()) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        strStr("aaa","aaaa");
    }
}

/**
 * 题目描述：实现 strStr() 函数。
 *
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1
 *
 */
