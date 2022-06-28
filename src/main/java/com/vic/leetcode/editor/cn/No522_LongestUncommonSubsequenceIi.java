//给定字符串列表 strs ，返回其中 最长的特殊序列 。如果最长特殊序列不存在，返回 -1 。 
//
// 特殊序列 定义如下：该序列为某字符串 独有的子序列（即不能是其他字符串的子序列）。 
//
// s 的 子序列可以通过删去字符串 s 中的某些字符实现。 
//
// 
// 例如，"abc" 是 "aebdc" 的子序列，因为您可以删除"aebdc"中的下划线字符来得到 "abc" 。
// "aebdc"的子序列还包括
//"aebdc"、 "aeb" 和 "" (空字符串)。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入: strs = ["aba","cdc","eae"]
//输出: 3
// 
//
// 示例 2: 
//
// 
//输入: strs = ["aaa","aaa","aa"]
//输出: -1
// 
//
// 
//
// 提示: 
//
// 
// 2 <= strs.length <= 50 
// 1 <= strs[i].length <= 10 
// strs[i] 只包含小写英文字母 
// 
// Related Topics 数组 哈希表 双指针 字符串 排序 👍 149 👎 0


package com.vic.leetcode.editor.cn;

import java.util.Arrays;

public class No522_LongestUncommonSubsequenceIi {
    public static void main(String[] args) {
        Solution solution = new No522_LongestUncommonSubsequenceIi().new Solution();
        System.out.println(solution.findLUSlength(new String[]{"abcded", "abcde", "bcd", "acde", "dc"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findLUSlength(String[] strs) {
            // 字符串长度从大到小排序
            Arrays.sort(strs, (s1, s2) -> s2.length() - s1.length());

            int ans = -1;

            int length = strs.length;

            for (int i = 0; i < length; i++) {
                String str = strs[i];
                boolean flag = true;
                // LUS长度 > 比较的字符串长度，后续判断可以略过
                for (int j = 0; ans < str.length() && j < length; j++) {
                    if (i == j) continue;

                    String comp = strs[j];
                    //  LUS只会在同长度字符串中寻找，跳过小于自己长度的字符串
                    if (str.length() > comp.length()) break;

                    // 判断是否存在共同子序列, 存在则判断下一个字符串
                    if (hasCommonSub(str, comp)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) ans = Math.max(ans, str.length());
            }
            return ans;
        }

        /**
         * 判断时候含有公共子序列
         *
         * @param str1 所需判断的字符串
         * @param str2 比较对象
         * @return true - 存在公共子序列
         */
        public boolean hasCommonSub(String str1, String str2) {
            int i = 0, j = 0;
            while (i < str1.length() && j < str2.length()) {
                //  如果相同，向后移动一位，判断下个字符
                if (str1.charAt(i) == str2.charAt(j)) i++;
                j++;
            }
            return i == str1.length();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}