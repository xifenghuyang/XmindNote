package hwoj;

import java.util.*;

public class DuplicateLetter {


    public String RemoveDuplicateLetter(String input) {
        char[] charArray = input.toCharArray();

        // 26个字母，0-25：a-z 只包含小写字母
        int[] resultArray = new int[26];
        // 初始化,-1表示元素不存在
        Arrays.fill(resultArray,-1);
        // 更新规则：
        // 如果元素未出现过，用当前出现的值
        // 如果元素出现过，用大于前面元素的最小值
        for (int i = 0; i < charArray.length; i++) {
            char curChar = charArray[i];
            int indexOfResultArr = curChar - 'a';
            if (resultArray[indexOfResultArr] == -1) {
                // 数组默认值为0，所以从第1个位置开始
                resultArray[indexOfResultArr] = i;
            } else {
                int maxNum = getMaxNumBefore(resultArray, indexOfResultArr);
                if (resultArray[indexOfResultArr] < maxNum) {
                    resultArray[indexOfResultArr] = i;
                }
            }
        }
        // 桶排序,最多装26个字母
        char[] result = new char[26];
        for (int i = 0; i < 26; i++) {
            if (resultArray[i] != -1) {
                char thisChar = (char) ('a' + i);
                result[resultArray[i]] = thisChar;
            }
        }
        // 整理结果
        StringBuilder resultStr = new StringBuilder();
        for (char cap : result) {
            if (cap!= (char)0) {
                resultStr.append(cap);
            }
        }
        return resultStr.toString();
    }

    private int getMaxNumBefore(int[] resultArray, int endIndex) {
        int result = -1;
        for (int i = 0; i < endIndex; i++) {
            result = Math.max(result,resultArray[i]);
        }
        return result;
    }

    public static void main(String[] args) {

//        String test1 = "cdgttdgc";
        String test1 = "cdgtaaotdgc";
        DuplicateLetter du = new DuplicateLetter();
        String result = du.RemoveDuplicateLetter(test1);
        System.out.println(test1);
        System.out.println(result);
    }

}
