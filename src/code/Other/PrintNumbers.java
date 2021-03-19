package code.Other;

/**
 * @author sunmeixin
 * @description
 * @date 2021-03-15
 */
public class PrintNumbers {

    public int[] printNumbers(int n) {
        int size = (int) Math.pow(10,n);
        int[] nums = new int[size];
        for (int i = 0; i < size-1; i++) {
            nums[i] = i+1;
        }
        return nums;
    }

    int[] res;
    char[] nums;
    char[] loop = {'0','1','2','3','4','5','6','7','8','9'};
    // 数组计数索引
    int count = 0;
    // 递归到第几层
    int x = 0;
    public int[] printNumbers2(int n) {
        nums = new char[n];
        res = new int[(int)Math.pow(10,n)-1];
        dfs(x,n);
        return res;
    }

    public void dfs(int x, int n){
        //递归终止条件，x==n,此时要往结果数组res中添加数字
        if (x == n) {
            // 把字符数组转换为字符串
            String str = String.valueOf(nums);
            // 把字符串转换为整数
            int temp = Integer.valueOf(str);
            // 跳过0
            if (temp != 0) {
                res[count++] = temp;
                return;
            }
            return;
        }

        // 对第X层的数组进行固定，然后继续向下一层递归
        for (char ch : loop) {
            nums[x] = ch;
            dfs(x+1,n);
        }

    }
}
