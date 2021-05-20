package code.Other;

/**
 * @author sunmeixin
 * @description 求1+2+…+n
 * @date 2021-04-02
 */
public class SumNums {

    public  int sumNums(int n) {
        boolean x =n > 1 && ( n += sumNums(n-1)) > 0;
        return n;
    }
    int a = 0;
    boolean flag = false;

    public  void wiret() {
        a = 1;
        flag = true;
        if (flag) {
            int i = a;
            System.out.println(i);
        }
    }
    public  void read() {

//        System.out.println(i);



    }

    public static void main(String[] args) {
        SumNums sumNums = new SumNums();
        sumNums.wiret();
//        sumNums.read();
    }

}
/**
 * 题目描述：求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
