//你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有
//版本都是错的。 
//
// 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。 
//
// 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误
//的版本。你应该尽量减少对调用 API 的次数。 
// 
//
// 示例 1： 
//
// 
//输入：n = 5, bad = 4
//输出：4
//解释：
//调用 isBadVersion(3) -> false 
//调用 isBadVersion(5) -> true 
//调用 isBadVersion(4) -> true
//所以，4 是第一个错误的版本。
// 
//
// 示例 2： 
//
// 
//输入：n = 1, bad = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= bad <= n <= 2³¹ - 1 
// 
// Related Topics 二分查找 交互 👍 568 👎 0


package com.vic.leetcode.editor.cn;

public class No278_FirstBadVersion {
    public static void main(String[] args) {
        Solution solution = new No278_FirstBadVersion().new Solution();
        System.out.println(solution.firstBadVersion(10));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

    class Solution extends VersionControl {

        public int firstBadVersion(int n) {
            int l = 0;
            int r = n;
            while (r != l) {
                int middle = (r - l) / 2 + l;
                if (isBadVersion(middle)) {
                    r = middle;
                } else {
                    l = middle + 1;
                }
            }
            return l;
        }

        public int firstBadVersion(int start, int end) {
            if (end - start <= 1) return isBadVersion(start) ? start : end;
            int middle = (end - start) / 2 + start;
            return isBadVersion(middle) ? firstBadVersion(start, middle) : firstBadVersion(middle, end);
        }
    }

    class Solution1 extends VersionControl {

        public int firstBadVersion(int n) {
            return firstBadVersion(0, n);
        }

        public int firstBadVersion(int start, int end) {
            if (end == start) return start;
            int middle = (end - start) / 2 + start;
            return isBadVersion(middle) ? firstBadVersion(start, middle) : firstBadVersion(middle + 1, end);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    private class VersionControl {
        public boolean isBadVersion(int version) {
            return version >= 3;
        }
    }
}