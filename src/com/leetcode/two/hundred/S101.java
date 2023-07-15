package com.leetcode.two.hundred;

import com.leetcode.one.hundred.TreeNode;

/**
 * @Author: Arsenal
 * @Date: 2023-07-13 23:08
 * @Description: 对称二叉树 -简单
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * 示例 1：
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 示例 2：
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 * 提示：
 * 树中节点数目在范围 [1, 1000] 内
 * -100 <= Node.val <= 100
 * 101. Symmetric Tree
 * Given the root of a binary tree, check whether
 * it is a mirror of itself (i.e., symmetric around its center).
 * Example 1:
 * Input: root = [1,2,2,3,4,4,3]
 * Output: true
 * Example 2:
 * Input: root = [1,2,2,null,3,null,3]
 * Output: false
 * Constraints:
 * The number of nodes in the tree is in the range [1, 1000].
 * -100 <= Node.val <= 100
 * Follow up: Could you solve it both recursively and iteratively?
 */
public class S101 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        root.left = node1;
        root.right = node3;

        System.out.println(isSymmetric(root));
    }

    public static boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public static boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }

}
