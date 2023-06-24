package com.leetcode.one.hundred;

/**
 * @Author: Arsenal
 * @Date: 2023-06-22 00:15
 * @Description: 不同的二叉搜索树 -中等
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的
 * 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 * 示例 1：
 * 输入：n = 3
 * 输出：5
 * 示例 2：
 * 输入：n = 1
 * 输出：1
 * 提示：
 * 1 <= n <= 19
 * 96. Unique Binary Search Trees
 * Given an integer n, return the number of structurally unique
 * BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.
 * Example 1:
 * Input: n = 3
 * Output: 5
 * Example 2:
 * Input: n = 1
 * Output: 1
 * Constraints:
 * 1 <= n <= 19
 */
public class S096 {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(numTrees(n));
    }

    public static int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}
