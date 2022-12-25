package com.leetcode.one.hundred;

/**
 * @Author: Arsenal
 * @Date: 2022-12-25 19:33
 * @Description: 缺失的第一个正数 -困难
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 * 示例 1：
 * 输入：nums = [1,2,0]
 * 输出：3
 * 示例 2：
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 * 示例 3：
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 * 提示：
 * 1 <= nums.length <= 5 * 105
 * -231 <= nums[i] <= 231 - 1
 * 41. First Missing Positive
 * Given an unsorted integer array nums, return the smallest missing positive integer.
 * You must implement an algorithm that runs in O(n) time and uses constant extra space.
 * Example 1:
 * Input: nums = [1,2,0]
 * Output: 3
 * Explanation: The numbers in the range [1,2] are all in the array.
 * Example 2:
 * Input: nums = [3,4,-1,1]
 * Output: 2
 * Explanation: 1 is in the array but 2 is missing.
 * Example 3:
 * Input: nums = [7,8,9,11,12]
 * Output: 1
 * Explanation: The smallest positive integer 1 is missing.
 * Constraints:
 * 1 <= nums.length <= 105
 * -231 <= nums[i] <= 231 - 1
 */
public class S041 {
    public static void main(String[] args) {
        int[] nums = {7, 8, 9, 11, 12};
        System.out.println(firstMissingPositive(nums));
    }

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; ++i) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
