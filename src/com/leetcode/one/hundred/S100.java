package com.leetcode.one.hundred;

/**
 * @Author: Arsenal
 * @Date: 2023-07-09 09:48
 * @Description: 相同的树 -简单
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * 示例 1：
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 * 示例 2：
 * 输入：p = [1,2], q = [1,null,2]
 * 输出：false
 * 示例 3：
 * 输入：p = [1,2,1], q = [1,1,2]
 * 输出：false
 * 提示：
 * 两棵树上的节点数目都在范围 [0, 100] 内
 * -104 <= Node.val <= 104
 * 100. Same Tree
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 * Example 1:
 * Input: p = [1,2,3], q = [1,2,3]
 * Output: true
 * Example 2:
 * Input: p = [1,2], q = [1,null,2]
 * Output: false
 * Example 3:
 * Input: p = [1,2,1], q = [1,1,2]
 * Output: false
 * Constraints:
 * The number of nodes in both trees is in the range [0, 100].
 * -104 <= Node.val <= 104
 */
public class S100 {
    public static void main(String[] args) {
        TreeNode p = new TreeNode();
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        p.left = node1;
        p.right = node3;


        TreeNode q = new TreeNode();
        TreeNode node2 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        q.left = node2;
        q.right = node4;

        System.out.println(isSameTree(p, q));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

}
