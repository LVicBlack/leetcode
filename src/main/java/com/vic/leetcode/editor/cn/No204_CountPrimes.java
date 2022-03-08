//给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 10
//输出：4
//解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
// 
//
// 示例 2： 
//
// 
//输入：n = 0
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：n = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 5 * 10⁶ 
// 
// 👍 836 👎 0


package com.vic.leetcode.editor.cn;

import java.util.Arrays;

public class No204_CountPrimes {
    public static void main(String[] args) {
        Solution solution = new No204_CountPrimes().new Solution();
        System.out.println(solution.countPrimes(1));
        System.out.println(solution.countPrimes(2));
        System.out.println(solution.countPrimes(3));
        System.out.println(solution.countPrimes(10));
        System.out.println(solution.countPrimes(499979));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countPrimes(int n) {
            int[] nums = new int[n + 1];
            Arrays.fill(nums, 1);
            int len = 0;

            for (int i = 2; i < n; i++) {
                if (nums[i] == 1) {
                    len = len + 1;
                    // int可能会超过边界
                    if ((long) i * i < n) {
                        // 从 i*i 开始进行筛选标记合数（i*i前的数一定会被其他数的倍数标记）
                        for (int j = i * i; j < n; j += i) {
                            nums[j] = 0;
                        }
                    }
                }
            }
            return len;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}