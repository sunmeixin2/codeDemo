package code.Tree;

/**
 * @author sunmeixin
 * @description 不同的二叉搜索树
 * @date 2021-05-12
 */
public class DifferentSearchTreeCount {

    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i<n+1; i++) {
            for (int j = 1; j < i+1; j++) {
                dp[i] += dp[j-1] * dp[i-1];
            }
        }

        return dp[n];
    }

}

/**
 * 题目描述：给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 * 思路: 动态规划
 *          使用了一个公式 没看明白。。。。
 */
