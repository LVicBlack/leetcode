//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：2
//解释：有两种方法可以爬到楼顶。
//1. 1 阶 + 1 阶
//2. 2 阶 
//
// 示例 2： 
//
// 
//输入：n = 3
//输出：3
//解释：有三种方法可以爬到楼顶。
//1. 1 阶 + 1 阶 + 1 阶
//2. 1 阶 + 2 阶
//3. 2 阶 + 1 阶
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 45 
// 
// Related Topics 记忆化搜索 数学 动态规划 👍 2162 👎 0


package com.vic.leetcode.editor.cn;

public class No70_ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new No70_ClimbingStairs().new Solution();
        System.out.println(solution.climbStairs(1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int climbStairs(int n) {
            if (n < 3) return n;
            int[] stairs = new int[n + 1];
            stairs[1] = 1;
            stairs[2] = 2;
            for (int i = 3; i <= n; i++) {
                stairs[i] = stairs[i - 1] + stairs[i - 2];
            }
            return stairs[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}