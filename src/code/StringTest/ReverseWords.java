package code.StringTest;

/**
 * @author sunmeixin
 * @description 翻转单词顺序
 * @date 2021-03-22
 */
public class ReverseWords {

    /**
     * 分隔 + 倒序
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        String[] strs = s.trim().split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = strs.length -1; i >= 0; i--) {
            if (strs[i].equals("")) {
                continue;
            }
            res.append(strs[i]).append(" ");
        }
        return res.toString().trim();

    }

    /**
     * 双指针
     * @param s
     * @return
     */
    public String reverseWords2(String s) {
        s = s.trim();
        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while(i >= 0) {
            // 搜索首个空格
            while(i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            // 添加单词
            res.append(s.substring(i + 1, j + 1) + " ");
            // 跳过单词间空格
            while(i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            // j 指向下个单词的尾字符
            j = i;
        }
        return res.toString().trim();
    }
}

/**
 * 题目描述：输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。
 *          例如输入字符串"I am a student. "，则输出"student. a am I"。
 *
 *
 * 题解：
 *  方法1：双指针
 *      倒序遍历字符串 ss ，记录单词左右索引边界 ii , jj ；
 *      每确定一个单词的边界，则将其添加至单词列表 resres ；
 *      最终，将单词列表拼接为字符串，并返回即可。
 *
 *  方法2：分隔 + 倒序（倒序遍历分隔后的列表）
 *
 */
