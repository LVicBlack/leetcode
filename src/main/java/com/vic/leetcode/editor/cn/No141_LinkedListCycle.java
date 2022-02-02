//给你一个链表的头节点 head ，判断链表中是否有环。 
//
// 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到
//链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。 
//
// 如果链表中存在环 ，则返回 true 。 否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [3,2,0,-4], pos = 1
//输出：true
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2], pos = 0
//输出：true
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：head = [1], pos = -1
//输出：false
//解释：链表中没有环。
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 10⁴] 
// -10⁵ <= Node.val <= 10⁵ 
// pos 为 -1 或者链表中的一个 有效索引 。 
// 
//
// 
//
// 进阶：你能用 O(1)（即，常量）内存解决此问题吗？ 
// 👍 1340 👎 0


package com.vic.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class No141_LinkedListCycle {
    public static void main(String[] args) {
        Solution solution = new No141_LinkedListCycle().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)


    // 快慢指针 「Floyd 判圈算法」（又称龟兔赛跑算法）
    class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) {
                return false;
            }
            ListNode low = head;
            ListNode fast = head.next;
            while (fast != null && fast.next != null) {
                if (low == fast) {
                    return true;
                }
                low = low.next;
                fast = fast.next.next;
            }
            return false;
        }
    }

    // set比对
    class Solution1 {
        public boolean hasCycle(ListNode head) {
            Set<ListNode> set = new HashSet<>();
            while (head != null) {
                if (!set.add(head)) {
                    return true;
                }
                head = head.next;
            }
            return false;
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