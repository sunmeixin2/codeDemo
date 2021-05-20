package code.StringTest;

import java.util.HashMap;

/**
 * @author sunmeixin
 * @description 无重复字符的最长子串
 * @date 2020-02-06 22:25
 */
public class WithoutRepeatLongextSubString {

    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int left = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
//                left = map.get(s.charAt(i)) + 1;        // error   eg：abba
                //  更新左指针 i
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            maxLen = Math.max(maxLen, i - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abba";
        WithoutRepeatLongextSubString obj = new WithoutRepeatLongextSubString();
        int result = obj.lengthOfLongestSubstring(s);
        System.out.println(result);
    }

}

/**
 * 题目描述：请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 *
 * 思路：双指针 + hash表
 *
 */
