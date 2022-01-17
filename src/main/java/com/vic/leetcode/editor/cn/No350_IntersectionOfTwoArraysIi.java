//给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现
//次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2,2]
// 
//
// 示例 2: 
//
// 
//输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[4,9] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 1000 
// 
//
// 
//
// 进阶： 
//
// 
// 如果给定的数组已经排好序呢？你将如何优化你的算法？ 
// 如果 nums1 的大小比 nums2 小，哪种方法更优？ 
// 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？ 
// 
// Related Topics 数组 哈希表 双指针 二分查找 排序 
// 👍 633 👎 0


package com.vic.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class No350_IntersectionOfTwoArraysIi {
    public static void main(String[] args) {
        Solution solution = new No350_IntersectionOfTwoArraysIi().new Solution();
        solution.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 排序 + 双指针 时间复杂度：O(mlogm+nlogn) 空间复杂度：O(min(m,n))
        public int[] intersect(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            int length1 = nums1.length, length2 = nums2.length;
            int[] intersection = new int[Math.min(length1, length2)];
            int index1 = 0, index2 = 0, index = 0;
            while (index1 < length1 && index2 < length2) {
                if (nums1[index1] < nums2[index2]) {
                    index1++;
                } else if (nums1[index1] > nums2[index2]) {
                    index2++;
                } else {
                    intersection[index] = nums1[index1];
                    index1++;
                    index2++;
                    index++;
                }
            }
            return Arrays.copyOfRange(intersection, 0, index);
        }

        // 哈希表 时间复杂度：O(m+n)O(m+n) 空间复杂度：O(min(m,n))
        public int[] intersect1(int[] nums1, int[] nums2) {
            Map<Integer, Long> num1Map = IntStream.of(nums1).boxed()
                    .collect(Collectors.groupingBy(a -> a, Collectors.counting()));

            int[] nums = new int[nums2.length];
            int index = 0;
            for (int i = 0; i < nums2.length; i++) {
                int num = nums2[i];
                if (num1Map.containsKey(num) && num1Map.get(num) > 0) {
                    nums[index++] = num;
                    num1Map.put(num, num1Map.get(num) - 1);
                }
            }
            return Arrays.copyOfRange(nums, 0, index);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}