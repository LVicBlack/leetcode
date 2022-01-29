//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
// 
// 
// Related Topics 递归 链表 👍 2238 👎 0


package com.vic.leetcode.editor.cn;

public class No206_ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new No206_ReverseLinkedList().new Solution();

        int i = 1;
        ListNode listNode = new ListNode(i++);
        listNode.next = new ListNode(i++);
        listNode.next.next = new ListNode(i++);
        listNode.next.next.next = new ListNode(i++);
        listNode.next.next.next.next = new ListNode(i++);
        System.out.println(listNode);
        System.out.println(solution.reverseList(listNode));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

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
    }

    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode reverse = reverse(head);
            reverse.next = null;
            return reverse;
        }

        private ListNode reverse(ListNode node) {
            if (node.next == null) {
                return node;
            }
            ListNode prev = reverse(node.next);
            prev.next = node;
            return node;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}