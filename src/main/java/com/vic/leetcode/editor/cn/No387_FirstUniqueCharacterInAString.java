//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。 
//
// 
//
// 示例： 
//
// s = "leetcode"
//返回 0
//
//s = "loveleetcode"
//返回 2
// 
//
// 
//
// 提示：你可以假定该字符串只包含小写字母。 
// Related Topics 队列 哈希表 字符串 计数 
// 👍 493 👎 0


package com.vic.leetcode.editor.cn;

import java.util.LinkedHashMap;
import java.util.Map;

public class No387_FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        Solution solution = new No387_FirstUniqueCharacterInAString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstUniqChar(String s) {
            Map<Character, Integer> charsMap = new LinkedHashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (charsMap.containsKey(c)) {
                    charsMap.put(c, -1);
                } else {
                    charsMap.put(c, i);
                }
            }
            return charsMap.values().stream().filter(m -> m > -1).findFirst().orElse(-1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}