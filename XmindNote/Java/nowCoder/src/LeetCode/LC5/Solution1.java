//Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
//
// Example 1:
//
//
//Input: "babad"
//Output: "bab"
//Note: "aba" is also a valid answer.
//
//
// Example 2:
//
//
//Input: "cbbd"
//Output: "bb"
//
// Related Topics String Dynamic Programming
// 子串：不包含本身

//leetcode submit region begin(Prohibit modification and deletion)
//解法 2: 最长公共子串
//        根据回文串的定义，正着和反着读一样，那我们是不是把原来的字符串倒置了，
//        然后找最长的公共子串就可以了。例如 S = "caba" ，S = "abac"，
//        最长公共子串是 "aba"，所以原字符串的最长回文串就是 "aba"。
//动态规划的方法，
class Solution1 {
    public String longestPalindrome(String s) {
        int len=s.length();
        int maxLen = 0;
        String result = "";
        for(int i=len-1; i>=0; i--){
            for(int j=i; j>=0; j--){
                String subStr = s.substring(j,i+1);
                if(isPalindromic(subStr) && subStr.length()>maxLen){
                    maxLen = subStr.length();
                    result = subStr;
                }
            }
        }
        return result;
    }

    // 判断是否为回文
    public boolean isPalindromic(String s){
        int len = s.length();
        for(int i=0; i<len/2; i++){
            if(s.charAt(i)!=s.charAt(len-1-i)){
                return false;
            }
        }
        return true;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
