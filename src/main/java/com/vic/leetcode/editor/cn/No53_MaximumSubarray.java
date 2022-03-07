//给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 子数组 是数组中的一个连续部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：nums = [5,4,-1,7,8]
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。 
// Related Topics 数组 分治 动态规划 👍 4323 👎 0


package com.vic.leetcode.editor.cn;

public class No53_MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new No53_MaximumSubarray().new Solution();
        int i = solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
//        int i = solution.maxSubArray(new int[]{5,4,-1,7,8});
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 分治
    class Solution {

        // 对于一个区间 [l,r] 的4个量
        private class State {

            // 表示 [l,r] 内以 l 为左端点的最大子段和
            int lSum;

            // 表示 [l,r] 内以 r 为右端点的最大子段和
            int rSum;

            // 表示 [l,r] 内的最大子段和
            int mSum;

            // 表示 [l,r] 内的区间和
            int iSum;

            public State(int lSum, int rSum, int mSum, int iSum) {
                this.lSum = lSum;
                this.rSum = rSum;
                this.mSum = mSum;
                this.iSum = iSum;
            }
        }

        public int maxSubArray(int[] nums) {
            return getSub(nums, 0, nums.length - 1).mSum;
        }

        private State getSub(int[] nums, int l, int r) {
            if (l == r) {
                int num = nums[l];
                return new State(num, num, num, num);
            }
            int mid = (l + r) >> 1;
            State lSub = getSub(nums, l, mid);
            State rSub = getSub(nums, mid + 1, r);

            return pushUp(lSub, rSub);
        }

        private State pushUp(State lSub, State rSub) {
            // 它要么等于「左子区间」的 lSum，要么等于「左子区间」的 iSum 加上「右子区间」的 lSum，二者取大。
            int lSum = Math.max(lSub.lSum, lSub.iSum + rSub.lSum);
            // 它要么等于「右子区间」的 rSum，要么等于「右子区间」的 iSum 加上「左子区间」的 rSum，二者取大。
            int rSum = Math.max(lSub.rSum + rSub.iSum, rSub.rSum);
            // 「左子区间」的最大子段和、「右子区间」的最大子段和、可能是跨越左右区间, 取左的rSum和右的lSum之和, 三者取最大
            int mSum = Math.max(Math.max(lSub.mSum, rSub.mSum), lSub.rSum + rSub.lSum);
            // 区间和
            int iSum = lSub.iSum + rSub.iSum;
            return new State(lSum, rSum, mSum, iSum);
        }
    }

    // 动态规划
    class Solution1 {
        public int maxSubArray(int[] nums) {
            int max = nums[0];
            // 本轮合计
            int prev = 0;
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                // 本轮[合计结果]如果比当前值小, 则将当前值赋予prev
                prev = Math.max(prev + num, num);
                max = Math.max(max, prev);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}