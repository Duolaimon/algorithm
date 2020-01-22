package com.duol.leetcode.count_sub_strings;

/**
 * @author HeJiaGeng
 * @date 2020/1/22
 * @desc 马拉车算法，https://www.jianshu.com/p/392172762e55
 * <p>
 * 思路
 * <p>
 * 马拉车算法可以在线性时间内找出以任何位置为中心的最大回文串。
 * <p>
 * 算法
 * <p>
 * 假设一个回文串中心为 center，该中心对应的最大回文串右边界为 right。
 * 存在一个 i 为当前回文串中心，满足 i > center，那么也存在一个 j 与 i 关于 center 对称，可以根据 Z[i] 快速计算出 Z[j]。
 * <p>
 * 当 i < right 时，找出 i 关于 center 的对称点 j = 2 * center - i。
 * 此时以 i 为中心，半径为 right - i 的区间内存在的最大回文串的半径 Z[i] 等于 Z[j]。
 * <p>
 * 例如，对于字符串 A = '@#A#B#A#A#B#A#＄'，当 center = 7, right = 13, i = 10 时，
 * center 为两个字母 A 中间的 #，最大回文串右边界为最后一个 #，i 是最后一个 B，j 是第一个 B。
 * <p>
 * 在 [center - (right - center), right] 中，区间中心为 center，右边界为 right，i 和 j 关于 center 对称，且 Z[j] = 3，
 * 可以快速计算出 Z[i] = min(right - i, Z[j]) = 3。
 * <p>
 * 在 while 循环中，只有当 Z[i] 超过 right - i 时，才需要逐个比较字符。
 * 这种情况下，Z[i] 每增加 1，right 也会增加 1，且最多能够增加 2*N+2 次。因此这个过程是线性的。
 * <p>
 * 最后，对 Z 中每一项 v 计算 (v+1) / 2，然后求和。
 * 假设给定最大回文串中心为 C，半径为 R，那么以 C 为中心，半径为 R-1, R-2, ..., 0 的子串也都是回文串。
 * 例如 abcdedcba 是以 e 为中心，半径为 4 的回文串，那么 e，ded，cdedc，bcdedcb 和 abcdedcba 也都是回文串。
 * <p>
 * 除以 2 是因为实际回文串的半径为 v 的一半。例如回文串 a#b#c#d#e#d#c#b#a 的半径为实际原回文串半径的 2 倍。
 */
public class Solution3 implements Solution {
    @Override
    public int countSubstrings(String para1) {
        char[] chars = new char[2 * para1.length() + 3];
        chars[0] = '@';
        chars[1] = '#';
        chars[chars.length - 1] = '$';
        int t = 2;
        for (char c : para1.toCharArray()) {
            chars[t++] = c;
            chars[t++] = '#';
        }

        int[] p = new int[chars.length];
        int center = 0, right = 0;
        for (int i = 1; i < p.length - 1; ++i) {
            if (i < right) {
                p[i] = Math.min(right - i, p[2 * center - i]);
            }
            while (chars[i + p[i] + 1] == chars[i - p[i] - 1]){
                p[i]++;
            }
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
        }
        int ans = 0;
        for (int v : p) {
            ans += (v + 1) / 2;
        }
        return ans;
    }
}
