//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针 👍 1769 👎 0


package com.vic.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class No19_RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new No19_RemoveNthNodeFromEndOfList().new Solution();
        int i = 1;
        ListNode listNode = new ListNode(i++);
        listNode.next=new ListNode(i++);
        listNode.next.next=new ListNode(i++);
        listNode.next.next.next=new ListNode(i++);
        listNode.next.next.next.next=new ListNode(i++);
        System.out.print(listNode.val + "、");
        System.out.print(listNode.next.val+ "、");
//        System.out.print(listNode.next.next.val+ "、");
//        System.out.print(listNode.next.next.next.val+ "、");
//        System.out.println(listNode.next.next.next.next.val);

        System.out.println(solution.removeNthFromEnd(listNode,1).val);

        System.out.print(listNode.val + "、");
//        System.out.print(listNode.next.val+ "、");
//        System.out.print(listNode.next.next.val+ "、");
//        System.out.println(listNode.next.next.next.val);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            Map<Integer, ListNode> map = new HashMap<>();
            int index = 0;
            while (head.next != null) {
                map.put(index++, head);
                head = head.next;
            }
            map.put(index, head);
            int i = map.size() - n ;
            ListNode delNode = map.get(i);
            ListNode next = delNode.next;
            if (next == null) return null;
            delNode.val = next.val;
            delNode.next = next.next;
            return map.get(0);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static class ListNode {
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
    }
}