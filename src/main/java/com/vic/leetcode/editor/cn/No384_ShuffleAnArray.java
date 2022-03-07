//给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。打乱后，数组的所有排列应该是 等可能 的。 
//
// 实现 Solution class: 
//
// 
// Solution(int[] nums) 使用整数数组 nums 初始化对象 
// int[] reset() 重设数组到它的初始状态并返回 
// int[] shuffle() 返回数组随机打乱后的结果 
// 
//
// 
//
// 示例 1： 
//
// 
//输入
//["Solution", "shuffle", "reset", "shuffle"]
//[[[1, 2, 3]], [], [], []]
//输出
//[null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
//
//解释
//Solution solution = new Solution([1, 2, 3]);
//solution.shuffle();    // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。例如，返回 [3, 
//1, 2]
//solution.reset();      // 重设数组到它的初始状态 [1, 2, 3] 。返回 [1, 2, 3]
//solution.shuffle();    // 随机返回数组 [1, 2, 3] 打乱后的结果。例如，返回 [1, 3, 2]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// -10⁶ <= nums[i] <= 10⁶ 
// nums 中的所有元素都是 唯一的 
// 最多可以调用 5 * 10⁴ 次 reset 和 shuffle 
// 
// Related Topics 数组 数学 随机化 👍 268 👎 0


package com.vic.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Random;

public class No384_ShuffleAnArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 5, 6, 7};
        Solution solution = new No384_ShuffleAnArray().new Solution(nums);
        System.out.println(Arrays.toString(solution.shuffle()));
//        System.out.println(new Random().nextInt(1));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] nums;
        int[] original;

        public Solution(int[] nums) {
            this.nums = nums;
            this.original = new int[nums.length];
            System.arraycopy(nums, 0, original, 0, nums.length);
        }

        public int[] reset() {
            System.arraycopy(original, 0, nums, 0, nums.length);
            return nums;
        }

        public int[] shuffle() {
            int[] shuffled = new int[nums.length];
            // 随机数从0开始
            Random random = new Random();
            // 随机数组长度
            int len = nums.length;
            for (int i = 0; i < nums.length; ++i) {
                int index = random.nextInt(len);
                // 弹出后与最后一位替换, 随机数组长度减一
                int temp = nums[index];
                shuffled[i] = temp;
                nums[index] = nums[--len];
                nums[len] = temp;
            }
            System.arraycopy(shuffled, 0, nums, 0, nums.length);
            return nums;
        }

    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
//leetcode submit region end(Prohibit modification and deletion)

}