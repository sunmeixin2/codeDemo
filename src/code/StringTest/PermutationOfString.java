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
        // 从第一层开始递归
        dfs(0);
        //将字符串数组ArrayList转化为String类型数组
        return res.toArray(new String[res.size()]);

    }

    public void dfs (int x) {
        // 当递归到达第三层时，就返回，此时第二第三个位置都已发生变化
        if (x == c.length -1) {
            // 将字符数组转换为字符串
            res.add(String.valueOf(c));
            return;
        }
        // 为了防止同一层递归出现重复元素
        HashSet<Character> set = new HashSet<>();
        //这里就很巧妙了,第一层可以是a,b,c那么就有三种情况，这里i = x,正巧dfs(0)，正好i = 0开始
        // 当第二层只有两种情况，dfs(1）i = 1开始
        for (int i = x; i < c.length; i++) {
            // 发生剪枝，当包含这个元素的时候，直接跳过
            if (set.contains(c[i])) {
                continue;
            }

            set.add(c[i]);
            //交换元素，这里很是巧妙，当在第二层dfs(1),x = 1,那么i = 1或者 2， 不是交换1和1，要就是交换1和2
            swap(i,x);
            //进入下一层递归
            dfs(x+1);
            //返回时交换回来，这样保证到达第1层的时候，一直都是abc。这里捋顺一下，开始一直都是abc，那么第一位置总共就3个交换
            //分别是a与a交换，这个就相当于 x = 0, i = 0;
            //     a与b交换            x = 0, i = 1;
            //     a与c交换            x = 0, i = 2;
            //就相当于上图中开始的三条路径
            //第一个元素固定后，每个引出两条路径,
            //     b与b交换            x = 1, i = 1;
            //     b与c交换            x = 1, i = 2;
            //所以，结合上图，在每条路径上标注上i的值，就会非常容易好理解了
            swap(x,i);
        }
    }

    public void swap (int a, int b) {
        char temp = c[a];
        c[a] = c[b];
        c[b] = temp;
    }

    public static void main(String[] args) {
        String str = "     -42";
        str = str.trim();
        System.out.println(Integer.valueOf(str).intValue());
    }
}

/**
 * 题目描述：输入一个字符串，打印出该字符串中字符的所有排列。
 *          你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 *          输入：s = "abc"
 *          输出：["abc","acb","bac","bca","cab","cba"]
 *
 *
 *  题解： 回朔法
 *
 *      1.终止条件： 当 x = len(c) - 1 时，代表所有位已固定（最后一位只有 1 种情况），则将当前组合 c 转化为字符串并加入 res ，并返回；
 *      2.递推参数： 当前固定位 x ；
 *     3. 递推工作： 初始化一个 Set ，用于排除重复的字符；将第 x 位字符与 i \in∈ [x, len(c)] 字符分别交换，并进入下层递归；
 *          剪枝： 若 c[i] 在 Set​ 中，代表其是重复字符，因此 “剪枝” ；
 *          将 c[i] 加入 Set​ ，以便之后遇到重复字符时剪枝；
 *          固定字符： 将字符 c[i] 和 c[x] 交换，即固定 c[i] 为当前位字符；
 *          开启下层递归： 调用 dfs(x + 1) ，即开始固定第 x + 1 个字符；
 *          还原交换： 将字符 c[i] 和 c[x] 交换（还原之前的交换）；
 */
