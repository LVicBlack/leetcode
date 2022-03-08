//给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。 
//
// 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3ˣ 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 27
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：n = 0
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：n = 9
//输出：true
// 
//
// 示例 4： 
//
// 
//输入：n = 45
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= n <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能不使用循环或者递归来完成本题吗？ 
// 👍 245 👎 0


package com.vic.leetcode.editor.cn;

public class No326_PowerOfThree {
    public static void main(String[] args) {
        Solution solution = new No326_PowerOfThree().new Solution();
        System.out.println(solution.isPowerOfThree(0));
        System.out.println(solution.isPowerOfThree(3));
        System.out.println(solution.isPowerOfThree(9));
        System.out.println(solution.isPowerOfThree(27));
        System.out.println(solution.isPowerOfThree(45));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 判断是否为最大 33 的幂的约数
    class Solution {
        public boolean isPowerOfThree(int n) {
            // 在题目给定的 32 位有符号整数的范围内，最大的 3 的幂为 3^19 = 1162261467
            return n > 0 && 1162261467 % n == 0;
        }
    }

    // 试除法
    class Solution1 {
        public boolean isPowerOfThree(int n) {
            while (n != 0 && n % 3 == 0) {
                n /= 3;
            }
            return n == 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}