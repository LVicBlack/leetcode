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

    // 递归
    //
    // 时间复杂度：O(n)，其中 n 是链表的长度。需要对链表的每个节点进行反转操作。
    // 空间复杂度：O(n)，其中 n 是链表的长度。空间复杂度主要取决于递归调用的栈空间，最多为 n 层。
    class Solution {
        public ListNode reverseList(ListNode head) {
            // 末尾节点开始出栈反转
            if (head == null || head.next == null) {
                return head;
            }
            ListNode newNode = reverseList(head.next);
            // newNode 不是末尾, newNode.next 不能直接指向 head
            // 新老链表末尾互指产生局域环。head.next是newNode的末尾非空节点
            // e.g. head = 3->4->null, ori: 1->2->3->4->null, new: null<-4<-5
            head.next.next = head;// 1->2->3<->4<-5
            // 切断, 初始链表尾部指向null
            head.next = null;// ori: 1->2->3->null, new: null<-3<-4<-5
            return newNode;
        }
    }

    // 遍历
    // 时间复杂度：O(n)，其中 n 是链表的长度。需要遍历链表一次。
    // 空间复杂度：O(1)。
    class Solution1 {
        public ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode cur = head;
            while (cur != null) {
                // 缓存遍历节点的下一个节点
                ListNode next = cur.next;
                // 反转
                cur.next = prev;
                prev = cur;
                // 下一节点
                cur = next;
            }
            return prev;
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