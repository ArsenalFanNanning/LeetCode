package com.leetcode.one.hundred;

/**
 * @Author: Arsenal
 * @Date: 2022-11-28 00:05
 * @Description: 整数反转-中等
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * 示例 1：
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 * 输入：x = 120
 * 输出：21
 * 示例 4：
 * 输入：x = 0
 * 输出：0
 * 提示：
 * -231 <= x <= 231 - 1
 * 7. Reverse Integer
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes
 * the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 * Example 1:
 * Input: x = 123
 * Output: 321
 * Example 2:
 * Input: x = -123
 * Output: -321
 * Example 3:
 * Input: x = 120
 * Output: 21
 * Constraints:
 * -231 <= x <= 231 - 1
 */
public class S007 {
    public static void main(String[] args) {
        int x = -2147483412;
        //System.out.println(violence(x));
        //System.out.println(reverse(x));
        System.out.println(optimize(x));
    }

    private static int optimize(int x) {
        int res = 0;
        while (x != 0) {
            //每次取末尾数字
            int tmp = x % 10;
            //判断是否 大于 最大32位整数
            if (res > 214748364 || (res == 214748364 && tmp > 7)) {
                return 0;
            }
            //判断是否 小于 最小32位整数
            if (res < -214748364 || (res == -214748364 && tmp < -8)) {
                return 0;
            }
            res = res * 10 + tmp;
            x /= 10;
        }
        return res;
    }

    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }

    public static int violence(int x) {
        if (x == 0) {
            return x;
        }

        boolean f = x < 0;
        String str = f ? (x + "").substring(1) : x + "";
        String numStr = "";
        int len = str.length();
        for (int i = len - 1; i >= 0; i--) {
            char ch = str.charAt(i);
            if ('0' == ch && numStr.isEmpty()) {
                continue;
            }
            numStr += ch;
        }

        System.out.println(numStr);

        numStr = getNumStr(numStr, f);
        int res = f ? -Integer.parseInt(numStr) : Integer.parseInt(numStr);
        return res;
    }

    private static String getNumStr(String numStr, boolean f) {

        int len = numStr.length();
        //-2147483648
        // 2143847412
        if (f && len == 10) {
            String min = (Integer.MIN_VALUE + "").substring(1);
            for (int i = 0; i < len; i++) {
                char ch1 = numStr.charAt(i);
                char ch2 = min.charAt(i);
                if (ch2 < ch1) {
                    return "0";
                } else if (ch1 < ch2) {
                    return numStr;
                }
            }
        }

        //2147483647
        //2143847412
        if (!f && len == 10) {
            String max = Integer.MAX_VALUE + "";
            for (int i = 0; i < len; i++) {
                char ch1 = numStr.charAt(i);
                char ch2 = max.charAt(i);
                if (ch1 < ch2) {
                    return numStr;
                } else if (ch2 < ch1) {
                    return "0";
                }
            }
        }
        return numStr;
    }
}
