//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针 
// 👍 1394 👎 0


package com.vic.leetcode.editor.cn;

public class No283_MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new No283_MoveZeroes().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 优化官方交换
        public void moveZeroes(int[] nums) {
            // 非零指针
            int index = 0;
            for (int i = 0; i < nums.length; i++) {
                // 数字不为零, 指针+1
                if (nums[i] != 0 && index++ != i) {
                    nums[index - 1] = nums[i];
                    nums[i] = 0;
                }
            }
        }

        // 官方交换方法
        public void moveZeroes0(int[] nums) {
            // 左指针指向当前已经处理好的序列的尾部，右指针指向待处理序列的头部。
            int n = nums.length, left = 0, right = 0;
            while (right < n) {
                if (nums[right] != 0) {
                    swap(nums, left, right);
                    left++;
                }
                right++;
            }
        }

        public void swap(int[] nums, int left, int right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}