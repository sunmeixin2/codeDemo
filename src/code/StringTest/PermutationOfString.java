package code.StringTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author sunmeixin
 * @description 字符串的全排列
 * @date 2021-03-14
 */
public class PermutationOfString {

    List<String> res = new ArrayList<>();
    char[] c;
    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);

    }

    public void dfs (int x) {
        if (x == c.length -1) {
            res.add(String.valueOf(c));
            return;
        }

        HashSet<Character> set = new HashSet<>();
        for (int i = x; i < c.length; i++) {
            if (set.contains(c[i])) {
                continue;
            }
            swap(i,x);
            set.add(c[i]);
            dfs(x+1);
            swap(i,x);
        }
    }

    public void swap (int a, int b) {
        char temp = c[a];
        c[a] = c[b];
        c[b] = temp;
    }
}
