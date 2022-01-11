//给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。 
//
// 
// '.' 匹配任意单个字符 
// '*' 匹配零个或多个前面的那一个元素 
// 
//
// 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。 
// 
//
// 示例 1： 
//
// 
//输入：s = "aa" p = "a"
//输出：false
//解释："a" 无法匹配 "aa" 整个字符串。
// 
//
// 示例 2: 
//
// 
//输入：s = "aa" p = "a*"
//输出：true
//解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
// 
//
// 示例 3： 
//
// 
//输入：s = "ab" p = ".*"
//输出：true
//解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
// 
//
// 示例 4： 
//
// 
//输入：s = "aab" p = "c*a*b"
//输出：true
//解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
// 
//
// 示例 5： 
//
// 
//输入：s = "mississippi" p = "mis*is*p*."
//输出：false 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 20 
// 0 <= p.length <= 30 
// s 可能为空，且只包含从 a-z 的小写字母。 
// p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。 
// 保证每次出现字符 * 时，前面都匹配到有效的字符 
// 
// Related Topics 递归 字符串 动态规划 
// 👍 2275 👎 0


package com.vic.leetcode.editor.cn;

public class No10_RegularExpressionMatching {
    public static void main(String[] args) {
        Solution solution = new No10_RegularExpressionMatching().new Solution();
//        System.out.println(solution.isMatch("aaa", "a.a"));
//        System.out.println(solution.isMatch("aaa", "ab*ac*a"));
//        System.out.println(solution.isMatch("aaa", "aa.a"));
//        System.out.println(solution.isMatch("aaa", "ab*a"));
        System.out.println(solution.isMatch2("aaa", "a.a"));
        System.out.println(solution.isMatch2("aaa", "ab*ac*a"));
        System.out.println(solution.isMatch2("aaa", "aa.a"));
        System.out.println(solution.isMatch2("aaa", "ab*a"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isMatch(String s, String p) {
            boolean dp[][]=new boolean[s.length()+1][p.length()+1];//默认为false
            dp[0][0]=true;
            for(int i=0;i<=s.length();i++)
            {
                for(int j=1;j<=p.length();j++)
                {
                    if(p.charAt(j-1)=='*')//该位置为*
                    {
                        dp[i][j]=dp[i][j-2];//模式用了0次的看看是否能够匹配，能匹配最好，不能匹配继续
                        if(!dp[i][j])//不能匹配
                        {
                            if(i==0) {continue;}
                            else if(s.charAt(i-1)==p.charAt(j-2)||p.charAt(j-2)=='.')//可以匹配
                            {
                                dp[i][j]=dp[i-1][j];
                            }
                        }
                    }
                    else {//正常字符
                        if(i==0){continue;}
                        else if(s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='.') {//这个位置可以匹配
                            dp[i][j]=dp[i-1][j-1];
                        }
                    }
                }
            }
            return dp[s.length()][p.length()];
        }

        public boolean isMatch2(String s, String p) {
            //System.out.println(s+" "+p);
            if (p.length() == 0)// 模式串为false
            {
                if (s.length() == 0)
                    return true;
                return false;
            } else if (s.length() == 0) {// 匹配串为0
                if (p.length() % 2 == 1)
                    return false;
                else {
                    for (int i = 1; i < p.length(); i += 2) {
                        if (p.charAt(i) != '*')
                            return false;
                    }
                    return true;
                }
            } else if (p.length() == 1) {//匹配串长度为1
                if ((s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && s.length() == 1)//可以匹配
                    return true;
                else {
                    return false;
                }
            } else {// 两个串串正常长度
                if (p.charAt(1) == '*')//下一个为*
                {
                    if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')//可以匹配 分别用0次 用若1次 用若干次
                    {
                        return isMatch(s.substring(1), p) || isMatch(s.substring(1), p.substring(2)) || isMatch(s, p.substring(2));
                    } else {//不匹配只能用0次
                        return isMatch(s, p.substring(2));
                    }
                } else {
                    if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')
                        return isMatch(s.substring(1), p.substring(1));
                    else {//完全失败
                        return false;
                    }
                }
            }
        }
//leetcode submit region end(Prohibit modification and deletion)

    }
}