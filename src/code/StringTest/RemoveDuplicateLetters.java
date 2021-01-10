package code.StringTest;

import java.util.LinkedList;

/**
 * @author sunmeixin
 * @description 去除重复数字
 * @date 2020-12-20
 */
public class RemoveDuplicateLetters {

    public String removeDuplicateLetters_solution(String s) {
        LinkedList<Character> deque = new LinkedList<>();
        int[] count = new int[26];

        boolean[] exists = new boolean[26];
        // 初始化
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        // 遍历s并入栈
        for (int i=0; i< s.length(); i++) {
            char ch = s.charAt(i);
            // 该位置字母没有在栈中出现过
            if (!exists[ch - 'a']) {
                // 栈不为空 && 栈顶元素字典序列靠后 && 栈顶元素还有剩余出现次数
                while (!deque.isEmpty() && deque.getLast() > ch && count[deque.getLast() - 'a'] > 0 ) {
                    exists[deque.getLast() - 'a'] = false;
                    deque.removeLast();
                }
                // 该位置的字母压栈
                // 修改出现状态
                deque.add(ch);
                exists[ch - 'a'] = true;
            }
            // // 遍历过的字母出现次数减一
            count[ch - 'a']--;
        }
        StringBuilder result = new StringBuilder();
        for (char ch : deque) {
            result.append(ch);
        }
        return result.toString();
    }

}
