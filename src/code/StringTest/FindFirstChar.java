package code.StringTest;

import java.util.LinkedHashMap;

/**
 * @author sunmeixin
 * @description 第一个只出现一次的字符
 * @date 2021-03-18
 */
public class FindFirstChar {

    public char firstUniqChar(String s) {
        char[] chars = s.toCharArray();

        LinkedHashMap<Character,Boolean> res = new LinkedHashMap<>(chars.length);
        for (char ch : chars) {
            res.put(ch, !res.containsKey(ch));
        }

        for (char ch : res.keySet()) {
            if (res.get(ch)) {
                return ch;
            }
        }
        return ' ';

    }
}

/**
 * 题目描述：在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 *  题解：有序哈希
 */
