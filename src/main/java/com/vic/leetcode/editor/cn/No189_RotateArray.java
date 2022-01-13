//给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,2,3,4,5,6,7], k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右轮转 1 步: [7,1,2,3,4,5,6]
//向右轮转 2 步: [6,7,1,2,3,4,5]
//向右轮转 3 步: [5,6,7,1,2,3,4]
// 
//
// 示例 2: 
//
// 
//输入：nums = [-1,-100,3,99], k = 2
//输出：[3,99,-1,-100]
//解释: 
//向右轮转 1 步: [99,-1,-100,3]
//向右轮转 2 步: [3,99,-1,-100] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// -231 <= nums[i] <= 231 - 1 
// 0 <= k <= 105 
// 
//
// 
//
// 进阶： 
//
// 
// 尽可能想出更多的解决方案，至少有 三种 不同的方法可以解决这个问题。 
// 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？ 
// 
//
// 
// 
//
// 
// 
// Related Topics 数组 数学 双指针 
// 👍 1264 👎 0


package com.vic.leetcode.editor.cn;

public class No189_RotateArray {
    public static void main(String[] args) {
        Solution solution = new No189_RotateArray().new Solution();
//        solution.rotate(new int[]{1,2,3,4,5},2);
        System.out.println(solution.gcd(12, 16));
        System.out.println(solution.gcd(16, 12));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void rotate(int[] nums, int k) {
            // 环状替换
            int length = nums.length;
            k = k % length;
            int count = gcd(length, k);
            for (int i = 0; i < count; i++) {
                int next = i;
                int prev = nums[i];
                int temp;
                do {
                    next = (next + k) % length;
                    temp = nums[next];
                    nums[next] = prev;
                    prev = temp;
                } while (i != next);
            }
        }

        public void rotate2(int[] nums, int k) {
            // 数组翻转
            int length = nums.length;
            k = k % length;
            reverse(nums, 0, length - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, length - 1);
        }

        public void rotate1(int[] nums, int k) {
            // 使用额外的数组
            int length = nums.length;
            int[] news = new int[length];
            for (int i = 0; i < length; i++) {
                news[(k + i) % length] = nums[i];
            }
            System.arraycopy(news, 0, nums, 0, length);
        }

        public void reverse(int[] nums, int start, int end) {
            int temp;
            while (start < end) {
                temp = nums[end];
                nums[end] = nums[start];
                nums[start] = temp;
                start++;
                end--;
            }
        }

        public int gcd(int x, int y) {
            return y > 0 ? gcd(y, x % y) : x;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}