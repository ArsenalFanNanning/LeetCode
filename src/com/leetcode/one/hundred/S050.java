package com.leetcode.one.hundred;

/**
 * @Author: Arsenal
 * @Date: 2023-01-07 23:50
 * @Description: Pow(x, n) -中等
 * 实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xn ）。
 * 示例 1：
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 示例 2：
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * 示例 3：
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 * 提示：
 * -100.0 < x < 100.0
 * -231 <= n <= 231-1
 * n 是一个整数
 * -104 <= xn <= 104
 * 50. Pow(x, n)
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 * Example 1:
 * Input: x = 2.00000, n = 10
 * Output: 1024.00000
 * Example 2:
 * Input: x = 2.10000, n = 3
 * Output: 9.26100
 * Example 3:
 * Input: x = 2.00000, n = -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 * Constraints:
 * -100.0 < x < 100.0
 * -231 <= n <= 231-1
 * n is an integer.
 * -104 <= xn <= 104
 */
public class S050 {
    public static void main(String[] args) {
        double x = 2.0;
        int n = 10;
        //System.out.println(myPow(x, n));
        System.out.println(myPowOpt(x, n));
    }

    public static double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public static double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }


    public static double myPowOpt(double x, int n) {
        long N = n;
        return N >= 0 ? quickMulOpt(x, N) : 1.0 / quickMulOpt(x, -N);
    }

    public static double quickMulOpt(double x, long N) {
        double ans = 1.0;
        // 贡献的初始值为 x
        double x_contribute = x;
        // 在对 N 进行二进制拆分的同时计算答案
        while (N > 0) {
            if (N % 2 == 1) {
                // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
                ans *= x_contribute;
            }
            // 将贡献不断地平方
            x_contribute *= x_contribute;
            // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
            N /= 2;
        }
        return ans;
    }
}
