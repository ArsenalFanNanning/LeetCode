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
        //System.out.println(violence(nums1, nums2));
        System.out.println(optimize(nums1, nums2));
        //System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int left = 0, right = m;
        // median1：前一部分的最大值
        // median2：后一部分的最小值
        int median1 = 0, median2 = 0;

        while (left <= right) {
            // 前一部分包含 nums1[0 .. i-1] 和 nums2[0 .. j-1]
            // 后一部分包含 nums1[i .. m-1] 和 nums2[j .. n-1]
            int i = (left + right) / 2;
            int j = (m + n + 1) / 2 - i;

            // nums_im1, nums_i, nums_jm1, nums_j 分别表示 nums1[i-1], nums1[i], nums2[j-1], nums2[j]
            int nums_im1 = (i == 0 ? Integer.MIN_VALUE : nums1[i - 1]);
            int nums_i = (i == m ? Integer.MAX_VALUE : nums1[i]);
            int nums_jm1 = (j == 0 ? Integer.MIN_VALUE : nums2[j - 1]);
            int nums_j = (j == n ? Integer.MAX_VALUE : nums2[j]);

            if (nums_im1 <= nums_j) {
                median1 = Math.max(nums_im1, nums_jm1);
                median2 = Math.min(nums_i, nums_j);
                left = i + 1;
            } else {
                right = i - 1;
            }
        }

        return (m + n) % 2 == 0 ? (median1 + median2) / 2.0 : median1;
    }


    public static double optimize(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;
        if (len == 0) {
            return 0;
        }

        int mid = len / 2;
        boolean f = (len & 1) == 0;
        double sum = 0;
        double t = 0;
        int i = 0, j = 0, k = 0;
        while (i < len1 || j < len2) {
            int a = i == len1 ? Integer.MAX_VALUE : nums1[i];
            int b = j == len2 ? Integer.MAX_VALUE : nums2[j];
            if (a <= b) {
                t = a;
                i++;
            } else {
                t = b;
                j++;
            }

            if (f && k == mid - 1) {
                sum += t;
            }

            if (k == mid) {
                sum += t;
                if (f) {
                    return sum / 2;
                } else {
                    return sum;
                }
            }
            k++;
        }

        return sum;
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
