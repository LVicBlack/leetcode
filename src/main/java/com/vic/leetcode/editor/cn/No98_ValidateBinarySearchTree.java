//给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。 
//
// 有效 二叉搜索树定义如下： 
//
// 
// 节点的左子树只包含 小于 当前节点的数。 
// 节点的右子树只包含 大于 当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [2,1,3]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [5,1,4,null,null,3,6]
//输出：false
//解释：根节点的值是 5 ，但是右子节点的值是 4 。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围在[1, 10⁴] 内 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
// 👍 1404 👎 0


package com.vic.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class No98_ValidateBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new No98_ValidateBinarySearchTree().new Solution();
        boolean validBST = solution.isValidBST(new TreeNode(10,
                new TreeNode(1, new TreeNode(0), new TreeNode(2)),
                new TreeNode(13, new TreeNode(11), new TreeNode(14))));
        System.out.println(validBST);
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
    // 中序遍历
    class Solution {
        public boolean isValidBST(TreeNode root) {
            long value = Long.MIN_VALUE;
            Deque<TreeNode> stack = new LinkedList<>();
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                TreeNode first = stack.pop();
                if (first.val <= value) return false;
                value = first.val;
                root = first.right;
            }
            return true;
        }
    }

    // 递归
    class Solution1 {
        public boolean isValidBST(TreeNode root) {
            return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        public boolean isValidBST(TreeNode root, long low, long high) {
            if (root == null) return true;
            int val = root.val;
            if (val >= high || val <= low) return false;

            return isValidBST(root.left, low, val) && isValidBST(root.right, val, high);
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