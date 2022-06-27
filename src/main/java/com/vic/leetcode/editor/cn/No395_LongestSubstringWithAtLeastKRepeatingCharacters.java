//给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串，
//要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aaabb", k = 3
//输出：3
//解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
// 
//
// 示例 2： 
//
// 
//输入：s = "ababbc", k = 2
//输出：5
//解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由小写英文字母组成 
// 1 <= k <= 10⁵ 
// 
// Related Topics 哈希表 字符串 分治 滑动窗口 👍 697 👎 0


package com.vic.leetcode.editor.cn;

public class No395_LongestSubstringWithAtLeastKRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new No395_LongestSubstringWithAtLeastKRepeatingCharacters().new Solution();

        System.out.println(solution.longestSubstring("bbaaacbd", 3));
        System.out.println(solution.longestSubstring("weitong", 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 分治 + 剪支
    class Solution {
        public int longestSubstring(String s, int k) {
            return longestSubstring(s, k, 0, s.length() - 1);
        }

        public int longestSubstring(String s, int k, int l, int r) {
            // 遍历得到每个字母的个数
            int[] charArray = new int[26];
            for (int i = l; i <= r; i++) {
                charArray[s.charAt(i) - 'a']++;
            }

            // 判断是否需要剪支
            boolean cut = false;
            for (int i = 0; i < 26; i++) {
                int charCount = charArray[i];
                if (charCount > 0 && charCount < k) {
                    cut = true;
                    break;
                }
            }

            if (!cut) return r - l + 1;

            // 剪支
            int length = 0, cutL = l, cutR = l;
            while (cutL <= r) {
                // 寻找剪支的起点(忽略不满足的条件的字符)
                while (cutL <= r
                        && charArray[s.charAt(cutL) - 'a'] > 0
                        && charArray[s.charAt(cutL) - 'a'] < k) cutL++;
                cutR = cutL + 1;
                // 寻找剪支的结点
                while (cutR <= r && charArray[s.charAt(cutR) - 'a'] >= k) cutR++;

                // 计算最长剪支长度，注意剪支的右节点是非法字符需减一
                if (cutR - 1 <= r && cutR - cutL > length)
                    length = Math.max(length, longestSubstring(s, k, cutL, cutR - 1));

                System.out.println(cutL + " ---- " + (cutR-1) + " ---- " + l + " ---- " + r);
                // 新的剪支起点
                cutL = cutR + 1;
            }
            return length;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}