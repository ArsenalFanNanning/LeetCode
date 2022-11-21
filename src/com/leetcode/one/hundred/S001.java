package com.leetcode.one.hundred;

import java.util.Arrays;

/**
 * @Author: Arsenal
 * @Date: 2022-11-21 21:54
 * @Description: 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 * 提示：
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 * 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 * Constraints:
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Only one valid answer exists.
 */
public class S001 {
    public static void main(String[] args) {
        int[] nums = {3, 3};
        int target = 6;
        System.out.println(Arrays.toString(violence(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        return nums;
    }

    public static int[] violence(int[] nums, int target) {
        boolean f = false;
        int[] index = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int t = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (t == nums[j]) {
                    f = true;
                    index[0] = i;
                    index[1] = j;
                    break;
                }
            }
            if (f) {
                break;
            }
        }
        return index;
    }

}