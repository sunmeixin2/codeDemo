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
//                left = map.get(s.charAt(i)) + 1;        // error
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            maxLen = Math.max(maxLen, i - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abcadcbb";
        WithoutRepeatLongextSubString obj = new WithoutRepeatLongextSubString();
        int result = obj.lengthOfLongestSubstring(s);
        System.out.println(result);
    }

}
