//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3867 👎 0


package com.vic.leetcode.editor.cn;

public class No5_LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new No5_LongestPalindromicSubstring().new Solution();
        System.out.println(solution.longestPalindrome("axcxa"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            int length = s.length();
            if (length < 2) return s;

            int max = 0;
            int start = 0;

            boolean[][] dp = new boolean[length][length];

            for (int l = 0; l < length; l++) {
                for (int r = 0; r < length; r++) {
                    if (s.charAt(l) != s.charAt(r)) {
                        dp[l][r] = false;
                    } else {
                        if (r - l < 3) {
                            dp[l][r] = true;
                        } else {
                            dp[l][r] = dp[l + 1][r - 1];
                        }
                    }

                    if (r - l > max) {
                        max = r - l;
                        start = l;
                    }
                }
            }
            return s.substring(start, start + max);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}