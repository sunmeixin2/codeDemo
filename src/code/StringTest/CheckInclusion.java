package code.StringTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sunmeixin
 * @description
 * @date 2021-02-10
 */
public class CheckInclusion {

    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        Map<Character, Integer> cnt1 = new HashMap<>();
        Map<Character, Integer> cnt2 = new HashMap<>();

        for (int i=0; i<s1.length(); i++) {
            char ch = s1.charAt(i);
            cnt1.put(ch, cnt1.containsKey(ch) ? cnt1.get(ch) + 1 : 1);
        }

        for (int i=0; i<s1.length() -1; i++) {
            char ch = s2.charAt(i);
            cnt2.put(ch,cnt2.containsKey(ch)? cnt2.get(ch)+1 : 1);
        }



        int left=0;
        int right = s1.length() -1;

        while (right < s2.length()) {
            cnt2.put(s2.charAt(right),cnt2.containsKey(s2.charAt(right))? cnt2.get(s2.charAt(right))+1 : 1);
            if (cnt1.equals(cnt2)) {
                return true;
            }
            char ch = s2.charAt(left);
            cnt2.put(ch,cnt2.get(ch)-1);
            if (cnt2.get(ch) == 0) {
                cnt2.remove(ch);
            }
            left++;
            right++;

        }

        return false;

    }

    public static boolean checkInclusion2(String s1, String s2) {
        Map<Character, Integer> cnt1 = new HashMap<>();
        Map<Character, Integer> cnt2 = new HashMap<>();

        for (int i=0; i<s1.length(); i++) {
            char ch = s1.charAt(i);
            cnt1.put(ch, cnt1.containsKey(ch) ? cnt1.get(ch) + 1 : 1);
            ch = s2.charAt(i);
            cnt2.put(ch,cnt2.containsKey(ch)? cnt2.get(ch)+1 : 1);
        }
        int left=0;
        int right = s1.length() -1;

        while (right < s2.length()) {

            if (cnt1.equals(cnt2)) {
                return true;
            }
            char ch = s2.charAt(left);
            cnt2.put(ch,cnt2.get(ch)-1);
            if (cnt2.get(ch) == 0) {
                cnt2.remove(ch);
            }
            left++;
            right++;
            if (right < s2.length()) {
                cnt2.put(s2.charAt(right), cnt2.containsKey(s2.charAt(right)) ? cnt2.get(s2.charAt(right)) + 1 : 1);
            }

        }

        return false;

    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("adc" ,"dcda"));
    }
}
