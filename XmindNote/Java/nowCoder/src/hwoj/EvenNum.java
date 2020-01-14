package hwoj;

public class EvenNum {

    /**
     * 暴力破解
     * 随着 m 的增大，运算耗时指数性增加
     *
     * @param n
     * @param m
     * @return
     */
    public static int solution(int n, int m) {
        int result = 0;
        for (int i = n; i <= m; i++) {
            if (String.valueOf(i).length() % 2 == 0) {
                result++;
            }
        }
        return result;
    }

    /**
     * 分段法
     * 因为数据可分段，因此按照分段叠加的思想。(前缀和，从而统一 n,m的地位)
     */
    private static int[] evenList = new int[10];
    public static int solution2(int n, int m) {
        for(int i=0; i<10; i++){
            if(i%2==0){
                evenList[i]=0;
            }else {
                evenList[i] = 9*tenPow(i);
            }
        }
        int evenBelowN = evenNumBelow(n);
        int evenBelowM = evenNumBelow(m);
        int result = 0;
        if(String.valueOf(n).length()%2==0){
            result = 1;
        }
        result += evenBelowM - evenBelowN;
        return result;

    }

    private static int evenNumBelow(int num) {
        int result = 0;
        int length = String.valueOf(num).length();
        if (length % 2 == 0) {
            int theLowNum = tenPow(length-1);
            result = num - theLowNum +1;
        }
        for(int i=0; i<length-1; i++){
            result +=evenList[i];
        }
        return result;
    }

    private static int tenPow(int length) {
        int result = 1;
        for (int i = 0; i < length; i++) {
            result *= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 11;
        int m = 99999999;
        int res = solution2(n, m);
        System.out.print(res);
    }

}
