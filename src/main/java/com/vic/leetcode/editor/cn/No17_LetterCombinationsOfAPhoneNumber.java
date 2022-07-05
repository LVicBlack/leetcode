//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 哈希表 字符串 回溯 👍 1982 👎 0


package com.vic.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class No17_LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new No17_LetterCombinationsOfAPhoneNumber().new Solution();
//        System.out.println(solution.letterCombinations(""));
        System.out.println(solution.letterCombinations("230"));
        System.out.println(solution.letterCombinations("239"));
        System.out.println(solution.letterCombinations("23#"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private final String[] numberArray = new String[]{
                "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        public List<String> letterCombinations(String digits) {
            List<String> ans = new ArrayList<>();
            if(digits.length() ==0 ) return ans;
            backtrack(ans, digits, 0, new StringBuilder());
            return ans;
        }

        public void backtrack(List<String> ans, String digits, int index, StringBuilder sb) {
            // 回溯出口
            if (index == digits.length()) {
                ans.add(sb.toString());
                return;
            }
            char button = digits.charAt(index);
            if (!(Character.isDigit(button) && button >= 50)) {
                ans.add(sb.toString());
                return;
            }
            String number = numberArray[Integer.parseInt(String.valueOf(button))];
            for (int i = 0; i < number.length(); i++) {
                sb.append(number.charAt(i));
                // 做选择
                backtrack(ans, digits, index + 1, sb);
                // 撤销选择
                sb.deleteCharAt(index);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}