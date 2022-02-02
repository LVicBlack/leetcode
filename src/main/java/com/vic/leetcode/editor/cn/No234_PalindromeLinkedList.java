//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,2,1]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围[1, 10⁵] 内 
// 0 <= Node.val <= 9 
// 
//
// 
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// 👍 1249 👎 0


package com.vic.leetcode.editor.cn;

public class No234_PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new No234_PalindromeLinkedList().new Solution();
        System.out.println(solution.isPalindrome(
                ListNode.convertArray(new int[]{1, 2, 2, 1})));
        System.out.println(solution.isPalindrome(
                ListNode.convertArray(new int[]{1, 2})));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    // 快慢指针
    class Solution {
        public boolean isPalindrome(ListNode head) {
            // 1. 找到前半部分的尾部节点
            ListNode firstHalfEndNode = endOfFirstHalf(head);
            // 2. 反转后半部分链表
            ListNode secondHalfEndNode = reverseList(firstHalfEndNode.next);

            boolean res = true;
            // 正向起点
            ListNode l1 = head;
            // 逆向起点
            ListNode l2 = secondHalfEndNode;
            // 3. 比对是否回文
            while (res && l2 != null) {
                if (l1.val != l2.val) res = false;
                l1 = l1.next;
                l2 = l2.next;
            }
            // 4. 恢复链表
            reverseList(secondHalfEndNode);
            // 5. 返回结果
            return res;
        }

        // 反转链表
        public ListNode reverseList(ListNode head) {
            ListNode newList = null;
            ListNode cur = head;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = newList;
                newList = cur;
                cur = next;
            }
            return newList;
        }

        // 找到前半部分的尾部节点
        public ListNode endOfFirstHalf(ListNode head) {
            ListNode low = head;
            ListNode fast = head;
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                low = low.next;
            }
            return low;
        }
    }

    // 添加到字符串, 双指针回文字符串
    // 时间复杂度：O(n) 空间复杂度：O(n)
    class Solution1 {
        public boolean isPalindrome(ListNode head) {
            String listStr = "";
            while (head != null) {
                listStr += head.val;
                head = head.next;
            }
            int index = 0;
            while (index < listStr.length() / 2) {
                if (listStr.charAt(index) == listStr.charAt(listStr.length() - 1 - index)) {
                    index++;
                } else {
                    return false;
                }
            }
            return true;
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