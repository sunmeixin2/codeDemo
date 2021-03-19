package code.StringTest;

/**
 * @author sunmeixin
 * @description 字符串中的每个空格替换为%20
 */
public class ReplaceBlankOfStr {

    public static String replaceSpace(String s) {
       return s.replaceAll(" ", "%20");
    }
    public static String replaceSpace2(String s) {
        char[] strArr = s.toCharArray();
        int count =0;
        for (char ch : strArr) {
            if (ch == ' ') {
                count++;
            }
        }
        int newLen = strArr.length + count * 2;
        char[] str = new char[newLen];
        int p = newLen -1;
        for (int i = strArr.length -1; i >= 0; i-- ) {
            while (i >=0 && strArr[i] != ' ' ) {
                str[p--] = strArr[i--];
            }
            if (p >= 0) {
                str[p--] = '0';
                str[p--] = '2';
                str[p--] = '%';
            }
        }


        return String.copyValueOf(str);
    }

    public static void main(String[] args) {
        replaceSpace2("We are happy.");
    }
}
