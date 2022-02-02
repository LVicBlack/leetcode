//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
// 👍 2166 👎 0


package com.vic.leetcode.editor.cn;

public class No21_MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new No21_MergeTwoSortedLists().new Solution();
        int[] ints1 = new int[]{1, 4, 5};
        int[] ints2 = new int[]{1, 2, 3, 4, 6};
        ListNode listNode1 = ListNode.convertArray(ints1);
        ListNode listNode2 = ListNode.convertArray(ints2);
        ListNode listNode = solution.mergeTwoLists(listNode1, listNode2);

    }
    //leetcode submit region begin(Prohibit modification and deletion)


    // 迭代
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(-100);
            ListNode cur = dummy;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    cur.next = l1;
                    l1 = l1.next;
                } else {
                    cur.next = l2;
                    l2 = l2.next;
                }
                cur = cur.next;
            }
            cur.next = l1 == null ? l2 : l1;
            return dummy.next;
        }
    }

    // 递归
    class Solution1 {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }
            if (l1.val < l2.val) {
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            } else {
                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            }
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            if (this.next == null) {
                return String.valueOf(this.val);
            } else {
                return String.valueOf(this.val) + ", " + this.next.toString();
            }
        }

        static ListNode convertArray(int[] ints) {
            ListNode dummy = new ListNode();
            ListNode cur = dummy;
            for (int i : ints) {
                cur.next = new ListNode(i);
                cur = cur.next;
            }
            return dummy.next;
        }
    }
}