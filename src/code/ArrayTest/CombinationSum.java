package code.ArrayTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author sunmeixin
 * @description 组合总和
 * @date 2021-02-27
 */
public class CombinationSum {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum_solution(int[] candidates, int target) {
        dfs(target,new Stack<>(),candidates,0);
        return res;
    }

    public void dfs(int target, Stack<Integer> path, int[] candidates,int begin){
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i=begin; i<candidates.length; i++) {
            path.push(candidates[i]);
            dfs(target-candidates[i],path,candidates,i);
            path.pop();
        }
    }
}

/**
 * 题目描述：给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
            candidates 中的数字可以无限制重复被选取。（解集不能包含重复的组合。）

    思路分析：（回溯法 树形图 target-candidates[i]）
            根据示例 1：输入: candidates = [2, 3, 6, 7]，target = 7。

            候选数组里有 2，如果找到了组合总和为 7 - 2 = 5 的所有组合，再在之前加上 2 ，就是 7 的所有组合；
            同理考虑 3，如果找到了组合总和为 7 - 3 = 4 的所有组合，再在之前加上 3 ，就是 7 的所有组合，依次这样找下去。

        去除重复：每一次搜索的时候设置 下一轮搜索的起点begin
 */
