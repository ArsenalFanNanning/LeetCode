package com.leetcode.two.hundred;

import com.leetcode.one.hundred.TreeNode;

/**
 * @Author: Arsenal
 * @Date: 2023-08-21 23:49
 * @Description: 平衡二叉树 -简单
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 * 示例 2：
 * 输入：root = [1,2,2,3,3,null,null,4,4]
 * 输出：false
 * 示例 3：
 * 输入：root = []
 * 输出：true
 * 提示：
 * 树中的节点数在范围 [0, 5000] 内
 * -104 <= Node.val <= 104
 * 110. Balanced Binary Tree
 * Given a binary tree, determine if it is
 * height-balanced
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: true
 * Example 2:
 * Input: root = [1,2,2,3,3,null,null,4,4]
 * Output: false
 * Example 3:
 * Input: root = []
 * Output: true
 * Constraints:
 * The number of nodes in the tree is in the range [0, 5000].
 * -104 <= Node.val <= 104
 */
public class S110 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        root.left = node1;
        root.right = node3;

        // System.out.println(isBalanced(root));
        System.out.println(isBalancedOpt(root));
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }


    public static boolean isBalancedOpt(TreeNode root) {
        return heightOpt(root) >= 0;
    }

    public static int heightOpt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = heightOpt(root.left);
        int rightHeight = heightOpt(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

}
