//给你一个二叉树的根节点 root ， 检查它是否轴对称。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,2,3,4,4,3]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,2,null,3,null,3]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 1000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1727 👎 0


package com.vic.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class No101_SymmetricTree {
    public static void main(String[] args) {
        Solution solution = new No101_SymmetricTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    // 迭代
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) return true;
            return check(root.left, root.right);
        }
        public boolean check(TreeNode node1, TreeNode node2) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(node1);
            queue.offer(node2);
            while (!queue.isEmpty()) {
                TreeNode first = queue.poll();
                TreeNode second = queue.poll();
                if (first == second) continue;
                if (first == null || second == null) return false;
                if (first.val != second.val) return false;

                queue.offer(first.left);
                queue.offer(second.right);

                queue.offer(first.right);
                queue.offer(second.left);
            }

            return true;
        }
    }
    // 递归
    class Solution1 {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) return true;
            return check(root.left, root.right);
        }

        public boolean check(TreeNode node1, TreeNode node2) {
            if (node1 == node2) return true;
            if (node1 == null || node2 == null) return false;
            return node1.val == node2.val && check(node1.left, node2.right) && check(node1.right, node2.left);
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}