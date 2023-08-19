package com.leetcode.two.hundred;

import com.leetcode.one.hundred.ListNode;
import com.leetcode.one.hundred.TreeNode;

/**
 * @Author: Arsenal
 * @Date: 2023-08-14 23:47
 * @Description: 有序链表转换二叉搜索树 -中等
 * 给定一个单链表的头节点  head ，其中的元素 按升序排序 ，将其转换为高度平衡的二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差不超过 1。
 * 示例 1:
 * 输入: head = [-10,-3,0,5,9]
 * 输出: [0,-3,9,-10,null,5]
 * 解释: 一个可能的答案是[0，-3,9，-10,null,5]，它表示所示的高度平衡的二叉搜索树。
 * 示例 2:
 * 输入: head = []
 * 输出: []
 * 提示:
 * head 中的节点数在[0, 2 * 104] 范围内
 * -105 <= Node.val <= 105
 * 109. Convert Sorted List to Binary Search Tree
 * Given the head of a singly linked list where elements are sorted in ascending order, convert it to a
 * height-balanced
 * binary search tree.
 * Example 1:
 * Input: head = [-10,-3,0,5,9]
 * Output: [0,-3,9,-10,null,5]
 * Explanation: One possible answer is [0,-3,9,-10,null,5], which represents the shown height balanced BST.
 * Example 2:
 * Input: head = []
 * Output: []
 * Constraints:
 * The number of nodes in head is in the range [0, 2 * 104].
 * -105 <= Node.val <= 105
 */
public class S109 {
    public static void main(String[] args) {
        ListNode head = new ListNode(-10);
        ListNode node1 = new ListNode(-3);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(9);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        TreeNode treeNode = sortedListToBST(head);
        System.out.println(treeNode);

    }

    public static TreeNode sortedListToBST(ListNode head) {
        return buildTree(head, null);
    }

    public static TreeNode buildTree(ListNode left, ListNode right) {
        if (left == right) {
            return null;
        }
        ListNode mid = getMedian(left, right);
        TreeNode root = new TreeNode(mid.val);
        root.left = buildTree(left, mid);
        root.right = buildTree(mid.next, right);
        return root;
    }

    public static ListNode getMedian(ListNode left, ListNode right) {
        ListNode fast = left;
        ListNode slow = left;
        while (fast != right && fast.next != right) {
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
