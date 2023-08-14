package com.leetcode.two.hundred;

import com.leetcode.one.hundred.TreeNode;

import java.util.Random;

/**
 * @Author: Arsenal
 * @Date: 2023-08-08 23:42
 * @Description: 将有序数组转换为二叉搜索树 -简单
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 * 示例 1：
 * 输入：nums = [-10,-3,0,5,9]
 * 输出：[0,-3,9,-10,null,5]
 * 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
 * 示例 2：
 * 输入：nums = [1,3]
 * 输出：[3,1]
 * 解释：[1,null,3] 和 [3,1] 都是高度平衡二叉搜索树。
 * 提示：
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 按 严格递增 顺序排列
 * 108. Convert Sorted Array to Binary Search Tree
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a
 * height-balanced
 * binary search tree.
 * Example 1:
 * Input: nums = [-10,-3,0,5,9]
 * Output: [0,-3,9,-10,null,5]
 * Explanation: [0,-10,5,null,-3,null,9] is also accepted:
 * Example 2:
 * Input: nums = [1,3]
 * Output: [3,1]
 * Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.
 * Constraints:
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums is sorted in a strictly increasing order.
 */
public class S108 {
    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        // TreeNode treeNode = sortedArrayToBST1(nums);
        // TreeNode treeNode = sortedArrayToBST2(nums);
        //TreeNode treeNode = sortedArrayToBST3(nums);
        TreeNode treeNode = sortedArrayToBST4(nums);
        System.out.println(treeNode);
    }


    public static TreeNode sortedArrayToBST1(int[] nums) {
        return helper1(nums, 0, nums.length - 1);
    }

    public static TreeNode helper1(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // 总是选择中间位置左边的数字作为根节点
        int mid = (left + right) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper1(nums, left, mid - 1);
        root.right = helper1(nums, mid + 1, right);
        return root;
    }

    public static TreeNode sortedArrayToBST2(int[] nums) {
        return helper2(nums, 0, nums.length - 1);
    }

    public static TreeNode helper2(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // 总是选择中间位置右边的数字作为根节点
        int mid = (left + right + 1) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper2(nums, left, mid - 1);
        root.right = helper2(nums, mid + 1, right);
        return root;
    }

    static Random rand = new Random();

    public static TreeNode sortedArrayToBST3(int[] nums) {
        return helper3(nums, 0, nums.length - 1);
    }

    public static TreeNode helper3(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // 选择任意一个中间位置数字作为根节点
        int mid = (left + right + rand.nextInt(2)) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper3(nums, left, mid - 1);
        root.right = helper3(nums, mid + 1, right);
        return root;
    }


    public static TreeNode sortedArrayToBST4(int[] nums) {
        return helper4(nums, 0, nums.length - 1);
    }

    public static TreeNode helper4(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // 选择任意一个中间位置数字作为根节点
        int mid = (left + right + rand.nextInt(2)) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper4(nums, left, mid - 1);
        root.right = helper4(nums, mid + 1, right);
        return root;
    }

}
