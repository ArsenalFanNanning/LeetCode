package com.leetcode.one.hundred;

/**
 * @Author: Arsenal
 * @Date: 2022-12-24 18:32
 * @Description: 合并两个有序链表-简单
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 示例 1：
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 示例 2：
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 示例 3：
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 * 提示：
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 * 21. Merge Two Sorted Lists
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 * Example 1:
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * Example 2:
 * Input: list1 = [], list2 = []
 * Output: []
 * Example 3:
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 * Constraints:
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both list1 and list2 are sorted in non-decreasing order.
 */
public class S021 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        ListNode l12 = new ListNode(8);
        ListNode l13 = new ListNode(7);
        ListNode l14 = new ListNode(1);
        ListNode l15 = new ListNode(5);
        ListNode l16 = new ListNode(4);
        ListNode l17 = new ListNode(2);
        l1.next = l12;
        l12.next = l13;
        l13.next = l14;
        l14.next = l15;
        l15.next = l16;
        l16.next = l17;

        ListNode l2 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l23 = new ListNode(8);
        ListNode l24 = new ListNode(6);
        l2.next = l22;
        l22.next = l23;
        l23.next = l24;
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        return list1;
    }
}
