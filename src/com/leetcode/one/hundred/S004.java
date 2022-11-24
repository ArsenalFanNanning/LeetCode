package com.leetcode.one.hundred;

import java.util.Arrays;

/**
 * @Author: Arsenal
 * @Date: 2022-11-25 00:02
 * @Description: 寻找两个正序数组的中位数-困难
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * 示例 1：
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 提示：
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 * <p>
 * Median of Two Sorted Arrays
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 * Example 1:
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * Example 2:
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 * Constraints:
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 */
public class S004 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(violence(nums1, nums2));
        //System.out.println(findMedianSortedArrays(nums1, nums2));
    }


    public static double violence(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;
        if (len == 0) {
            return 0;
        }
        double[] nums = new double[len];
        int i = 0, j = 0, k = 0;
        while (i < len1 || j < len2) {
            int a = i == len1 ? Integer.MAX_VALUE : nums1[i];
            int b = j == len2 ? Integer.MAX_VALUE : nums2[j];
            if (a <= b) {
                nums[k] = a;
                i++;
            } else {
                nums[k] = b;
                j++;
            }
            k++;
        }

        //System.out.println(Arrays.toString(nums));

        int mid = len / 2;
        if ((len & 1) == 1) {
            return nums[mid];
        } else {
            return (nums[mid - 1] + nums[mid]) / 2;
        }
    }
}
