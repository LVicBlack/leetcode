////给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
////
//// 
////
//// 示例 1: 
////
//// 
////输入: s = "abcabcbb"
////输出: 3 
////解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//// 
////
//// 示例 2: 
////
//// 
////输入: s = "bbbbb"
////输出: 1
////解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//// 
////
//// 示例 3: 
////
//// 
////输入: s = "pwwkew"
////输出: 3
////解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//// 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//// 
////
//// 
////
//// 提示： 
////
//// 
//// 0 <= s.length <= 5 * 10⁴ 
//// s 由英文字母、数字、符号和空格组成 
//// 
//// Related Topics 哈希表 字符串 滑动窗口 👍 7733 👎 0
//


package com.vic.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class No3_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new No3_LongestSubstringWithoutRepeatingCharacters().new Solution();
        System.out.println(solution.lengthOfLongestSubstring("dvdf"));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
        System.out.println(solution.lengthOfLongestSubstring("abc"));
        System.out.println(solution.lengthOfLongestSubstring("abba"));
        System.out.println(solution.lengthOfLongestSubstring(""));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> map = new HashMap<>();
            // 最长字串长度
            int longest = 0;
            // 最长字串的左指针位置
            int left = 0;
            for (int i = 0; i < s.length(); i++) {
                char cur = s.charAt(i);
                if (map.containsKey(cur)) {
                    // 每次需要多判断，重复字符上次出现的位置+1 和 left的位置 取大值，避免重复
                    left = Math.max(map.get(cur) + 1, left);
                }
                // 每次都要更新字符位置
                map.put(cur, i);
                longest = Math.max(longest, i - left + 1);
            }
            return longest;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}