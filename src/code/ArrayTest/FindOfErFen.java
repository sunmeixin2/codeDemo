package code.ArrayTest;

/**
 * @author sunmeixin
 * @description
 * 二分查找
 */
public class FindOfErFen {

    public static void main(String[] args) {
        FindOfErFen obj = new FindOfErFen();
        int[] data = {1,1,2,7,7,9,9,10};
        int result = obj.solution(9,2,data);
        System.out.println(result);
    }

    public int solution(int len,int val,int[] data ){
        int left = 0;
        int right = len - 1;
        int mid = (right + left)/2;
         while (left < right) {
             if (data[mid] >= val) {
                 if (mid == 0 ||data[mid-1] < val){
                     return mid + 1;
                 }
                 right = mid;
             } else {
                 left = mid +1;
             }
         }
        return len +1;
    }
}
