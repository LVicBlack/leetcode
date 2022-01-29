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
// Related Topics 链表 双指针 👍 1772 👎 0


package com.vic.leetcode.editor.cn;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class No19_RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new No19_RemoveNthNodeFromEndOfList().new Solution();

        int i = 1;
        ListNode listNode = new ListNode(i++);
        listNode.next = new ListNode(i++);
        listNode.next.next = new ListNode(i++);
        listNode.next.next.next = new ListNode(i++);
        listNode.next.next.next.next = new ListNode(i++);
        System.out.println(listNode);
        System.out.println(solution.removeNthFromEnd(listNode, 2));
        System.out.println(listNode);
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
    // 回溯法
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            int traverse = traverse(head, n);
            if(traverse == n)
                return head.next;
            return head;
        }

        private int traverse(ListNode node, int n) {
            if(node == null)
                return 0;
            int num = traverse(node.next, n);
            if(num == n)
                node.next = node.next.next;
            return num + 1;
        }
    }
    // 双指针
    class Solution4 {

        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(0, head);
            ListNode first = dummy;
            ListNode second = dummy;
            // 双指针的间距
            int gap = 0;

            while (first != null) {
                first = first.next;
                if (gap++ > n) {
                    second = second.next;
                }
            }
            second.next = second.next.next;
            return dummy.next;
        }
    }

    // 栈
    class Solution3 {

        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(0, head);
            Deque<ListNode> stack = new LinkedList<>();
            ListNode cur = dummy;
            while (cur != null) {
                stack.push(cur);
                cur = cur.next;
            }
            for (int i = 0; i < n; i++) {
                stack.pop();
            }
            ListNode pre = stack.peek();
            pre.next = pre.next.next;
            return dummy.next;
        }
    }

    // 计算链表长度
    class Solution2 {

        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(0, head);
            int size = listSize(head);
            ListNode cur = dummy;
            for (int i = 1; i < size - n + 1; i++) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
            return dummy.next;
        }

        private int listSize(ListNode head) {
            int size = 1;
            while (head.next != null) {
                size++;
                head = head.next;
            }
            return size;
        }
    }

    // map
    class Solution1 {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            Map<Integer, ListNode> map = new HashMap<>();
            int index = 0;
            while (head.next != null) {
                map.put(index++, head);
                head = head.next;
            }
            map.put(index, head);
            int del = map.size() - n;
            if (n == 1) {
                if (del == 0) {
                    return null;
                } else {
                    map.get(del - 1).next = null;
                }
            } else {
                ListNode delNode = map.get(del);
                delNode.val = delNode.next.val;
                delNode.next = delNode.next.next;
            }
            return map.get(0);
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
    }
}