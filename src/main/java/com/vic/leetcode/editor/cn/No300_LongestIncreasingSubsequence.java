//给你一个整数数组 nums , 找到其中最长严格递增子序列的长度。 
//
// 子序列 是由数组派生而来的序列, 删除（或不删除）数组中的元素而不改变其余元素的顺序。例如, [3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子
//序列。 
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101], 因此长度为 4 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,3,2,3]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,7,7,7,7,7,7]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2500 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶： 
//
// 
// 你能将算法的时间复杂度降低到 O(n log(n)) 吗? 
// 
// Related Topics 数组 二分查找 动态规划 👍 2198 👎 0


package com.vic.leetcode.editor.cn;

import java.util.Arrays;

public class No300_LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new No300_LongestIncreasingSubsequence().new Solution();
        System.out.println(solution.lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7}));
        System.out.println(solution.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
        System.out.println(solution.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 贪心 + 二分查找
    class Solution {
        public int lengthOfLIS(int[] nums) {
            // 最长递增子序列长度(返回时+1)
            int longest = 0;
            int length = nums.length;
            // 对应长度上 的最长上升子序列的末尾元素的最小值
            int[] arr = new int[length];
            arr[0] = nums[0];
            for (int i = 1; i < length; i++) {
                // 如果 nums[i] > arr[longest] , 则直接加入到数组末尾, 并更新 longest + 1
                int num = nums[i];
                if (num > arr[longest]) {
                    arr[++longest] = num;
                    continue;
                }
                // 否则, 在 arr 数组中二分查找, 找到第一个比 nums[i] 小的数 arr[k] , 并更新 arr[k+1]=nums[i]。
                int l = 0, r = longest;
                // 更新找到的下一位(k+1), 如果比所有元素都小, 则更新第一位, 起始位置设为-1
                int pos = -1;
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (arr[mid] < num) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                arr[pos + 1] = num;
            }
            System.out.println(Arrays.toString(arr));
            return longest + 1;
        }
    }

    // 动态规划
    class Solution1 {
        public int lengthOfLIS(int[] nums) {
            int length = nums.length;
            int[] dp = new int[length];
            dp[0] = 1;
            int max = 1;
            for (int i = 1; i < length; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i]) {
                        dp[i] = Math.max(dp[j] + 1, dp[i]);
                    }
                }
                max = Math.max(max, dp[i]);
            }
            return max;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}